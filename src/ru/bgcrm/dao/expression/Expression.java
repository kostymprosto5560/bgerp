package ru.bgcrm.dao.expression;

import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.jexl3.JexlArithmetic;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import ru.bgcrm.util.TimeUtils;
import ru.bgcrm.util.Utils;

/**
 * Обработчик JEXL выражений.
 * Используются для проверки условий, выполнения скриптов.
 * 
 * http://commons.apache.org/jexl/reference/syntax.html#Functions
 */
public class Expression {
    private static final Logger log = Logger.getLogger(Expression.class);
    
    public static final String CHECK_EXPRESSION_CONFIG_KEY = "checkExpression";
    public static final String STRING_MAKE_EXPRESSION_CONFIG_KEY = "stringExpression";
    public static final String DO_EXPRESSION_CONFIG_KEY = "doExpression";

    private static final Class<Utils> PREFIX_u = Utils.class;
    private static final Class<TimeUtils> PREFIX_tu = TimeUtils.class;
    private static final Class<StringUtils> PREFIX_su = StringUtils.class;
    private static final Class<CollectionUtils> PREFIX_cu = CollectionUtils.class;

    private JexlEngine jexl;

    //TODO: Вроде как тут заложена возможность создавать классы по их полному названию, 
    //скорее всего для вызовов статических методов вида ru.bgcrm.Utils.doSomth().
    private JexlContext context = new MapContext() {
        @Override
        public boolean has(String name) {
            try {
                return super.has(name) || Class.forName(name) != null;
            } catch (ClassNotFoundException xnf) {
                return false;
            }
        }

        @Override
        public Object get(String name) {
            try {
                Object found = super.get(name);
                if (found == null && !super.has(name)) {
                    found = Class.forName(name);
                }
                return found;
            } catch (ClassNotFoundException xnf) {
                return null;
            }
        }
    };

    public Expression(Map<String, Object> contextVars) {
        JexlBuilder jexlBuilder = new JexlBuilder()
                .namespaces(contextVars) // нам нужен только неймспейс null
                .strict(true) // выброс исключений
                .arithmetic(new JexlArithmetic(false)); // но игнорирование null операндов
        jexl = jexlBuilder.create();

        //TODO: Для совместимости пока объекты декларируются и как объекты и как функции.
        //В будущем оставить только объекты, методы вызывать через точку.

        // стандартные объекты
        contextVars.put("u", PREFIX_u);
        contextVars.put("tu", PREFIX_tu);
        contextVars.put("su", PREFIX_su);
        contextVars.put("cu", PREFIX_cu);
        contextVars.put("log", log);

        contextVars.put("NEW_LINE", "\n");
        contextVars.put("NEW_LINE2", "\n\n");

        // все функции объявляются как переменные контекста
        contextVars.entrySet().stream().filter(me -> me.getKey() != null)
                .forEach(me -> context.set(me.getKey(), me.getValue()));

        // установка ссылки на экспрешшен
        contextVars.values().stream().filter(v -> v instanceof ExpressionBasedFunction)
                .forEach(v -> ((ExpressionBasedFunction) v).setExpression(this));
    }

    public Object getContextObject(String name) {
        return context.get(name);
    }

    public boolean check(String expression) {
        return (Boolean) jexl.createScript(expression).execute(context);
    }

    public String getString(String expression) {
        return (String) jexl.createScript(expression).execute(context);
    }

    public Object executeScript(String expression) {
        if (log.isDebugEnabled())
            log.debug("Executing script: " + expression);
        try {
            return jexl.createScript(expression).execute(context);
        } catch (JexlException e) {
            int lineNumber = Utils.parseInt(StringUtils.substringBetween(e.getMessage(), "@", ":"));
            String[] lines = expression.split("\\n");
            if (lineNumber > 0 && lineNumber <= lines.length)
                log.error("INCORRECT SCRIPT LINE: " + lines[lineNumber - 1]);
            throw e;
        }
    }
}
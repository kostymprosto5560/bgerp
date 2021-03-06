package ru.bgerp.plugin.blow.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import ru.bgcrm.util.ParameterMap;
import ru.bgerp.plugin.blow.Plugin;

public class BoardsConfig extends ru.bgcrm.util.Config {
    private SortedMap<Integer, BoardConfig> boardMap = new TreeMap<>();

    protected BoardsConfig(ParameterMap setup, boolean validate) {
        super(setup, validate);
        for (Map.Entry<Integer, ParameterMap> me : setup.subIndexed(Plugin.ID + ":board.").entrySet()) {
            BoardConfig b = new BoardConfig(me.getKey(), me.getValue());
            boardMap.put(b.getId(), b);
        }
    }
    
    public Collection<BoardConfig> getBoards() {
        return boardMap.values();
    }
    
    public BoardConfig getBoard(int id) {
        return boardMap.get(id);
    }
    
    public List<BoardConfig> getOpenBoards() {
        return boardMap.values().stream()
                .filter(b -> StringUtils.isNotBlank(b.getOpenUrl()))
                .collect(Collectors.toList());
    }
    
}
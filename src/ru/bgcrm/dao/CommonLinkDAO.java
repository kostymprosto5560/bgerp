package ru.bgcrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.bgcrm.dao.process.ProcessLinkDAO;
import ru.bgcrm.model.BGException;
import ru.bgcrm.model.CommonObjectLink;
import ru.bgcrm.model.Customer;
import ru.bgcrm.model.process.Process;
import ru.bgcrm.util.Preferences;
import ru.bgcrm.util.Utils;

public abstract class CommonLinkDAO extends CommonDAO {
    protected CommonLinkDAO(Connection con) {
        super(con);
    }

    public static CommonLinkDAO getLinkDAO(String objectType, Connection con) throws BGException {
        if (Process.OBJECT_TYPE.equals(objectType)) {
            return new ProcessLinkDAO(con);
        } else if (Customer.OBJECT_TYPE.equals(objectType)) {
            return new CustomerLinkDAO(con);
        }
        throw new BGException("Unsupported linker type: " + objectType);
    }

    /**
     * Возвращает список привязанных к объекту сущностей.
     * @param objectId код объекта.
     * @param typeLike MySQL Like выражение для фильтрации, необязательно.
     * @return
     * @throws BGException
     */
    public List<CommonObjectLink> getObjectLinksWithType(int objectId, String typeLike) throws BGException {
        return getObjectLinks(objectId, getTable(), getColumnName(), typeLike);
    }

    public CommonObjectLink prepareLink(CommonObjectLink link) {
        link.setObjectType(getObjectType());
        return link;
    }

    public void updateLinkTitles(int linkedObjectId, String linkedObjectTypeLike, String title) throws BGException {
        try {
            String query = "UPDATE " + getTable() + " SET object_title=? " + "WHERE object_id=? AND object_type LIKE ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setInt(2, linkedObjectId);
            ps.setString(3, linkedObjectTypeLike);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }
    }

    /**
     * Привязка объекта.
     * @param link
     * @throws BGException
     */
    public void addLink(CommonObjectLink link) throws BGException {
        addLink(getTable(), getColumnName(), link);
    }

    /**
     * Привязка объекта если он не привязан к данному объекту.
     * @param link
     * @throws BGException
     */
    public void addLinkIfNotExist(CommonObjectLink link) throws BGException {
        if (!isLinkExists(link)) {
            addLink(link);
        }
    }

    /**
     * Проверка наличия привязки.
     * @param link
     * @return
     * @throws BGException
     */
    public boolean isLinkExists(CommonObjectLink link) throws BGException {
        boolean result = false;

        try {
            String query = "SELECT COUNT(*) FROM " + getTable() + " WHERE " + getColumnName() + "=? AND object_type=? AND object_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, link.getObjectId());
            ps.setString(2, link.getLinkedObjectType());
            ps.setInt(3, link.getLinkedObjectId());

            ResultSet rs = ps.executeQuery();
            result = rs.next() && rs.getInt(1) > 0;
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }

        return result;
    }

    /**
     * Удаляет ссылку объекта на один другой объект.
     * @param link
     */
    public void deleteLink(CommonObjectLink link) throws BGException {
        deleteLink(getTable(), getColumnName(), link);
    }

    /**
     * Удаляет все ссылки объекта.
     * @param objectId
     * @throws SQLException
     */
    public void deleteObjectLinks(int objectId) throws BGException {
        try {
            String query = "DELETE FROM " + getTable() + " WHERE " + getColumnName() + "=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objectId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }
    }

    /**
     * Удаляет все ссылки объектов данного типа на какой-то другой объект.
     * @param link
     */
    public void deleteLinksTo(CommonObjectLink link) throws BGException {
        deleteLinksTo(getTable(), link);
    }

    /**
     * Удаляет все ссылки объектов данного типа на другие типы объектов.
     * @param link
     */
    public void deleteLinksWithType(CommonObjectLink link) throws BGException {
        deleteLinksWithType(getTable(), getColumnName(), link);
    }

    private List<CommonObjectLink> getObjectLinks(int objectId, String tableName, String columnName, String typeLike) throws BGException {
        List<CommonObjectLink> result = new ArrayList<CommonObjectLink>();

        try {
            StringBuilder query = new StringBuilder(200);
            query.append(SQL_SELECT);
            query.append("*");
            query.append(SQL_FROM);
            query.append(tableName);
            query.append(SQL_WHERE);
            query.append(columnName);
            query.append("=?");
            if (Utils.notBlankString(typeLike)) {
                query.append(" AND object_type LIKE ?");
            }
            query.append(SQL_ORDER_BY);
            query.append("object_type");

            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setInt(1, objectId);
            if (Utils.notBlankString(typeLike)) {
                ps.setString(2, typeLike);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CommonObjectLink link = new CommonObjectLink();
                link.setObjectId(objectId);
                link.setObjectType(getObjectType());
                link.setLinkedObjectType(rs.getString("object_type"));
                link.setLinkedObjectId(rs.getInt("object_id"));
                link.setLinkedObjectTitle(rs.getString("object_title"));
                link.setConfigMap(new Preferences(rs.getString("config")));

                result.add(link);
            }
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }

        return result;
    }

    private void addLink(String tableName, String columnName, CommonObjectLink link) throws BGException {
        try {
            StringBuilder query = new StringBuilder(200);

            query.append(SQL_INSERT);
            query.append(tableName);
            query.append("(");
            query.append(columnName);
            query.append(", object_type, object_id, object_title, config) VALUES (?,?,?,?,?)");

            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setInt(1, link.getObjectId());
            ps.setString(2, link.getLinkedObjectType());
            ps.setInt(3, link.getLinkedObjectId());
            ps.setString(4, link.getLinkedObjectTitle());
            ps.setString(5, link.getConfigMap().getDataString());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }
    }

    public void copyLinks(int objectFromId, int objectToId, String typePrefix) throws BGException {
        copyLinks(objectFromId, objectToId, typePrefix, null);
    }

    public void copyLinks(int objectFromId, int objectToId, String typePrefix, String excludeType) throws BGException {
        try {
            StringBuilder query = new StringBuilder(200);

            query.append(SQL_INSERT);
            query.append(getTable());
            query.append("(");
            query.append(getColumnName());
            query.append(", object_type, object_id, object_title, config) SELECT ? ");
            query.append(", object_type, object_id, object_title, config FROM ");
            query.append(getTable());
            query.append(SQL_WHERE);
            query.append(getColumnName());
            query.append("=?");

            if (Utils.notBlankString(typePrefix)) {
                query.append(" AND ( ");

                String[] tokens = typePrefix.split("\\s*,\\s*");
                final int length = tokens.length;

                for (int i = 0; i < length; i++) {
                    String likeToken = tokens[i];
                    if (i > 0) {
                        query.append(" OR ");
                    }
                    query.append("object_type LIKE '");
                    query.append(likeToken);
                    query.append("'");
                }

                query.append(" ) ");
            }

            if (Utils.notBlankString(excludeType)) {
                query.append(" AND object_type NOT LIKE '");
                query.append(excludeType);
                query.append("'");
            }

            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setInt(1, objectToId);
            ps.setInt(2, objectFromId);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }
    }

    private void deleteLink(String tableName, String columnName, CommonObjectLink link) throws BGException {
        try {
            StringBuilder query = new StringBuilder(200);

            query.append(SQL_DELETE);
            query.append(tableName);
            query.append(SQL_WHERE);
            query.append(columnName);
            query.append("=? AND object_type=? AND object_id=?");

            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setInt(1, link.getObjectId());
            ps.setString(2, link.getLinkedObjectType());
            ps.setInt(3, link.getLinkedObjectId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }
    }

    private void deleteLinksTo(String tableName, CommonObjectLink link) throws BGException {
        try {
            StringBuilder query = new StringBuilder(200);

            query.append(SQL_DELETE);
            query.append(tableName);
            query.append(SQL_WHERE);
            query.append("object_type=? AND object_id=?");

            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setString(1, link.getLinkedObjectType());
            ps.setInt(2, link.getLinkedObjectId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }
    }

    private void deleteLinksWithType(String tableName, String columnName, CommonObjectLink link) throws BGException {
        try {
            StringBuilder query = new StringBuilder(200);

            query.append(SQL_DELETE);
            query.append(tableName);
            query.append(SQL_WHERE);
            query.append(columnName);
            query.append("=? AND object_type LIKE '");
            query.append(link.getLinkedObjectType());
            query.append("%'");

            PreparedStatement ps = con.prepareStatement(query.toString());
            ps.setInt(1, link.getObjectId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new BGException(e);
        }
    }

    protected abstract String getTable();

    protected abstract String getColumnName();

    protected abstract String getObjectType();
}
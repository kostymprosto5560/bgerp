package ru.bgcrm.util.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.bgcrm.util.TimeUtils;
import ru.bgcrm.util.Utils;

/**
 * Класс предназначен для построения всяческих динамических запросов, с использованием при этом PreparedStatements.
 * В этом случае подстановка параметров идёт сразу с выстраиванием запроса.
 */
public class PreparedDelay {
	private Connection con;
	private StringBuilder query;

	private List<Object> psSets = new ArrayList<>();
	private PreparedStatement ps;

	private int pos;

	public PreparedDelay(Connection con) {
		this.con = con;
	}
	
	public PreparedDelay(Connection con, String query) {
		this.con = con;
		addQuery(query);
	}

	public int getPos() {
		return pos;
	}

	public PreparedStatement getPrepared() {
		return ps;
	}

	public StringBuilder getQuery() {
		return query;
	}

	/**
	 * Добавляет часть запроса.
	 * @param value
	 */
	public void addQuery(String value) {
		if (Utils.isBlankString(value)) {
			return;
		}

		if (query == null) {
			query = new StringBuilder();
		}
		query.append(value);
	}
	
	/**
	 * Заменяет запрос, сбрасывает в null prepared statement.
	 * @param value
	 */
	public void setQuery(String value) {
	    query.setLength(0);
	    query.append(value);
	    
	}

	/**
	 * Добавить целочисленный параметр запроса.
	 * @param value
	 */
	public void addInt(int value) {
		psSets.add(value);
	}

	/** Добавить long параметр запроса.
	 * @param value
	 */
	public void addLong(long value) {
		psSets.add(value);
	}

	/** Добавить Decimal параметр запроса.
	 * @param value
	 */
	public void addBigDecimal(BigDecimal value) {
		psSets.add(value);
	}

	/**
	 * Добавить строковый параметр запроса.
	 * @param value
	 */
	public void addString(String value) {
		psSets.add(value);
	}

	/**
	 * Добавить параметр запроса типа Дата
	 * @param value
	 */
	public void addDate(Date value) {
		psSets.add(TimeUtils.convertDateToSqlDate(value));
	}

	/**
	 * Добавляет параметр типа Timestamp.
	 * @param value
	 */
	public void addTimestamp(Timestamp value) {
		psSets.add(value);
	}

	/**
	 * Добавляет параметр типа Boolean.
	 * @param value
	 */
	public void addBoolean(Boolean value) {
		psSets.add(value);
	}
	
	/**
	 * Добавляет произвольный набор параметров.
	 * @param values
	 */
	public void addObjects(Object... values) {
	    for (Object value : values)
	        psSets.add(value);
	}
	
	public ResultSet executeQuery() throws SQLException {
		prepareStatementAndSetParameters();
		return ps.executeQuery();
	}

	public int executeUpdate() throws SQLException {
		prepareStatementAndSetParameters();
		return ps.executeUpdate();
	}

	private void prepareStatementAndSetParameters() throws SQLException {
		if (ps == null) {
			ps = con.prepareStatement(query.toString());
		}
		setParameters();
	}

	protected void setParameters() throws SQLException {
		final int size = psSets.size();
		for (int i = 0; i < size; i++) {
			ps.setObject(i + 1, psSets.get(i));
		}
	}

	public void close() throws SQLException {
		if (ps != null)
		    ps.close();
		ps = null;
		psSets.clear();
	}
}
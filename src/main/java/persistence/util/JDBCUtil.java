package persistence.util;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class JDBCUtil {
	private String sql = null;
	private Object[] parameters = null;;
	private static DataSource ds = null;
	private static Connection conn = null;
	private PreparedStatement pstmt = null;
	private CallableStatement cstmt = null;
	private ResultSet rs = null;

	public JDBCUtil() {
		initJDBCUtil();
	}

	public JDBCUtil(String sql) {
		this.setSql(sql);
		initJDBCUtil();
	}

	public JDBCUtil(String sql, Object[] parameters) {
		this.setSql(sql);
		this.setParameters(parameters);
		initJDBCUtil();
	}

	private static void initJDBCUtil() {
		try {
			if (ds == null) {
				BasicDataSource bds = new BasicDataSource();
				bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
				bds.setUsername("dbpro0202");
				bds.setPassword("Genius022");
				bds.setUrl("jdbc:oracle:thin:@202.20.119.117:1521:orcl");
				ds = bds;
				// Context init = new InitialContext();
				// ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDS");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void setSqlAndParameters(String sql, Object[] parameters) {
		this.sql = sql;
		this.parameters = parameters;
	}

	public String getSql() {
		return this.sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	private Object getParameter(int index) throws Exception {
		if (index >= getParameterSize())
			throw new Exception("INDEX 값이 파라미터 갯수보다 많습니다.");
		return parameters[index];
	}

	private int getParameterSize() {
		return parameters == null ? 0 : parameters.length;
	}

	private PreparedStatement getPreparedStatement() throws SQLException {
		if (conn == null) {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		}
		if (pstmt != null) pstmt.close();
		pstmt = conn.prepareStatement(sql);
		// JDBCUtil.printDataSourceStats(ds);
		return pstmt;
	}

	public ResultSet executeQuery() {
		try {
			pstmt = getPreparedStatement();
			for (int i = 0; i < getParameterSize(); i++) {
				pstmt.setObject(i + 1, getParameter(i));
			}
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public int executeUpdate() throws SQLException, Exception {
		pstmt = getPreparedStatement();
		int parameterSize = getParameterSize();
		for (int i = 0; i < parameterSize; i++) {
			if (getParameter(i) == null) {
				pstmt.setString(i + 1, null);
			} else {
				pstmt.setObject(i + 1, getParameter(i));
			}
		}
		return pstmt.executeUpdate();
	}

	private CallableStatement getCallableStatement() throws SQLException {
		if (conn == null) {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		}
		if (cstmt != null) cstmt.close();
		cstmt = conn.prepareCall(sql);
		return cstmt;
	}

	public boolean execute(JDBCUtil source) throws SQLException, Exception {
		cstmt = getCallableStatement();
		for (int i = 0; i < source.getParameterSize(); i++) {
			cstmt.setObject(i + 1, source.getParameter(i));
		}
		return cstmt.execute();
	}

	public void close() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (cstmt != null) {
			try {
				cstmt.close();
				cstmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void commit() {
		try {
			conn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void rollback() {
		try {
			conn.rollback();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void shutdownPool() {
		this.close();
		BasicDataSource bds = (BasicDataSource) ds;
		try {
			bds.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void printDataSourceStats(DataSource ds) throws SQLException {
		BasicDataSource bds = (BasicDataSource) ds;
		System.out.println("NumActive: " + bds.getNumActive());
		System.out.println("NumIdle: " + bds.getNumIdle());
	}
}

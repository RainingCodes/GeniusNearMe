package persistence.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import service.dto.*;
import persistence.util.JDBCUtil;
import persistence.DAOFactory;
import persistence.dao.*;

public class ReportDAOImpl implements ReportDAO {
	private JDBCUtil jdbcUtil = null;

	// Member의 기본 정보를 포함하는 query문
	private static String query = "";

	// 생성자
	public ReportDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	public List<ReportDTO> getReportList() {
		return null;
	}

	public int insertReport(ReportDTO Report) {
		return 0;
	}

	public int deleteReport(int dCode) {
		return 0;
	}

	public ReportDTO getReportByReportId(String reportId) {
		return null;
	}
}

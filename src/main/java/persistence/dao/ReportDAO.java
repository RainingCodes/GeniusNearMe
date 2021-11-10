package persistence.dao;

import java.util.List;
import service.dto.ReportDTO;

public interface ReportDAO {

	public List<ReportDTO> getReportList();		// 전체 신고 정보를 획득
	public int insertReport(ReportDTO Report);	// 신고정보를 추가
	public int deleteReport(int dCode);		// 신고정보를 삭제
	public ReportDTO getReportByReportId(String reportId);		// 신고정보를 신고id로 찾음
}
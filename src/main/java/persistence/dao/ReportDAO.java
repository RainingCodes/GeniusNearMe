package persistence.dao;

import java.util.List;
import service.dto.ReportDTO;

public interface ReportDAO {

	public List<ReportDTO> getReportList();		// ��ü �Ű� ������ ȹ��
	public int insertReport(ReportDTO Report);	// �Ű������� �߰�
	public int deleteReport(int dCode);		// �Ű������� ����
	public ReportDTO getReportByReportId(String reportId);		// �Ű������� �Ű�id�� ã��
}
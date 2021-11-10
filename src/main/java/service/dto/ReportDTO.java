package service.dto;

import java.util.Date;

public class ReportDTO {
	private int reportId = -1;
	private String sourceId = null;
	private String content = null;
	private Date writtenDate = null; // Date°´Ã¼ ¸Â´ÂÁö????
	private String writerId = null;
	private int reportedUserId = -1;
	private String reportCategoryName = null;
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public int getReportedUserId() {
		return reportedUserId;
	}
	public void setReportedUserId(int reportedUserId) {
		this.reportedUserId = reportedUserId;
	}
	public String getReportCategoryName() {
		return reportCategoryName;
	}
	public void setReportCategoryName(String reportCategoryName) {
		this.reportCategoryName = reportCategoryName;
	}
	
	
}

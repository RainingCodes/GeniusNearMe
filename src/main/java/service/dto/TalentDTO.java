package service.dto;
import java.util.Date;

public class TalentDTO {
	private int talentId;
	private String title;
	private int postType;
	private String content;
	private Date startDate;
	private Date deadLine;
	private Date writtenDate;
	private int matchingCounts;
	private int writerId;
	private String TalentCategoryName;
	
	
	public int getTalentId() {
		return talentId;
	}
	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPostType() {
		return postType;
	}
	public void setPostType(int postType) {
		this.postType = postType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	public int getMatchingCounts() {
		return matchingCounts;
	}
	public void setMatchingCounts(int matchingCounts) {
		this.matchingCounts = matchingCounts;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public String getTalentCategoryName() {
		return TalentCategoryName;
	}
	public void setTalentCategoryName(String talentCategoryName) {
		TalentCategoryName = talentCategoryName;
	}
	
	
	
}
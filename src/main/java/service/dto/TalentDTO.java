package service.dto;
import java.util.Date;

public class TalentDTO {
	private int talentId = -1;
	private String title = null;
	private String content = null;
	private Date startDate = null;
	private Date deadLine = null;
	private Date writtenDate = null;
	private int matchingCounts = -1;
	private int writerId = -1;
	private String talentCategoryName = null;	
	private int postType = -1;
	private int price;
	
	public TalentDTO() {	}
	
	public TalentDTO(String title, String content, Date startDate, Date deadLine, Date writtenDate,
			int writerId, int price) {
		super();
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.deadLine = deadLine;
		this.writtenDate = writtenDate;
		this.writerId = writerId;
		this.price = price;
	}
	
	public TalentDTO(String title, String content, Date startDate, Date deadLine, Date writtenDate,
			int matchingCounts, int writerId, String talentCategoryName, int postType, int price) {
		super();
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.deadLine = deadLine;
		this.writtenDate = writtenDate;
		this.matchingCounts = matchingCounts;
		this.writerId = writerId;
		this.talentCategoryName = talentCategoryName;
		this.postType = postType;
		this.price = price;
	}

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
		return talentCategoryName;
	}
	public void setTalentCategoryName(String talentCategoryName) {
		this.talentCategoryName = talentCategoryName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
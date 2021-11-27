package service.dto;

public class TalentTestDTO {
	private String resultCategory;
	private String resultType;
	private int userId;
	
	public TalentTestDTO() {
		this.resultCategory = null;
		this.resultType = null;
		this.userId = -1;
	}
	
	public TalentTestDTO(String resultCategory, String resultType, int userId) {
		super();
		this.resultCategory = resultCategory;
		this.resultType = resultType;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "TalentTestDTO [resultCategory=" + resultCategory + ", resultType=" + resultType + ", userId=" + userId
				+ "]";
	}

	public String getResultCategory() {
		return resultCategory;
	}
	public void setResultCategory(String resultCategory) {
		this.resultCategory = resultCategory;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}

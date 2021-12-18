package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TalentTest implements Serializable {
	private int userId;
	private String resultCategory;
	private String resultType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public TalentTest() {
		this.resultCategory = null;
		this.resultType = null;
		this.userId = -1;
	}
	
	public TalentTest(String resultCategory, String resultType, int userId) {
		super();
		this.resultCategory = resultCategory;
		this.resultType = resultType;
		this.userId = userId;
	}
}

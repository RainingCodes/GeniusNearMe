package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Wish implements Serializable{
	private int talentId;
	private int userId;
	
	public int getTalentId() {
		return talentId;
	}
	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}

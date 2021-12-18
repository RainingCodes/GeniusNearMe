package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Wish implements Serializable{
	private int talentID;
	private int userId;
	
	public int getTalentID() {
		return talentID;
	}
	public void setTalentID(int talentID) {
		this.talentID = talentID;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}

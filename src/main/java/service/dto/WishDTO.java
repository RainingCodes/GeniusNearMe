package service.dto;

public class WishDTO {
	private int talentID = -1;
	private int userId = -1;
	
	public  WishDTO() {
		
	}
	public WishDTO(int talentID, int userId) {
		super();
		this.talentID = talentID;
		this.userId = userId;
	}
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

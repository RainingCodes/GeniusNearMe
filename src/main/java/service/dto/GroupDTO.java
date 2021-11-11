package service.dto;

public class GroupDTO {
	private int[] userId = null;
	private int groupId = -1;
	private int talentId = -1;
	private int representativeId = -1;
	public int getRepresentativeId() {
		return representativeId;
	}
	public void setRepresentativeId(int representativeId) {
		this.representativeId = representativeId;
	}
	public int[] getUserId() {
		return userId;
	}
	public void setUserId(int[] userId) {
		this.userId = userId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getTalentId() {
		return talentId;
	}
	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}
}

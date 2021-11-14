package service.dto;

public class GroupDTO {
	private int[] userId = null;
	private int groupId = -1;
	private int talentId = -1;
	private int state = 0;
	private int representativeId = -1;
	private int membersCount = 0;
	private int maximum = 0;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getMembersCount() {
		return membersCount;
	}
	public void setMembersCount(int membersCount) {
		this.membersCount = membersCount;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getCountMembers() {
		return membersCount;
	}
	public void setCountMembers(int membersCount) {
		this.membersCount = membersCount;
	}
	public int getGroupId() {
		return groupId;
	}
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
	public int getGroupId(int talentId) {
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
	public GroupDTO(int[] userId, int talentId, int state, int representativeId, int membersCount, int maximum) {
		super();
		this.userId = userId;
		this.talentId = talentId;
		this.state = state;
		this.representativeId = representativeId;
		this.membersCount = membersCount;
		this.maximum = maximum;
	}
	public GroupDTO() {
		
	}
	
}

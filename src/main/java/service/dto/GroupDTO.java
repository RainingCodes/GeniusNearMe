package service.dto;

public class GroupDTO {
	private int[] userId = null;
	private int groupId = -1;
	private int talentId = -1;
	private int matchingId = -1;
	private int headCount = 0;
	public int getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}
	private int representativeId = -1;
	
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public int getCountMembers() {
		return headCount;
	}
	public void setCountMembers(int membersCount) {
		this.headCount = membersCount;
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
	
	public GroupDTO(int talentId) {
		super();
		this.talentId = talentId;
	}
	public GroupDTO() {
		
	}
	public GroupDTO(int[] userId, int groupId, int talentId, int representativeId, int headCount) {
		super();
		this.userId = userId;
		this.groupId = groupId;
		this.talentId = talentId;
		this.representativeId = representativeId;
		this.headCount = headCount;
	}
	
}

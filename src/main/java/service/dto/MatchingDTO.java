package service.dto;

public class MatchingDTO {
//매칭 dto
	
	private int matchingId = -1;
	private int matchingState = -1;
	private int talentId = -1;
	private int groupId = -1;
	private int userId = -1;
	private int isGroupMatching = -1; //그룹매칭인지 아닌지 알려주는 변수
	
	public int getIsGroupMatching() {
		return isGroupMatching;
	}
	public void setIsGroupMatching(int isGroupMatching) {
		this.isGroupMatching = isGroupMatching;
	}
	public int getTalentId() {
		return talentId;
	}
	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}
	public int getMatchingState() {
		return matchingState;
	}
	public void setMatchingState(int matchingState) {
		this.matchingState = matchingState;
	}
		

}

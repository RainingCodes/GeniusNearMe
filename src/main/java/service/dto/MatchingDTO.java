package service.dto;

public class MatchingDTO {
//��Ī dto
	
	private int matchingId = -1;
	private int matchingState = -1;
	private int talentId = -1;
	private int groupId = -1;
	private int userId = -1;
	private int isGroupMatching = -1; //�׷��Ī���� �ƴ��� �˷��ִ� ����
	private int choose = -1; //��Ī�� ����Ǵ��� �ȵǴ��� �˷��ִ� ����
	
	public int getIsGroupMatching() {
		return isGroupMatching;
	}
	public void setIsGroupMatching(int isGroupMatching) {
		this.isGroupMatching = isGroupMatching;
	}
	public int getChoose() {
		return choose;
	}
	public void setChoose(int choose) {
		this.choose = choose;
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

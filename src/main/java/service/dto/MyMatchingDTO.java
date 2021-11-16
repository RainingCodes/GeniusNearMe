package service.dto;

public class MyMatchingDTO {
	int matchingId;
	int talentId;
	String talentTitle;
	int matchingState;
	
	public int getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}
	public String getTalentTitle() {
		return talentTitle;
	}
	public void setTalentTitle(String talentTitle) {
		this.talentTitle = talentTitle;
	}
	public int getMatchingState() {
		return matchingState;
	}
	public void setMatchingState(int matchingState) {
		this.matchingState = matchingState;
	}
	public int getTalentId() {
		return talentId;
	}
	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}
	
	
	
}

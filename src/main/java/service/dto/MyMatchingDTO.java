package service.dto;

public class MyMatchingDTO  implements Comparable<MyMatchingDTO> {
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
	@Override
	public String toString() {
		return "MyMatchingDTO [matchingId=" + matchingId + ", talentId=" + talentId + ", talentTitle=" + talentTitle
				+ ", matchingState=" + matchingState + "]";
	}
	@Override
	public int compareTo(MyMatchingDTO o) {
		return Integer.compare(this.matchingId, o.getMatchingId());
	}
	

	
}

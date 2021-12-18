package model;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {
	private int groupId;
	private int talentId;
	private int matchingId;
	private int headCount;
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
	public int getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public List<Member> getUsers() {
		return users;
	}
	public void setUsers(List<Member> users) {
		this.users = users;
	}
	private int members;
	private List<Member> users;
	
}

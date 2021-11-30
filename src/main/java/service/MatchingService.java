package service;

import java.util.List;

import service.dto.MatchingDTO;
public interface MatchingService{
	public List<MatchingDTO> MatchingList(int userId);
	public MatchingDTO Matching(int matchingId);
	public int decideMatching(int matchingId);
	public int denyMatching(int matchingId);
	public int insertMatching(MatchingDTO matchingDto);
	public int deleteMatching(int matchindId);
	public int updateGroupId(int matchingId, int groupId);
	public int updateUserId(int matchingId, int userId);
}
package service;

import java.util.List;

import service.dto.MatchingDTO;
public interface MatchingService{
	public List<MatchingDTO> MatchingList(int userId);
	public MatchingDTO Matching(int matchingId);
	public int decideMatching(MatchingDTO matchingDto);
	public int denyMatching(MatchingDTO matchingDto);
	public int insertMatching(MatchingDTO matchingDto);
	public int deleteMatching(int matchindId);
}
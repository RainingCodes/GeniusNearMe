package persistence.dao;

import java.util.List;
import service.dto.MatchingDTO;
public interface MatchingDAO {
	
	//userId로 매칭DTO return
	public List<MatchingDTO> getMatchingListByUserId(int userId);
	//매칭DTO 하나 return
	public MatchingDTO getMatchingByMatchingId(int matchingId);
	

	//수락
	public int decideMatching(MatchingDTO matchingDto);
	
	//거절
	public int denyMatching(MatchingDTO matchingDto);

	
	//매칭 정보 insert
	public int insertMatching(MatchingDTO matchingDto);

	//매칭 정보 delete By matchingId
	public int deleteMatching(int matchindId);

}

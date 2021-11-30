package persistence.dao;

import java.util.List;
import service.dto.MatchingDTO;
public interface MatchingDAO {
	
	//userId로 매칭DTO return
	public List<MatchingDTO> getMatchingListByUserId(int userId);
	//매칭DTO 하나 return
	public MatchingDTO getMatchingByMatchingId(int matchingId);
	

	//수락
	public int decideMatching(int matchingId);
	
	//거절
	public int denyMatching(int matchingId);

	
	//매칭 정보 insert
	public int insertMatching(MatchingDTO matchingDto);

	//매칭 정보 delete By matchingId
	public int deleteMatching(int matchindId);
	
	public int updateGroupId(int matchingId, int groupId);
	
	public int updateUserId(int matchingId, int userId);

}

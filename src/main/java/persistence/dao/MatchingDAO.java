package persistence.dao;
//매칭 정보 DAO
import java.util.List;
import service.dto.MatchingDTO;
public interface MatchingDAO {
	//매징 리스트 반환  userId에 따른
	public List<MatchingDTO> getMatchingListByUserId(int userId);
	//매칭상세 보기
	public MatchingDTO getMatchingByMatchingId(int matchingId);
	//매칭 결정
	public int decideMatching(MatchingDTO matchingDto);
	
	//매칭거절
	public int denyMatching(MatchingDTO matchingDto);
	
	//매칭 apply
	public int insertMatching(MatchingDTO matchingDto);
	
	//매칭 삭제
	public int deleteMatching(int matchindId);
}

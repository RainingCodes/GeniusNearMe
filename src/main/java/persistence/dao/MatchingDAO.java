package persistence.dao;
//��Ī ���� DAO
import java.util.List;
import service.dto.MatchingDTO;
public interface MatchingDAO {
	//��¡ ����Ʈ ��ȯ  userId�� ����
	
	public List<MatchingDTO> getMatchingListByUserId(int userId);
	//��Ī�� ����
	public MatchingDTO getMatchingByMatchingId(int matchingId);
	//��Ī ����
	public int decideMatching(MatchingDTO matchingDto);
	
	//��Ī����
	public int denyMatching(MatchingDTO matchingDto);
	
	//��Ī apply
	public int insertMatching(MatchingDTO matchingDto);
	
	//��Ī ����
	public int deleteMatching(int matchindId);
}

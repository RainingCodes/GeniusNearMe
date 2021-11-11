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
	public MatchingDTO decideMatching(MatchingDTO matchingDto);
	
	//��Ī apply
	public MatchingDTO applyMatching(MatchingDTO matchingDto);
}

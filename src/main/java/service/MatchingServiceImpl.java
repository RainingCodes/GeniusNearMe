package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.MatchingDAO;
import service.dto.MatchingDTO;

public class MatchingServiceImpl implements MatchingService{
	private MatchingDAO dao = null;
	
	public MatchingServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getMatchingDAO();
	}
	public List<MatchingDTO> MatchingList(int userId){
		return dao.getMatchingListByUserId(userId);
	}
	public MatchingDTO Matching(int matchingId) {
		return dao.getMatchingByMatchingId(matchingId);
	}
	public int decideMatching(MatchingDTO matchingDto) {
		return dao.decideMatching(matchingDto);
	}
	public int denyMatching(MatchingDTO matchingDto) {
		return dao.denyMatching(matchingDto);
	}
	public int insertMatching(MatchingDTO matchingDto) {
		return dao.insertMatching(matchingDto);
	}
	public int deleteMatching(int matchindId) {
		return dao.deleteMatching(matchindId);
	}
}

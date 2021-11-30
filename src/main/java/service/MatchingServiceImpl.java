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
	public int decideMatching(int matchingId) {
		return dao.decideMatching(matchingId);
	}
	public int denyMatching(int matchingId) {
		return dao.denyMatching(matchingId);
	}
	public int insertMatching(MatchingDTO matchingDto) {
		return dao.insertMatching(matchingDto);
	}
	public int deleteMatching(int matchindId) {
		return dao.deleteMatching(matchindId);
	}
	@Override
	public int updateGroupId(int matchingId, int groupId) {
		// TODO Auto-generated method stub
		return dao.updateGroupId(matchingId, groupId);
	}
}

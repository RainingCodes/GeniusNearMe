package service;

import persistence.DAOFactory;
import persistence.dao.TalentTestDAO;
import service.dto.TalentTestDTO;

public class TalentTestServiceImpl implements TalentTestService {
	private TalentTestDAO dao = null;
	public TalentTestServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getTalentTestDAO();
	}

	@Override
	public TalentTestDTO talentTestResultByUserId(int userId) {
		return dao.getTalentTestByUserId(userId);
	}

	@Override
	public int insertTalent(TalentTestDTO t) {
		// TODO Auto-generated method stub
		return dao.insertTalent(t);
	}

	@Override
	public int updateTalent(TalentTestDTO t) {
		return dao.updateTalent(t);
	}

	@Override
	public int deleteTalent(int userId) {
		// TODO Auto-generated method stub
		return dao.deleteTalent(userId);
	}

}

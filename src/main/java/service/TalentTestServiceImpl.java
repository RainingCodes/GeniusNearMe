package service;

import model.TalentTest;
import model.dao.TalentTestDAO;

public class TalentTestServiceImpl implements TalentTestService {
	private TalentTestDAO dao = null;
	public TalentTestServiceImpl() {
		dao = new TalentTestDAO();
	}

	@Override
	public TalentTest talentTestResultByUserId(int userId) {
		return dao.getTalentTestByUserId(userId);
	}

	@Override
	public int insertTalent(TalentTest t) {
		// TODO Auto-generated method stub
		return dao.insertTalentTest(t);
	}

	@Override
	public int updateTalent(TalentTest t) {
		return dao.updateTalentTest(t);
	}

	@Override
	public int deleteTalent(int userId) {
		// TODO Auto-generated method stub
		return dao.deleteTalentTest(userId);
	}

}

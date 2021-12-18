package service;

import model.TalentTest;

public interface TalentTestService {
	//아이디로 탤런트테스트 가져오기
	public TalentTest talentTestResultByUserId(int userId);
	//CUD
	public int insertTalent(TalentTest t);
	public int updateTalent(TalentTest t);
	public int deleteTalent(int userId);
}

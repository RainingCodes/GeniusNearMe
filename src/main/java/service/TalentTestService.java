package service;

import service.dto.TalentTestDTO;

public interface TalentTestService {
	//아이디로 탤런트테스트 가져오기
	public TalentTestDTO talentTestResultByUserId(int userId);
	//CUD
	public int insertTalent(TalentTestDTO t);
	public int updateTalent(TalentTestDTO t);
	public int deleteTalent(int userId);
}

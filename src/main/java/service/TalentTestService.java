package service;

import service.dto.TalentTestDTO;

public interface TalentTestService {
	//아이디로 탤런트테스트 가져오기
	public TalentTestDTO talentTestResultByUserId(int userId);
	
	//아이디로 탤런트테스트 검사있는지 여부 가져오기 : 그냥 탤런트테스트 null 이면 없는거임
	//public boolean IsExistTalentTestResult(int userId);
	
	//CUD
	public int insertTalent(TalentTestDTO t);
	public int updateTalent(TalentTestDTO t);
	public int deleteTalent(int userId);
}

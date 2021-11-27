package persistence.dao;

import service.dto.TalentTestDTO;

public interface TalentTestDAO {
	
	public TalentTestDTO getTalentTestByUserId(int userId); // 모든 재능글
	public int insertTalent(TalentTestDTO t); // 작성
	public int updateTalent(TalentTestDTO t); // 수정
	public int deleteTalent(int userId); // 삭제
}

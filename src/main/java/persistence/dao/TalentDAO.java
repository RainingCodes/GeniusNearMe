package persistence.dao;

import java.util.List;

import service.dto.TalentDTO;

public interface TalentDAO {
	public List<TalentDTO> getAllTalentList(); // 모든 재능글
	public List<TalentDTO> getTalentListByCategory(String category); // 카테고리로
	public List<TalentDTO> getTalentListByTitle(String Title); // 제목으로 
	public TalentDTO getTalentView(int talentId); // 상세뷰
	public int insertTalent(TalentDTO t); // 작성
	public int updateTalent(TalentDTO t); // 수정
	public int deleteTalent(int talentId); // 삭제
}
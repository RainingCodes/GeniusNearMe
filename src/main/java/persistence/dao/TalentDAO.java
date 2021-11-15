package persistence.dao;

import java.util.List;

import service.dto.TalentDTO;

public interface TalentDAO {
	public List<TalentDTO> getAllTalentList(); // 모든 재능글
	public List<TalentDTO> getTalentListByCategory(String[] category); // 카테고리로
	public List<TalentDTO> getTalentListByTitle(String Title); // 제목으로
	public List<TalentDTO> getTalentListBypriceRange(int high); //가격으로 검색(매개변수(최대가격)보다 낮은 항목들을 반환)
	public TalentDTO getTalentView(int talentId); // 상세뷰
	public int insertTalent(TalentDTO t); // 작성
	public int updateTalent(TalentDTO t); // 수정
	public int deleteTalent(int talentId); // 삭제
}
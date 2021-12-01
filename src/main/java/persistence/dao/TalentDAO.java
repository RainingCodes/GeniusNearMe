package persistence.dao;

import java.util.Date;
import java.util.List;

import service.dto.TalentDTO;

public interface TalentDAO{
	public List<TalentDTO> getAllTalentList(); // 모든 재능글
	public List<TalentDTO> getTalentListByCategory(String[] category); // 카테고리로
	public List<TalentDTO> getTalentListByTitle(String Title); // 제목으로
	public List<TalentDTO> getTalentListByWriterId(int userId); // 작성자로
	public List<TalentDTO> getTalentListByNickname(String nickname); //닉네임으로
	public List<TalentDTO> getTalentListByOptions(String title, String reSearch, String[] categories, int price, Date startDate, Date endDate) throws Exception; // 상세검색
	public TalentDTO getTalentView(int talentId); // 상세뷰
	public int insertTalent(TalentDTO t); // 작성
	public int updateTalent(TalentDTO t); // 수정
	public int deleteTalent(int talentId); // 삭제
}
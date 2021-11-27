package service;

import java.sql.Date;
//import java.sql.Date;
import java.util.List;

import service.dto.TalentDTO;

public interface TalentService{
	public List<TalentDTO> ListingTalents();
	public List<TalentDTO> getTalent(String title);
	public List<TalentDTO> getTalentByTalentCategory(String[] category);
	public int insertTalent(TalentDTO talent);
	public int updateTalent(TalentDTO talent);
	public int deleteTalent(int talentId);
	public TalentDTO findTalent(int talentId);
	public List<TalentDTO> getTalentByOptions(String reSearch, String[] categories, int price, Date startDate, Date deadLine);
	public List<TalentDTO> getTalentListByWriterId(int userId);
}

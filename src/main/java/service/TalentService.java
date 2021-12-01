package service;

import java.util.Date;
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
	public List<TalentDTO> getTalentByOptions(String title, String reSearch, String[] categories, int price, Date startDate, Date deadLine) throws Exception;
	public List<TalentDTO> getTalentListByWriterId(int userId);
	public List<TalentDTO> getTalentListByNickname(String nickname);
	
	public int isExistMatching(int talentId);
}
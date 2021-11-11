package service;

import java.util.List;

import service.dto.TalentDTO;

public interface TalentService{
	public List<TalentDTO> ListingTalents();
	public List<TalentDTO> getTalent(String title);
	public int insertTalent(TalentDTO talent);
	public int updateTalent(TalentDTO talent);
	public int deleteTalent(int talentId);
}

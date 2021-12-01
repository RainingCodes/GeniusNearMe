package service;

import java.util.Date;
import java.util.List;
import persistence.DAOFactory;
import persistence.dao.TalentDAO;
import service.dto.TalentDTO;

public class TalentServiceImpl implements TalentService {

	private TalentDAO dao = null;
	public TalentServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getTalentDAO();
	}
	
	public List<TalentDTO> ListingTalents() {
		return dao.getAllTalentList();
	}
	public List<TalentDTO> getTalentListByWriterId(int userId){
		return dao.getTalentListByWriterId(userId);
	}
	public List<TalentDTO> getTalent(String title) {
		return dao.getTalentListByTitle(title);
	}
	public List<TalentDTO> getTalentListByNickname(String nickname) {
		return dao.getTalentListByNickname(nickname);
	}
	public List<TalentDTO> getTalentByOptions(String title, String reSearch, String[] categories, int price, Date startDate, Date endDate) throws Exception {
		return dao.getTalentListByOptions(title, reSearch, categories, price, startDate, endDate);
	}
	
	public List<TalentDTO> getTalentByTalentCategory(String[] category) {
		return dao.getTalentListByCategory(category);
	}
	
	public int insertTalent(TalentDTO talent) {
		return dao.insertTalent(talent);
	}

	public int updateTalent(TalentDTO talent) {
		return dao.updateTalent(talent);
	}

	public int deleteTalent(int talentId) {
		return dao.deleteTalent(talentId);
	}
	public TalentDTO findTalent(int talentId) {
		return dao.getTalentView(talentId);
	}
	
	public int isExistMatching(int talentId) {
		return dao.isExistMatching(talentId);
	}

	
}
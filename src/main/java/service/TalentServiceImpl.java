package service;

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

	public List<TalentDTO> getTalent(String title) {
		return dao.getTalentListByTitle(title);
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
}
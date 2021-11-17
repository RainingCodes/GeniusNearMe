package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.PriceDAO;
import service.dto.PriceDTO;

public class PriceServiceImpl implements PriceService{

	private PriceDAO dao = null;
	
	public PriceServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getPriceDAO();
	}
	
	public List<PriceDTO> PriceList(int talentId){
		return dao.getPriceListByTalentId(talentId);
	}
	public int insertPrice(PriceDTO priceDto) {
		return dao.insertPrice(priceDto);
	}
	public PriceDTO getPriceDTOByIdHead(int talentId, int headCount){//priceDto 반환
		return dao.getPriceDTOByIdHead(talentId, headCount);
	}
	public int PriceByIdHead(int talentId, int headCount){//price 반환
		return dao.getPriceByIdHead(talentId, headCount);
	}
	public int deleteAllPriceById(int talentId) {
		return dao.deleteAllPriceById(talentId);
	}
	public int updatePrice(PriceDTO priceDto) {
		return dao.updatePrice(priceDto);
	}
}

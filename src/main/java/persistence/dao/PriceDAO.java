package persistence.dao;

import java.util.List;

import service.dto.PriceDTO;

public interface PriceDAO {
	public List<PriceDTO> getPriceListByTalentId(int talentId);
	public int insertPrice(PriceDTO priceDto);
	public PriceDTO getPriceDTOByIdHead(int talentId, int headCount);//priceDto 반환
	public int getPriceByIdHead(int talentId, int headCount);//price 반환
	public int deleteAllPriceById(int talentId);
	public int updatePrice(PriceDTO priceDto);
}

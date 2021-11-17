package service;

import java.util.List;

import service.dto.PriceDTO;

public interface PriceService {
	public List<PriceDTO> PriceList(int talentId);
	public int insertPrice(PriceDTO priceDto);
	public PriceDTO getPriceDTOByIdHead(int talentId, int headCount);//priceDto 반환
	public int PriceByIdHead(int talentId, int headCount);//price 반환
	public int deleteAllPriceById(int talentId);
}

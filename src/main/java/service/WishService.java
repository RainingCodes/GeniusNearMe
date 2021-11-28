package service;

import java.util.List;

import service.dto.WishDTO;

public interface WishService {
	public int insertWish(WishDTO wishDto);  
	public int deleteWish(int talentId, int userId);
	public List<WishDTO> getWishListByUserId(int userId); 
	public WishDTO getWish(int talentId, int userId);
}

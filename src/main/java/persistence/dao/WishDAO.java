package persistence.dao;

import java.util.List;

import service.dto.WishDTO;

public interface WishDAO {
	public int insertWish(WishDTO wishDto);  //찜 추가
	public int deleteWish(int talentId, int userId); //찜 삭제
	public List<WishDTO> getWishListByUserId(int userId); //내가 찜한 목록
	public WishDTO getWish(int talentId, int userId);
}

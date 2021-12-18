package model.mapper;

import java.util.List;

import model.Wish;

public interface WishMapper {
	List<Wish> selectAllWishListByUserId(int userId);
	Wish selectWish(Wish wish);
	int insertWish(Wish wish);
	int deleteWish(Wish wish);
}

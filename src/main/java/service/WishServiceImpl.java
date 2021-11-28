package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.WishDAO;
import service.dto.WishDTO;

public class WishServiceImpl implements WishService{
	
	private WishDAO dao = null;
	
	public WishServiceImpl() {
		super();
		DAOFactory factory = new DAOFactory();
		dao = factory.getWishDAO();
	}

	@Override
	public int insertWish(WishDTO wishDto) {
		return dao.insertWish(wishDto);
	}

	@Override
	public int deleteWish(int talentId, int userId) {
		return dao.deleteWish(talentId, userId);
	}

	@Override
	public List<WishDTO> getWishListByUserId(int userId) {
		return dao.getWishListByUserId(userId);
	}

}

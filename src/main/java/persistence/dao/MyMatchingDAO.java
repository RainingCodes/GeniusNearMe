package persistence.dao;

import java.util.List;

import service.dto.MyMatchingDTO;

public interface MyMatchingDAO {
	public List<MyMatchingDTO> getMyMatchingListByUserId(int userId);
}

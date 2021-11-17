package persistence.dao;

import java.util.List;

import service.dto.MyMatchingDTO;

public interface MyMatchingDAO {
	public List<MyMatchingDTO> getApplyMyMatchingListByUserId(int userId); // userId field가 user
	public List<MyMatchingDTO> getReceiveMyMatchingListByUserId(int userId); // talent - writer field가 user
	public int getUserIdByMatchingId(int matchingId);
}

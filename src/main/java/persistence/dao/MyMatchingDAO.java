package persistence.dao;

import java.util.List;

import service.dto.MyMatchingDTO;

public interface MyMatchingDAO {
	public List<MyMatchingDTO> getApplyMyOneMatchingListByUserId(int userId); // userId field가 user
	public List<MyMatchingDTO> getReceiveMyOneMatchingListByUserId(int userId); // talent - writer field가 user
	
	public List<MyMatchingDTO> getApplyMyGroupMatchingListByUserId(int userId); // userId field가 user
	public List<MyMatchingDTO> getReceiveMyGroupMatchingListByUserId(int userId); // talent - writer field가 user
	
	public int getUserIdByMatchingId(int matchingId);
	public int getWriterIdByTalentId(int talentId);
}

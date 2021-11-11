package service;

import java.util.List;
import persistence.DAOFactory;
import persistence.dao.MemberDAO;
import service.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao = null;
	
	public MemberServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getMemberDAO();
	}
	
	public List<MemberDTO> ListingMembers() { // 전체 유저정보를 List 형태로 반환
		return dao.getMemberList();
	}
	public MemberDTO getMember(int userId) { // userId에 해당하는 유저 정보 반환
		return dao.getMemberByUserId(userId);
	}
	public int insertMemver(MemberDTO member) {
		return dao.insertMember(member);
	}
	public int updateMember(MemberDTO member) {
		return dao.updateMember(member);
	}
	public int deleteMember(int userId) {
		return dao.deleteMember(userId);
	}
}
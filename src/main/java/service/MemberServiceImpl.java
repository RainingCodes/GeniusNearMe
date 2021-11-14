package service;

import java.sql.SQLException;
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
	public int insertMember(MemberDTO member) {
		return dao.insertMember(member);
	}
	public int updateMember(MemberDTO member) {
		return dao.updateMember(member);
	}
	public int deleteMember(int userId) {
		return dao.deleteMember(userId);
	}
	
	public boolean login(String userId, String password)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
			MemberDTO member = dao.getMemberByEmail(userId);

			if (!member.matchPassword(password)) {
				throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
			}
			return true;
	}
	
	public MemberDTO findUserByEmail(String userId)
			throws SQLException, UserNotFoundException {
			MemberDTO member = dao.getMemberByEmail(userId);

			if (member == null) {
				throw new UserNotFoundException("유저가 존재하지 않습니다.");
			}
			return member;
	}
}
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
	
	public MemberDTO getMemberByEmail (String email) {
		return dao.getMemberByEmail(email);
	}
	public int getuserIdByEmail (String email) {
		return dao.getUserIdByEmail(email);
	}
	public int insertMember(MemberDTO member) throws SQLException, ExistingUserException {
		if (dao.existingEmail(member.getEmail()) == true) {
			throw new ExistingUserException(member.getEmail() + "는 존재하는 아이디입니다.");
		}
		if (dao.existingNickname(member.getNickname()) == true) {
			throw new ExistingUserException(member.getEmail() + "는(은) 존재하는 닉네임입니다.");
		}
		return dao.insertMember(member);
	}
	public int updateMember(MemberDTO member) throws SQLException, ExistingUserException {
		if (dao.existingNickname(member.getNickname()) == true) {
			throw new ExistingUserException(member.getEmail() + "는(은) 존재하는 닉네임입니다.");
		}
		return dao.updateMember(member);
	}
	
	public int deleteMember(int userId) {
		return dao.deleteMember(userId);
	}
	
	public boolean login(String userId, String password)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
		
			System.out.println(userId +","+ password);
			MemberDTO member = dao.getMemberByEmail(userId);
			System.out.println(member);

			if (!member.matchPassword(password)) {
				throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
			}
			return true;
	}
	
	public MemberDTO findUserByEmail(String email)
			throws SQLException, UserNotFoundException {
			MemberDTO member = dao.getMemberByEmail(email);

			if (member == null) {
				throw new UserNotFoundException("유저가 존재하지 않습니다.");
			}
			return member;
	}
	public String getEmailByUserId(int userId) {
		String email = dao.getEmailByUserId(userId);
		return email;
	}
}
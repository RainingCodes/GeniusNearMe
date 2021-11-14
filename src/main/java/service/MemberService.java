package service;
import java.sql.SQLException;
import java.util.List;

import service.dto.MemberDTO;

public interface MemberService { // 유저 정보 관리 목적의 인터페이스
	public List<MemberDTO> ListingMembers(); // 전체 유저정보를 List 형태로 반환
	public MemberDTO getMember(int userId); // userId에 해당하는 유저 정보 반환
	public MemberDTO getMemberByEmail (String email);
	public int getuserIdByEmail (String email);
	public int insertMember(MemberDTO member) throws SQLException, ExistingUserException;
	public int updateMember(MemberDTO member) throws SQLException, ExistingUserException;
	public int deleteMember(int userId);
	public boolean login(String userId, String password) throws SQLException, UserNotFoundException, PasswordMismatchException;
	public MemberDTO findUserByEmail(String userId) throws SQLException, UserNotFoundException;
}
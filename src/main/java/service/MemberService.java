package service;
import java.util.List;

import service.dto.MemberDTO;

public interface MemberService { // 유저 정보 관리 목적의 인터페이스
	public List<MemberDTO> ListingMembers(); // 전체 유저정보를 List 형태로 반환
	public MemberDTO getMember(int userId); // userId에 해당하는 유저 정보 반환
	public int insertMember(MemberDTO member);
	public int updateMember(MemberDTO member);
	public int deleteMember(int userId);
}
package persistence.dao;
import java.util.List;

import service.dto.MemberDTO;

//멤버정보 DAO : Interface 부분
public interface MemberDAO {
	// 전체 회원 정보를 MemberDTO 의 List 로 반환하는 메소드
		public List<MemberDTO> getMemberList();
		
		// MemberDTO 에 담긴 멤버정보를 Data Source 에 추가하는 메소드
		public int insertMember(MemberDTO member);
		
		// 멤버정보를 수정하는 메소드
		public int updateMember(MemberDTO member);
		
		// 멤버정보를 삭제하는 메소드
		public int deleteMember(int userId);
		
		// 성명에 해당하는 멤버정보를 반환하는 메소드
		public MemberDTO getMemberByNickname(String nickName);
}
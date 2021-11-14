package persistence.dao;
import java.sql.SQLException;
import java.util.List;

import service.dto.MemberDTO;

public interface MemberDAO {
		public List<MemberDTO> getMemberList();
		
		public int insertMember(MemberDTO member);
		public int updateMember(MemberDTO member);
		public int deleteMember(int userId);
		public MemberDTO getMemberByNickname(String nickName);
		public MemberDTO getMemberByUserId(int userId);
		public MemberDTO getMemberByEmail(String email);
		public boolean existingMember(String email) throws SQLException;
}
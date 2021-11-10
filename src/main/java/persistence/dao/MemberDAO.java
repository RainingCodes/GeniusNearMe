package persistence.dao;
import java.util.List;

import service.dto.MemberDTO;

//������� DAO : Interface �κ�
public interface MemberDAO {
	// ��ü ȸ�� ������ MemberDTO �� List �� ��ȯ�ϴ� �޼ҵ�
		public List<MemberDTO> getMemberList();
		
		// MemberDTO �� ��� ��������� Data Source �� �߰��ϴ� �޼ҵ�
		public int insertMember(MemberDTO member);
		
		// ��������� �����ϴ� �޼ҵ�
		public int updateMember(MemberDTO member);
		
		// ��������� �����ϴ� �޼ҵ�
		public int deleteMember(int userId);
		
		// ���� �ش��ϴ� ��������� ��ȯ�ϴ� �޼ҵ�
		public MemberDTO getMemberByNickname(String nickName);
}
package service.dto;

//�л��� ������ ������ �����ϱ� ���� DTO(Data Transition Object)
public class MemberDTO {
	private int userId = -1;			// �����id
	private String email = null;		// �̸���
	private String pw = null;			// ��й�ȣ 
	private String phone = null;	// ����ó
	private String nickname = null;	 // �г���
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
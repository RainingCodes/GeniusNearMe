package service.dto;

//학생과 관련한 정보를 저장하기 위한 DTO(Data Transition Object)
public class MemberDTO {
	private int userId = -1;			// 사용자id
	private String email = null;		// 이메일
	private String pw = null;			// 비밀번호 
	private String phone = null;	// 연락처
	private String nickname = null;	 // 닉네임
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
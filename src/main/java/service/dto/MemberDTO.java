package service.dto;

public class MemberDTO {
	private int userId = -1;			// 사용자id
	private String email = null;		// 이메일
	private String pw = null;			// 비밀번호 
	private String nickname = null;	 // 닉네임
	private String phone = null;	// 전화번호	
	
	public MemberDTO(String email, String pw, String nickname, String phone) {
		this.email = email;
		this.pw = pw;
		this.nickname = nickname;
		this.phone = phone;
	}
	
	public MemberDTO(int userId, String email, String pw, String nickname, String phone) {
		this.userId = userId;
		this.email = email;
		this.pw = pw;
		this.nickname = nickname;
		this.phone = phone;
	}
	
	public MemberDTO() {
		
	}
	
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
	
	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.pw.equals(password);
	}
}

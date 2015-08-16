package kmj.webboard.model;
/**
 * 회원을 나타내는 entity 입니다.
 * 
 * entity - 영속성을 갖는 객체입니다.
 *        - 영속성이란?    - 생성되고   - insert ..... 
 *                      - 수정되고  -  update .....
 *                      - 삭제되는 객체 - delete from users .....
 *                      
 * 
 * @author Administrator
 *
 */
public class UserVO {
	
	private Integer seq; // database에서 부여해준 유일한 키값같은 역할?
	
	private String nickName;
	private String userId;
	private String email;
	private String password;
	
	public UserVO(String userId, String email, String password) {
//		this.nickName = nickName;
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String name) {
		this.userId = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}

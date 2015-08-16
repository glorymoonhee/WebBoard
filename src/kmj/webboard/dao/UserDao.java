package kmj.webboard.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kmj.webboard.model.UserVO;

public class UserDao {

	private List<UserVO> users = new ArrayList<UserVO>();
	
	public UserDao() {
		users.add(new UserVO("james1", "james@naver.com", "1111"));
		users.add(new UserVO("tom", "tom@naver.com", "2222"));
	}
	
}

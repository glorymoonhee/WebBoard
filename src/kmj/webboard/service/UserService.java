package kmj.webboard.service;

import kmj.webboard.model.UserVO;

public class UserService {
	
    

	public UserVO insertNewUser(String userId, String userEmail, String password) {
		return new UserVO(userId,userEmail,password);
	}



	
}

package in.capp.service;

import java.util.List;

import in.capp.domain.User;

public interface UserService {

	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;

	public static final Integer ROLE_USER = 1;
	public static final Integer ROLE_ADMIN = 2;

	// Register new User
	public void register(User u);

	// Login User
	public User login(String LoginName, String password);

	public User profile(Integer userId);

	// Show all Users
	public List<User> getUserList();

	// change LoginStatus active/block user
	public void changeLoginStatus(Integer userId, Integer LoginStatus);

}

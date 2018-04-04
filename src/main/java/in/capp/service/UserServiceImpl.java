package in.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import in.capp.dao.BaseDAO;
import in.capp.dao.UserDAO;
import in.capp.domain.User;
import in.capp.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {
	@Autowired
	UserDAO userDAO;

	public void register(User u) {
		userDAO.save(u);
	}

	public User login(String LoginName, String password) {
		String sql = "Select userId,name,phone,email,address,role,loginStatus,loginName"
				+ " FROM user WHERE loginName=:ln AND password=:pw";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ln", LoginName);
		m.put("pw", password);

		try {
			return getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public User profile(Integer userId) {
		User user = userDAO.findById(userId);
		return user;
	}

	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	public void changeLoginStatus(Integer userId, Integer LoginStatus) {

	}

}

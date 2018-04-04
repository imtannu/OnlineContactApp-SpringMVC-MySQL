package in.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import in.capp.domain.User;
import in.capp.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	public void save(User u) {
		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
				+ "VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";

		Map<String, Object> m = new HashMap<String, Object>();

		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		SqlParameterSource ps = new MapSqlParameterSource(m);

		// KeyHolder kh = new GeneratedKeyHolder();
		// Integer userId = kh.getKey().intValue();
		// u.setUserId(userId);

		super.getNamedParameterJdbcTemplate().update(sql, ps);
	}

	public void update(User u) {
		String sql = "UPDATE user" + " set name=:name," + "phone=:phone," + "email=:email," + "address=:address,"
				+ "role=:role," + "loginStatus=:loginStatus" + " WHERE userId=:userId";

		Map<String, Object> m = new HashMap<String, Object>();

		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("userId", u.getUserId());
		// SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	public void delete(User u) {
		this.delete(u.getUserId());
	}

	public void delete(Integer userId) {
		String sql = "DELETE FROM user WHERE userId=?";
		getJdbcTemplate().update(sql, userId);

	}

	public User findById(Integer userId) {
		String sql = "SELECT userId,name,phone,email,address,loginName,loginStatus,role FROM user WHERE userId=?";
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
		return user;
	}

	public List<User> findAll() {
		String sql = "SELECT userId,name,phone,email,address,loginName,role FROM user";
		List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
		return users;
	}

	public List<User> findByProperty(String propname, Object propValue) {
		String sql = "SELECT userId,name,phone,email,address,loginName,loginStatus,role FROM user " + " WHERE "
				+ propname + "=?";
		List<User> users = getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
		return users;
	}

}

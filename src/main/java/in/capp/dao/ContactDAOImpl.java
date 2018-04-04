package in.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import in.capp.domain.Contact;
import in.capp.rm.ContactRowMapper;
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	public void save(Contact c) {

		String sql = "INSERT INTO contact(userid,name,phone,email,address,remark)"
				+ "VALUES(:userId,:name,:phone,:email,:address,:remark)";

		Map<String, Object> m = new HashMap<String, Object>();

		m.put("userId", c.getUserId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		// KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);

		getNamedParameterJdbcTemplate().update(sql, ps);
	}

	public void update(Contact c) {
		String sql = "UPDATE contact " + "SET name=:name," + "phone=:phone," + "email=:email," + "address=:address,"
				+ "remark=:remark " + "WHERE contactId=:contactId";

		Map<String, Object> m = new HashMap<String, Object>();
		
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		m.put("contactId", c.getContactId());

		getNamedParameterJdbcTemplate().update(sql, m);
	}

	public void delete(Contact c) {
		this.delete(c.getContactId());
	}

	public void delete(Integer contactId) {
		String sql = "DELETE FROM contact WHERE contactId=?";
		getJdbcTemplate().update(sql, contactId);

	}

	public Contact findById(Integer contactId) {
		String sql = "SELECT contactId, userId,name,phone,email,address,remark FROM contact WHERE contactId=?";
		Contact contact = getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
		return contact;
	}

	public List<Contact> findAll() {
		String sql = "SELECT contactId, userId,name,phone,email,address,remark FROM contact ";
		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper());
		return contacts;
	}

	public List<Contact> findByProperty(String propname, Object propValue) {
		String sql = "SELECT contactId, userId,name,phone,email,address,remark FROM contact WHERE " + propname + "=?";
		List<Contact> contact = getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
		return contact;
	}

}

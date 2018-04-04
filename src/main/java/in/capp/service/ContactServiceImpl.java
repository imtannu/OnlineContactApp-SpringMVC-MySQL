package in.capp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.capp.dao.BaseDAO;
import in.capp.dao.ContactDAO;
import in.capp.domain.Contact;
import in.capp.rm.ContactRowMapper;
import in.capp.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
	@Autowired
	ContactDAO contactDAO;
	// ContactDAOImpl contactDAO = new ContactDAOImpl();

	public void save(Contact c) {
		contactDAO.save(c);
	}

	public void update(Contact c) {
		contactDAO.update(c);
	}

	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
	}

	public void delete(Integer[] contactIds) {
		String ids = StringUtil.toCommaSepartedString(contactIds);
		String sql = "DELETE FROM CONTACT WHERE contactId IN(" + ids + ")";
		getJdbcTemplate().update(sql);
	}

	public List<Contact> UserContacts(Integer userId) {
		return contactDAO.findByProperty("userId", userId);
	}

	public List<Contact> SearchUserContact(Integer userId, String txt) {
		String sql = "SELECT contactId, userId,name,phone,email,address,remark FROM contact WHERE userId=? AND (name like '%"
				+ txt + "%' OR phone like '%" + txt + "%' OR email like '%" + txt + "%' OR address like '%" + txt
				+ "%' OR remark like '%" + txt + "%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}

	@Override
	public Contact findbyId(Integer contactId) {
		return contactDAO.findById(contactId);
	}

}

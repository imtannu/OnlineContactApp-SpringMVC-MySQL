package in.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import in.capp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	public Contact mapRow(ResultSet rs, int contactId) throws SQLException {
		Contact c = new Contact();
		c.setContactId(rs.getInt("contactId"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setAddress(rs.getString("address"));
		c.setPhone(rs.getString("phone"));
		c.setRemark(rs.getString("remark"));
		return c;
	}

}

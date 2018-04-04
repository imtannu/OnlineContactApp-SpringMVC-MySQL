package in.capp.service;

import java.util.List;
import in.capp.domain.Contact;

public interface ContactService {

	public void save(Contact c);

	public void update(Contact c);

	public void delete(Integer contactId);
	
	public Contact findbyId(Integer contactId);

	public void delete(Integer[] contactIds);

	public List<Contact> UserContacts(Integer userId);

	public List<Contact> SearchUserContact(Integer userId, String txt);

}

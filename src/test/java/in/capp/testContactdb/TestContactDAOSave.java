package in.capp.testContactdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.capp.config.SpringRootConfig;
import in.capp.dao.ContactDAO;
import in.capp.domain.Contact;

public class TestContactDAOSave {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
		Contact c = new Contact();
		c.setName("pakya");
		c.setPhone("955327383");
		c.setEmail("pakya@hotmail.net");
		c.setAddress("pak");
		c.setUserId(3);
		c.setRemark("office");
		contactDAO.save(c);
		System.out.println("--------Contact Saved------");


	}

}

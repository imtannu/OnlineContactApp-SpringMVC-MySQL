package in.capp.testUserdb;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.capp.config.SpringRootConfig;
import in.capp.dao.UserDAO;
import in.capp.domain.User;

public class TestUserDAOFindRecordbyProperty {

	public static void main(String[] args) {
		ApplicationContext apx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = apx.getBean(UserDAO.class);

		List<User> users = userDAO.findByProperty("name", "amit");
		for (User user : users) {
			System.out.println("User details..");
			System.out.println(user.getUserId());
			System.out.println(user.getName());
			System.out.println(user.getAddress());
			System.out.println(user.getLoginName());
			System.out.println(user.getPhone());
		}
	}

}

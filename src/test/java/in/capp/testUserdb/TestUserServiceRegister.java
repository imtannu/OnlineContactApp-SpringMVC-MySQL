package in.capp.testUserdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.capp.config.SpringRootConfig;
import in.capp.domain.User;
import in.capp.service.UserService;

public class TestUserServiceRegister {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User u = new User();
		u.setName("manoj");
		u.setPhone("2222327383");
		u.setEmail("monaoj@hotmail.net");
		u.setAddress("manya");
		u.setLoginName("manojr");
		u.setPassword("manoj@321");
		u.setRole(UserService.ROLE_USER);//
		u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		userService.register(u);
		System.out.println("--------User registered Successfully...------");

	}

}

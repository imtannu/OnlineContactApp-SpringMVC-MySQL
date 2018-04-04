package in.capp.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import in.capp.command.LoginCommand;
import in.capp.command.UserCommand;
import in.capp.domain.User;
import in.capp.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index" })
	public String hello(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index"; // JSP page
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String HandelLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {

		User logedinUser = userService.login(cmd.getLoginName(), cmd.getPassword());

		if (logedinUser == null) {
			// Invalid user name OR password
			// add error message and go back to login form
			m.addAttribute("err", "Login Falied! Enter valid Credential.. ");
			return "index"; // JSP login Form
		} else {
			// User is Blocked

			if (logedinUser.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				m.addAttribute("err", "Your Account is BLOCKED!!! Contact to Admin..");
				return "index";
			}

			// SUCCESS
			// go to ADMIN Dash board

			else if (logedinUser.getRole().equals(UserService.ROLE_ADMIN)) {
				addUserInSession(logedinUser, session);
				return "redirect:admin_dashboard";
			}

			// Success
			// go to USER Dash board

			else if (logedinUser.getRole().equals(UserService.ROLE_USER)) {
				addUserInSession(logedinUser, session);
				return "redirect:user_dashboard";
			}
			// NO ROLE FOUND
			else {
				m.addAttribute("err", "Invalid User Role!!");
				return "index"; // JSP login Form
			}
		}
	}

	@RequestMapping(value = { "/user_dashboard" })
	public String userDashboard() {
		return "dashboard_user"; // JSP
	}

	@RequestMapping(value = { "/admin_dashboard" })
	public String adminDashboard() {
		return "dashboard_admin"; // JSP
	}

	@RequestMapping(value = { "/logout" })
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:index?act=lo"; // JSP
	}

	@RequestMapping("/reg_form")
	public String regForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		return "reg_form"; // JSP
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("command") UserCommand cmd, Model m) {
		try {
			User user = cmd.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			return "redirect:index?act=ls"; // JSP
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err", "UserName Already registred..Please Select Another UserName");
			return "reg_form";
		}
	}

	@RequestMapping("/users_list")
	public String Form(Model m) {
		m.addAttribute("usersList", userService.getUserList());
		return "users_list"; // JSP
	}

	@RequestMapping("/profile")
	public String profile(Model m, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("profile", userService.profile(userId));
		return "profile"; // JSP
	}

	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
		session.setAttribute("name", u.getName());
	}
}

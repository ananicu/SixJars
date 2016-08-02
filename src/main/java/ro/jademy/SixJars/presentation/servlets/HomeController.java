package ro.jademy.SixJars.presentation.servlets;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.jademy.SixJars.Business.entities.User;
import ro.jademy.SixJars.Business.services.LoginService;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "loginform";
	}
	
//	@RequestParam("username") User username, 
//	@RequestParam("password") String password
	
	@RequestMapping(value = "/loginform", method = RequestMethod.POST)
	public ModelAndView login(User user, HttpServletRequest request) {
		
		LoginService login = new LoginService();

		User dbUser = login.doLogin(user.getUsername(), user.getPassword());
		if (dbUser == null) {
			return new ModelAndView("loginFailure");
		} else {
			request.getSession().setAttribute("user", dbUser);

			return new ModelAndView("userMenu", "user", dbUser);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(User user, HttpServletRequest request) {
		
		LoginService register = new LoginService();
		
		User newUser = new User(user.getUsername(), user.getPassword(), user.getEmail());
		
		boolean userRegistered = register.doRegister(newUser);
		if (!userRegistered) {
			return new ModelAndView("registerFailure");
		} else {
			return new ModelAndView("loginform");
		}
	}

}

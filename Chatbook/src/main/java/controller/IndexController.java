package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class IndexController {
	
	@RequestMapping("/")
	public String firstPage() {
		System.out.println("firstPage");
		return "userLogin.html";
	}

	@RequestMapping("/userLogin")
	public String getLogin() {
		System.out.println("login");
		return "userLogin.html";
	}

	@RequestMapping("/test")
	public String test() {
		System.out.println("test---");
		return "test.html";
	}
	
}

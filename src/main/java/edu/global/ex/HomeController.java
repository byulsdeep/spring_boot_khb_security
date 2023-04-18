package edu.global.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/user/userHome")
	public void userHome() {
		
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		
	}
}

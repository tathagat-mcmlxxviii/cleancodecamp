package com.cleancodecamp.library.frontend.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlleImpl implements HomeController {

	@Override
	@GetMapping("/")
	public String home(Model model) {
		// TODO Auto-generated method stub
		return "home";
	}
}

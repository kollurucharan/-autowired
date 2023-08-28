package com.springCharan;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Control {

	jdbc pointer;

	@Autowired
	public Control(jdbc pointer) {
		this.pointer = pointer;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(ModelUser user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("password", user.getPassword());
		String a = user.getUserName();
		String b = user.getPassword();
		String c = pointer.db(a);
		System.out.println(c);
		if (c.equals(b)) {
			return "user";
		} else {
			System.out.println("password is incorrect");
			return "user2";
		}
	}

}

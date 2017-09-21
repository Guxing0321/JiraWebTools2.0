package com.jira.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

	@RequestMapping("/login")
	public String index(HttpServletRequest request) {

		return "myTest";
	}

}

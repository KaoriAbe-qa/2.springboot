package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex20")
public class Ex20Contoller {

	@RequestMapping("")
	public String index() {
		//入力画面へ
		return "user/ex-20-index";
	}
}

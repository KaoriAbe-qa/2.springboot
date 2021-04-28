package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.Ex19Form;

@Controller
@RequestMapping("/ex19")
public class Ex19Controller {

	@RequestMapping("")
	public String index() {
		
		return "user/ex-19-input";
	}
	
	@RequestMapping("/create")
	public String create(Integer num1, Integer num2
			, RedirectAttributes redirectAttributes) {
		
		Ex19Form form = new Ex19Form();
		form.setNum1(num1);
		form.setNum2(num2);
		
		redirectAttributes.addFlashAttribute("form",form);
		
		return "redirect:/user/ex19info";
	}
	
	@RequestMapping("/ex19info")
	public String ex19info() {
		//フォワード
		return "user/ex-19-result";
	}
}

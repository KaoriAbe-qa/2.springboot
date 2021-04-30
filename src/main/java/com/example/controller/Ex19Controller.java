package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.Ex19Form;

//提出するときはGitHubから（2.springbootで連携）
//18までは提出済
@Controller
@RequestMapping("/ex19")
public class Ex19Controller {

	@RequestMapping("")
	public String index() {
		//入力画面へ
		return "user/ex-19-input";
	}
	
	@ModelAttribute
	public Ex19Form setUpForm() {
		return new Ex19Form();
	}
	
	@RequestMapping("/create")
	public String create(@Validated Ex19Form ex19Form //バリデーションが動くように
			, BindingResult result //エラーメッセージ格納オブジェクト
			, RedirectAttributes redirectAttributes
			) { 
		
		//もしエラーがあれば入力画面に遷移
		if(result.hasErrors()) {
			return index();
		}
		
		//オブジェクト
		Ex19Form form = new Ex19Form();
		//ex-19-result.htmlで計算式も出したいのでセット
		form.setNum1(ex19Form.getNum1());
		form.setNum2(ex19Form.getNum2());
		//Stringで受け取ったあとIntegerに変換
		Integer num1 = Integer.parseInt(ex19Form.getNum1());
		Integer num2 = Integer.parseInt(ex19Form.getNum2());
		Integer ans = num1 + num2;
		form.setAns(ans);
		
		//スコープに格納
		redirectAttributes.addFlashAttribute("form",form);
		
		//リダイレクト↓のはURL
		return "redirect:/ex19/ex19info";
	}
	
	@RequestMapping("/ex19info")
	public String ex19info() {
		//フォワード↓htmlを指す
		return "user/ex-19-result";
	}
}

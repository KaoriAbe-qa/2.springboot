package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("")
	public String index(Model model) {
		Map<Integer,String> hobbyMap = new LinkedHashMap<>();
		hobbyMap.put(1, "野球");
		hobbyMap.put(2, "サッカー");
		hobbyMap.put(3, "テニス");
		
		model.addAttribute("hobbyMap", hobbyMap);
		
		return "user/input";
	}
	
	//入力画面でもFormが必要になるときはこの記載
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("/create")
	public String create(@Validated UserForm form//バリデーションが動くように 
			, BindingResult result //エラーメッセージが格納されるオブジェクト
			, RedirectAttributes redirectAttributes
			, Model model ) {  //requestスコープを使用するための準備
		//UserForm form ：リクエストパラメータを取得
		//RedirectAttributes　：flashスコープを使用するための準備
		//flashスコープ　：1回のリダイレクトで有効なスコープ
		
		//もしエラーが1つでもあった場合は入力画面に遷移
		if(result.hasErrors()) {
			//入力画面遷移用のメソッドを呼んで入力画面に戻る
			return index(model);
		}
		
		User user = new User();
		//formオブジェクトからuserオブジェクトにプロパティ値をコピー
		//第一引数がコピー元、第二引数がコピー先
		BeanUtils.copyProperties(form, user);
		
		//上記でコピーできないhobbyListは手動でコピー
		List<String> hobbyList = new ArrayList<>();
		
		for(Integer hobbyCode:form.getHobbyList()) {
			switch(hobbyCode) {
			case 1:
				hobbyList.add("野球");
				break;
			case 2:
				hobbyList.add("サッカー");
				break;
			case 3:
				hobbyList.add("テニス");
				break;
			}
		}
		user.setHobbyList(hobbyList);
		
		//実際の業務処理「ユーザ登録をする」サービスクラスの呼び出し
		UserService userService = new UserService();
		user = userService.save(user);
		
		//今回はリクエストスコープではなくflashスコープに格納
		redirectAttributes.addFlashAttribute("user" ,user);
		
		//リダイレクト
		return "redirect:/user/toresult";
	}
	
	//リダイレクトでこのURLが動く
	@RequestMapping("/toresult")
	public String toresult() {
		//登録完了画面にフォワード
		return "user/result";
	}
}

package com.example.form;

import javax.validation.constraints.Pattern;

public class Ex19Form {
	
	//数値以外のときにエラー
	//Stringで受け取ってあとから変換
	@Pattern(regexp="^[0-9]",message="左のテキストボックスには数値を入力してください")
	private String num1;
	
	@Pattern(regexp="^[0-9]",message="右のテキストボックスには数値を入力してください")
	private String num2;
	
	private Integer ans;
	
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public Integer getAns() {
		return ans;
	}
	public void setAns(Integer ans) {
		this.ans = ans;
	}

}

package com.example.form;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Ex17Form {
	
	@NotBlank(message="値を入力してください")
	@Size(min=1, max=127, message="1桁以上127桁以下で入力してください")
	private String name;
	
	@Size(min=1, max=127, message="1桁以上127桁以下で入力してください")
	private String mail;
	
	@NotBlank(message="値を入力してください")
	private String gender;
	
	@NotEmpty(message="値を入力してください")
	private List<Integer> hobbyList;
	
	private List<Integer> langList;
	
	@Size(min=1, max=2000, message="1桁以上2000桁以下で入力してください")
	private String text;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Integer> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<Integer> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public List<Integer> getLangList() {
		return langList;
	}
	public void setLangList(List<Integer> langList) {
		this.langList = langList;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}

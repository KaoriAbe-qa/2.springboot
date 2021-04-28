package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.User;

@Service
public class UserService {

	public User save(User user) {
		//本来ならここでUserRepositoryを読んでDBにインサート
		//UserRepository repository = new UserRpositpry();
		//user = repository.insert(user);
		
		//ほかにDBにインサートする必要があればここに
		//例えば趣味など
		
		//さらに登録完了メールを送るときはここに
		
		return user;
	}
}

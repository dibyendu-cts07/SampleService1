package com.cts.sr.moviecruiser.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sr.moviecruiser.user.model.User;
import com.cts.sr.moviecruiser.user.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean save(User user) throws Exception {
		Mono<User> dbUser = userRepository.findById(user.getUserId());
		if (dbUser.blockOptional().isPresent()) {
			return false;
		}
		userRepository.save(user).block();
		return true;
	}

	@Override
	public User find(String userId, String password) throws Exception {
		User user = userRepository.findByUserIdAndPassword(userId, password).block();
		return user;
	}

	@Override
	public User find(String userId) throws Exception {
		User user = userRepository.findById(userId).block();
		return user;
	}

}

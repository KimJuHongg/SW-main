package com.wnjd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wnjd.model.entity.BoardUser;
import com.wnjd.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public BoardUser create(String username, String email, String password) {
		BoardUser user = new BoardUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		return user;
	}

	public BoardUser getUser(String name) {
		Optional<BoardUser> boardUser = userRepository.findByUsername(name);
		if (boardUser.isPresent()) {
			return boardUser.get();
		} else {
			throw new DataNotFoundException();
		}
	}
}

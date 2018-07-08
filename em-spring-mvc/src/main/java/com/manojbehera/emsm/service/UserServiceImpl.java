package com.manojbehera.emsm.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.manojbehera.emsm.persistence.UserRepository;
import com.manojbehera.emsm.persistence.model.User;
import com.manojbehera.emsm.validation.EmailExistsException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User registerNewUser(final User user) {
		if (emailExist(user.getEmail())) {
			throw new EmailExistsException("There is an account with that email address: " + user.getEmail());
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setPasswordConfirmation(passwordEncoder.encode(user.getPasswordConfirmation()));
		return repository.save(user);
	}

	private boolean emailExist(String email) {
		final User user = repository.findByEmail(email);
		return user != null;
	}

}

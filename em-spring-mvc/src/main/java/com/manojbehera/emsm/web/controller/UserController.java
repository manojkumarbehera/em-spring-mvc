package com.manojbehera.emsm.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manojbehera.emsm.persistence.UserRepository;
import com.manojbehera.emsm.persistence.model.User;
import com.manojbehera.emsm.service.UserService;

@Controller
@RequestMapping(value =  "/user")
public class UserController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/welcome")
	public ModelAndView list() {
		Iterable<User> users = this.userRepository.findAll();
		return new ModelAndView("welcome", "users", users);
	}

	@RequestMapping("{id}")
	public ModelAndView view(@PathVariable("id") User user) {
		return new ModelAndView("view", "user", user);
	}

	@RequestMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") final Long id) {
		this.userRepository.delete(id);
		Iterable<User> users = this.userRepository.findAll();
		return new ModelAndView("welcome", "users", users);
	}

	@RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
	public ModelAndView modifyForm(@PathVariable("id") final User user) {
		return new ModelAndView("userform", "user", user);
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	// @PreAuthorize("hasAnyAuthority('ADMIN')")
	public String createForm(@ModelAttribute final User user) {
		return "userform";
	}

}

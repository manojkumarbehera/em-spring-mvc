package com.manojbehera.emsm.web.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manojbehera.emsm.persistence.RoleRepository;
import com.manojbehera.emsm.persistence.model.Role;
import com.manojbehera.emsm.persistence.model.User;
import com.manojbehera.emsm.service.UserService;
import com.manojbehera.emsm.validation.EmailExistsException;

@Controller
public class RegistrationController {

	private static final String REGISTRATION_PAGE = "registrationPage";

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "signup")
	public String registrationForm(@ModelAttribute User user, Model model) {

		model.addAttribute("user", user);
		return REGISTRATION_PAGE;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute final User user, final BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView(REGISTRATION_PAGE, "user", user);
		}
		try {
			final Role userRole = roleRepository.findByName("ROLE_USER");
			user.setRoles(Arrays.asList(userRole));
			userService.registerNewUser(user);
		} catch (EmailExistsException e) {
			result.addError(new FieldError("user", "email", e.getMessage()));
			return new ModelAndView(REGISTRATION_PAGE, "user", user);
		}
		return new ModelAndView("redirect:/login");
	}

}

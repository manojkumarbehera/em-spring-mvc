package com.manojbehera.emsm.service;

import com.manojbehera.emsm.persistence.model.User;
import com.manojbehera.emsm.validation.EmailExistsException;

public interface UserService {

	User registerNewUser(User user) throws EmailExistsException;
}

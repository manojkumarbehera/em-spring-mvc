package com.manojbehera.emsm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manojbehera.emsm.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}

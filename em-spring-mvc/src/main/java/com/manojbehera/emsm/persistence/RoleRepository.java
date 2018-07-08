package com.manojbehera.emsm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manojbehera.emsm.persistence.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}

package com.manojbehera.emsm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manojbehera.emsm.persistence.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}

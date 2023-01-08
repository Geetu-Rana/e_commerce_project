package com.eCart.project.model.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCart.project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByRole(String role);
}

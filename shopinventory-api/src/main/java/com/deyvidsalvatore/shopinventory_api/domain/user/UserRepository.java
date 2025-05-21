package com.deyvidsalvatore.shopinventory_api.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	Optional<UserModel> findByEmail(String email);
	Optional<UserModel> findByUsername(String username);
	
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
	boolean existsByMobile(String mobile);
}

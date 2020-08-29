package com.stock.user.impl.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stock.user.impl.internal.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findFirstByCodeAndPassword(String code, String password);
	
}

package com.work.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.springSecurity.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
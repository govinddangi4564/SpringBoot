package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

}

package com.candidjava.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candidjava.springboot.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

}


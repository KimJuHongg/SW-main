package com.wnjd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wnjd.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
   User getByUid(String uid);
}
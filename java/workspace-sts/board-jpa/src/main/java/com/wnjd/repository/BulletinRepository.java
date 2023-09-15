package com.wnjd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wnjd.model.entity.Bulletin;

public interface BulletinRepository extends JpaRepository<Bulletin, Integer> {
	
	
}

package com.wnjd.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wnjd.model.entity.Ramen;
import com.wnjd.repository.RamenRepository;

@Service
public class RamenService {
	@Autowired
	RamenRepository ramenRepository;
	
	public Ramen getContent(int no) throws DataAccessException {
		Optional<Ramen> oRamen = ramenRepository.findById(no);
		Ramen ramen = null;
		if(oRamen.isPresent()) {
			ramen = oRamen.get();
		}
		
		return ramen;
	}
}

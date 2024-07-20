package com.ems.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ems.entity.ProductiveEntity;

import com.ems.repository.ProductiveRepository;
import com.ems.service.ProductiveService;

@Service
public class ProductiveServiceImpl implements ProductiveService{

	
	@Autowired
	private ProductiveRepository productiverepo;

	
	@Override
	public Boolean saveProductive(ProductiveEntity entity) {
		productiverepo.save(entity);
		return true;
	}


	@Override
	public List<ProductiveEntity> getAllProductive() {
		
		return productiverepo.findAll();
	}


	@Override
	public Optional<ProductiveEntity> getProductiveById(Long id) {
		return productiverepo.findById(id);
		
	}


	
}

package com.ems.service;

import java.util.List;
import java.util.Optional;


import com.ems.entity.ProductiveEntity;


public interface ProductiveService {
	
	public Boolean saveProductive(ProductiveEntity entity);
	
	public List<ProductiveEntity> getAllProductive();
    
	Optional<ProductiveEntity> getProductiveById(Long id);




}

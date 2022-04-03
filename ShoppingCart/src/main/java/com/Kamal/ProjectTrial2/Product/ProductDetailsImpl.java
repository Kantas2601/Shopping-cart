package com.Kamal.ProjectTrial2.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kamal.ProjectTrial2.dao.ProductDao;

@Service
public class ProductDetailsImpl implements ProductDetails {

	
	@Autowired
	private ProductDao dao;
	
	@Override
	public Products addProduct(Products product) {
		dao.save(product);
		return product;
	}

	@Override
	public Products updateProduct(Products product) {
		dao.save(product);
		return product;
	}

	@Override
	public Products getProduct(int productId) {
		return dao.findById(productId).get();
	}
	
	

	
}

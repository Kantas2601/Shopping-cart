package com.Kamal.ProjectTrial2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Kamal.ProjectTrial2.Product.Products;

@Repository
public interface ProductDao extends JpaRepository<Products, Integer> {
	
	List <Products> findByCategory(String Category);
	
	@Query(value= "select* from products p where p.details = :n or p.name= :n or p.subcategory= :n", nativeQuery = true)
	List <Products> findBySearch(@Param("n") String searchString);

}

package com.Kamal.ProjectTrial2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Kamal.ProjectTrial2.cart.AddtoCart;

@Repository
public interface AddToCartRepo extends JpaRepository<AddtoCart, Long> {
	
	
	  @Query(value="select * from CART addtocart where addtocart.user_id = :n", nativeQuery=true)
	  List<AddtoCart> findByUserId(@Param("n") long userId);
	  
	  @Query(value="select* from CART addtocart where addtocart.user_id= :n and cart_id =:m", nativeQuery = true)
	  List<AddtoCart> findByuserIdAndCartId(@Param("n") long userId, @Param("m") long CartId);
	  
	  @Modifying
	  @Query(value="insert into CART (user_id,qty, product_id) VALUES (:insertLink,1,:PId)", nativeQuery = true)
	  @Transactional
	  void insertIntoCart(@Param("insertLink") Long userId, @Param("PId") int ProductId);
	  
	  @Modifying
	  @Query(value="delete from CART WHERE USER_ID= :n AND product_id= :m", nativeQuery= true)
	  @Transactional
	  void deleteFromCart(@Param("n") long userId, @Param("m") int ProductId);
	  
	  
	  @Query(value="select* from CART where user_id= :n and product_id =:m", nativeQuery = true)
	  AddtoCart viewAddedProduct(@Param("n") long userId, @Param("m") int ProductId);
	 

}

package com.Kamal.ProjectTrial2.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kamal.ProjectTrial2.dao.AddToCartRepo;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private AddToCartRepo cartRepo;

	@Override
	public List<AddtoCart> getCartByUserId(long userId) {
		
		return cartRepo.findByUserId(userId);
	}

	@Override
	public List<AddtoCart> getCartByUserIdAndCartId(long userId, long CartId) {
		return cartRepo.findByuserIdAndCartId(userId, CartId);
	}

	@Override
	public void addProductInCart(long userId, int ProductId) {
		cartRepo.insertIntoCart(userId, ProductId);
	}

	@Override
	public void removeFromCart(long userId, int ProductId) {
		cartRepo.deleteFromCart(userId, ProductId);
		
	}

}

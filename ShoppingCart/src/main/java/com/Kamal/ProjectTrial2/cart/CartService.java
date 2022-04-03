package com.Kamal.ProjectTrial2.cart;

import java.util.List;

public interface CartService
{
	List <AddtoCart> getCartByUserId(long userId);
	
	List <AddtoCart> getCartByUserIdAndCartId(long userId, long CartId);
	
	void addProductInCart(long userId, int ProductId);
	
	void removeFromCart(long userId, int ProductId);
	
	

}

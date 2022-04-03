package com.Kamal.ProjectTrial2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Kamal.ProjectTrial2.cart.AddtoCart;
import com.Kamal.ProjectTrial2.cart.CartService;

@RestController
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/{userId}/getCart")
	public List<AddtoCart> getCartByUserId(@PathVariable String userId){
		System.out.println(userId);
		return this.cartService.getCartByUserId(Long.parseLong(userId));
	}
	
	@GetMapping("/cart/{userId}/getCartItem/{cartitemId}")
	public List<AddtoCart> getCartByUserIdAndCartId(@PathVariable String userId, @PathVariable String cartitemId){
		System.out.println(userId+cartitemId);
		return this.cartService.getCartByUserIdAndCartId(Long.parseLong(userId), Long.parseLong(cartitemId));
	}
	
	@GetMapping("/cart/{userId}/add/{productId}")
	public void addProductIntoCart(@PathVariable String userId, @PathVariable String productId){
		this.cartService.addProductInCart(Long.parseLong(userId), Integer.parseInt(productId));
		System.out.println("done");
		
		//return this.cartService.getCartByUserIdAndCartId(Long.parseLong(userId), Long.parseLong(productId));
	}
	
	@GetMapping("/cart/{userId}/remove/{productId}")
	public void removeFromCart(@PathVariable String userId, @PathVariable String productId) {
		this.cartService.removeFromCart(Long.parseLong(userId), Integer.parseInt(productId));
		System.out.println("done");
	}
	

}

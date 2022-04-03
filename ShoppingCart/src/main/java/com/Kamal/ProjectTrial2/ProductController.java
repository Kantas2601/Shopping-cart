package com.Kamal.ProjectTrial2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Kamal.ProjectTrial2.Product.ProductDetails;
import com.Kamal.ProjectTrial2.Product.Products;
import com.Kamal.ProjectTrial2.dao.ProductDao;

@RestController
@RequestMapping("/products")
public class ProductController 
{
	@Autowired
	private ProductDetails productDetails;
	
	@Autowired
	ProductDao pdao;
	
	@PostMapping("/addProduct")
	public Products addProducts(@RequestBody Products product) {
		return this.productDetails.addProduct(product);
		
	}
	
	@PostMapping("/update")
	public Products modifyProducts(@RequestBody Products product) {
		return this.productDetails.updateProduct(product);
	}
	
	@GetMapping("/getById/{productId}")
	public Products searchProduct(@PathVariable String productId) {
		System.out.println(productId);
		return this.productDetails.getProduct(Integer.parseInt(productId));
	}
	
	@GetMapping("/getByCategory/{category}")
	public ResponseEntity<List<Products>> getProductsByCategory(@PathVariable String category){
		System.out.println(category);
		return new ResponseEntity<List<Products>>(pdao.findByCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/search/{searchString}")
	public List<Products> getProductsBySearch(@PathVariable String searchString){
		return this.pdao.findBySearch(searchString);
	}

}

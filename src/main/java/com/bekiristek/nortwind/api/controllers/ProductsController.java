package com.bekiristek.nortwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bekiristek.nortwind.business.abstracts.ProductService;
import com.bekiristek.nortwind.core.utilities.results.DataResult;
import com.bekiristek.nortwind.core.utilities.results.Result;
import com.bekiristek.nortwind.entities.concretes.Product;

@RestController  // Farklı platformlardan gelen istekleri cevaplar.
@RequestMapping("/api/products")	
public class ProductsController {
	
	
	private ProductService productServise;
	
	@Autowired
	public ProductsController(ProductService productServise) {
		super();
		this.productServise = productServise;
	}


	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		
		return this.productServise.getAll();
				
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productServise.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		
		return this.productServise.getByProductName(productName);
				
		
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, @RequestParam int categoryId){
		
		return this.productServise.getByProductNameAndCategoryId(productName,categoryId);
				
		
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		
		return this.productServise.getByProductNameContains(productName);
				
		
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<Product>> getAllSorted(){
		
		return this.productServise.getAllSorted();
				
		
	}

}

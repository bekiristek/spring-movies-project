package com.bekiristek.nortwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bekiristek.nortwind.core.utilities.results.DataResult;
import com.bekiristek.nortwind.core.utilities.results.Result;
import com.bekiristek.nortwind.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSorted();
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	 
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	 
	DataResult< List<Product>> getByCategoryIdIn(List<Integer> categories);
	 
	DataResult< List<Product>> getByProductNameContains(String productName);
	 
	DataResult< List<Product>> getByProductNameStartsWith(String productName);


	DataResult< List<Product>> getByNameAndCategoryId(String productName,int categoryId);
	 
	
	
}

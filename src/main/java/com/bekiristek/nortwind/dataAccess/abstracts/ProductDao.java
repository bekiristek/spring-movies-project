package com.bekiristek.nortwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bekiristek.nortwind.entities.concretes.Product;
import com.bekiristek.nortwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {

	 Product getByProductName(String productName);
	 
	 Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	 List<Product> getByProductNameOrCategory(String productName, int categoryId);
	 
	 List<Product> getByCategoryIn(List<Integer> categories);
	 
	 List<Product> getByProductNameContains (String productName);
	 
	 List<Product> getByProductNameStartsWith(String productName);


	 @Query("From Product where productName=:productName and category.categoryId=:categoryId")
	 List<Product> getByNameAndCategory(String productName,int categoryId);

	 
	 List<ProductWithCategoryDto> getProductWithCategoryDetails();
}

package com.bekiristek.nortwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bekiristek.nortwind.business.abstracts.ProductService;
import com.bekiristek.nortwind.core.utilities.results.DataResult;
import com.bekiristek.nortwind.core.utilities.results.Result;
import com.bekiristek.nortwind.core.utilities.results.SuccessDataResult;
import com.bekiristek.nortwind.dataAccess.abstracts.ProductDao;
import com.bekiristek.nortwind.entities.concretes.Product;


@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	
	
    @Autowired  // ProductDao interface türünden nesne oluşturuyor. İnterface olsa dahi...
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"Data Listelendi.");
				
				
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessDataResult<>("Ürün Eklendi.");
				
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult <Product>
		(this.productDao.getByProductName(productName),"Data Listelendi.");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult <Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory(productName,categoryId),"Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort= Sort.by(Sort.Direction.ASC, "unitPrice");
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Data Listelendi.");
	}
	
	
	
	}



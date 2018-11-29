package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>
{
	Product getProductById(Integer id);
}

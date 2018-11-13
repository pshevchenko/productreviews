package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>
{
	Category getCategoryById(Integer id);
}

package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>
{
}

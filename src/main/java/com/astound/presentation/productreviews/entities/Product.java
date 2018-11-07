package com.astound.presentation.productreviews.entities;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class Product
{
	private Integer id;
	private String name;
	private Double price;
	private String description;
	private List<Review> reviews;
}

package com.astound.presentation.productreviews.entities;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Product
{
	private String name;
	private Double price;
	private String description;
}

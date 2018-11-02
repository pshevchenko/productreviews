package com.astound.presentation.productreviews.entities;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
public class Category
{
	private int id;
	private String name;
	private String description;
	private List<Product> products = new ArrayList<>();
}

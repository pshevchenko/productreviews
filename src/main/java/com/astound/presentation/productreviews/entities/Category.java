package com.astound.presentation.productreviews.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category
{
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany
	private List<Product> products = new ArrayList<>();

	private String name;
	private String description;
}

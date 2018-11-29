package com.astound.presentation.productreviews.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	private List<Product> products = new ArrayList<>();

	private String name;
	private String description;
}

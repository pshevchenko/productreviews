package com.astound.presentation.productreviews.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product
{
	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
	private List<Review> reviews;

	private String name;
	private Double price;
	private String description;

}

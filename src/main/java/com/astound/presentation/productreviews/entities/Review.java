package com.astound.presentation.productreviews.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review
{
	@Id
	@GeneratedValue
	private Integer id;

	private Integer productId;
	private String text;

}

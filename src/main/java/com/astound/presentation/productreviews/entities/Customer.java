package com.astound.presentation.productreviews.entities;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class Customer
{
	private String name;
	private String login;
	private String password;
}

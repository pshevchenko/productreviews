package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Review;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest
{
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getProduct() throws Exception
	{
		mockMvc.perform(get("/products/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/jsp/product.jsp"))
				.andExpect(model().attribute("product", hasProperty("id", is(1))))
				.andExpect(model().attribute("product", hasProperty("name", is("Product 1"))))
				.andExpect(model().attribute("product", hasProperty("description", is("desc1"))));
	}

	@Test
	public void addReview() throws Exception
	{
		mockMvc.perform(
				post("/products/1/reviews")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("productId", "1")
						.param("text", "omnomnom1")
						.sessionAttr("review", new Review())
		)
				.andDo(print());
		mockMvc.perform(
					post("/products/1/reviews")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.param("productId", "1")
					.param("text", "omnomnom2")
					.sessionAttr("review", new Review())
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/jsp/product.jsp"))
				.andExpect(model().attribute("product", hasProperty("id", is(1))))
				.andExpect(model().attribute("product", hasProperty("reviews", hasSize(2))))
				.andExpect(model().attribute("product", hasProperty("reviews", hasItem(
						allOf(
								Matchers.<Review>hasProperty("productId", is(1)),
								Matchers.<Review>hasProperty("text", is("omnomnom1"))
						)
				)))).andExpect(model().attribute("product", hasProperty("reviews", hasItem(
						allOf(
								Matchers.<Review>hasProperty("productId", is(1)),
								Matchers.<Review>hasProperty("text", is("omnomnom2"))
						)
				))));
	}
	@Test
	public void productPageFailed() throws Exception{
		mockMvc.perform(get("/products/8"))
				.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(forwardedUrl("/jsp/error.jsp"));
	}
}

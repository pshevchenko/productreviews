package com.astound.presentation.productreviews.repository;



import com.astound.presentation.productreviews.entities.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;




@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest
{
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void whenFindByName_thenReturnEmployee() {
		Category category2 = Category.builder().name("Category 2").description("desc").build();
		entityManager.persist(category2);
		entityManager.flush();

		// when
		Category found = categoryRepository.getCategoryById(category2.getId());

		assertThat(found.getName())
				.isEqualTo(category2.getName());

		// then
		assertThat(found.getName())
				.isEqualTo(category2.getName());
	}
}

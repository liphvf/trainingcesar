package training.osms.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import training.osms.business.Category;

public class CategoryDao {
	private final EntityManagerFactory factory = EntityManagerFactoryHolder.factory;

	public boolean containsCategory(String categoryName) {
		EntityManager manager = factory.createEntityManager();

		TypedQuery<Category> query = manager
				.createQuery(
						"select category from training.osms.business.category category where upper(category.name) = :categoryName ",
						Category.class);

		query.setParameter("categoryName", categoryName.toUpperCase());

		List<Category> result = query.getResultList();

		return result.isEmpty() == false;
	}

	public void insertCategory(Category category) {
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		manager.persist(category);
		
		transaction.commit();

	}

}

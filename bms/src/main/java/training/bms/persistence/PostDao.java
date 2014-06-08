package training.bms.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import training.bms.business.PostSearchOptions;
import training.bms.business.Post;

public class PostDao {
	

	public void insertPost(Post post) {

		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(post);
		transaction.commit();

	}

	public List<Post> searchPost(PostSearchOptions options) {
		StringBuilder predicate = new StringBuilder("1=1");

		if (options.getTitle() != null && options.getTitle().length() > 0) {
			predicate.append(" and upper(Post.title) like :postTitle");

		}

		if (options.getText() != null
				&& options.getText().length() > 0) {
			predicate
					.append(" and upper(Post.text) like :postText");

		}
		
		if (options.getDate() != null) {
			predicate.append(" and upper(Post.date) like :postDate");

		}
		
		if (options.getAuthor() != null && options.getAuthor().length() > 0) {
			predicate.append(" and upper(Post.Author) like :postAuthor");

		}

		
		
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();

		TypedQuery<Post> query = manager.createQuery(
				"select post from Post post where " + predicate, Post.class);

		if (options.getTitle() != null && options.getTitle().length() > 0) {
			query.setParameter("postTitle", "%"
					+ options.getTitle().toUpperCase() + "%");

		}

		
		if (options.getText() != null
				&& options.getText().length() > 0) {
			query.setParameter("postText", "%"
					+ options.getText().toUpperCase() + "%");

		}

		List<Post> result = query.getResultList();

		return result;
	}

	public Post searchPost(String postTitle) {

		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();

		TypedQuery<Post> query = manager
				.createQuery(
						"select post from training.bms.business.Post post where upper(post.title) = :postTitle ",
						Post.class);

		query.setParameter("postTitle", postTitle.toUpperCase());

		List<Post> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}

	}

	public void deletePost(Post post) {
		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Post managedPost = manager.find(Post.class, post.getId());

		transaction.begin();
		manager.remove(managedPost);
		transaction.commit();

	}

	public void updatePost(Post post) {

		EntityManagerFactory factory = EntityManagerFactoryHolder.factory;

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.merge(post);

		transaction.commit();

	}

}

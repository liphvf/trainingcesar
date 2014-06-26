package training.bms.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import training.bms.business.Post;
import training.bms.business.PostSearchOptions;
import training.bms.business.PostSearchOptions.Order;

@Component
public class PostDao {

	private @PersistenceContext
	EntityManager manager;

	// pensar se vale a pena
	// public boolean containsPost(String postTitle) {
	//
	// return searchPost(postTitle) != null;
	// }

	public void insertPost(Post post) {

		manager.persist(post);

	}

	public List<Post> searchPost(PostSearchOptions options) {
		StringBuilder predicate = toPredicate(options);

		if (options.getOrder() != null) {
			predicate.append(" order by post.");
			predicate.append(Order.TITLE.getValue());
			if (options.isDesc()) {
				predicate.append("desc");

			}

		}

		TypedQuery<Post> query = manager.createQuery(
				"select post from Post post where " + predicate, Post.class);

		setParameters(options, query);

		if (options.getStartPosition() != null) {
			query.setFirstResult(options.getStartPosition());
		}
		if (options.getMaxResults() != null) {
			query.setMaxResults(options.getMaxResults());
		}

		List<Post> result = query.getResultList();

		return result;
	}

	private StringBuilder toPredicate(PostSearchOptions options) {
		StringBuilder predicate = new StringBuilder("1=1");

		if (options.getPostId() != null) {
			predicate.append(" and post.id = :postId");
		}

		if (options.getBlogId() != null) {
			predicate.append(" and post.blog.id = :blogId");
		}

		if (options.getTitle() != null && options.getTitle().length() > 0) {
			predicate.append(" and upper(post.title) like :postTitle");

		}

		if (options.getText() != null && options.getText().length() > 0) {
			predicate.append(" and upper(post.text) like :postText");

		}

		if (options.getDate() != null) {
			predicate.append(" and upper(post.date) like :postDate");

		}

		if (options.getAuthor() != null && options.getAuthor().length() > 0) {
			predicate.append(" and upper(post.author) like :postAuthor");

		}
		return predicate;
	}

	public Post searchPost(String postTitle) {

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

	public int searchPostCount(PostSearchOptions options) {

		StringBuilder predicate = toPredicate(options);

		TypedQuery<Long> query = manager.createQuery(
				"SELECT count(post) FROM training.bms.business.Post post where "
						+ predicate, Long.class);

		setParameters(options, query);

		Long result = query.getSingleResult();
		// ele trocou para long pois o JPA, reclama avisando que pode estorar um
		// inteiro, como ele acha que não vai estourar, converteu o resultado
		// para um int mesmo

		return result.intValue();
	}

	private void setParameters(PostSearchOptions options, TypedQuery<?> query) {
		if (options.getTitle() != null && options.getTitle().length() > 0) {
			query.setParameter("postTitle", "%"
					+ options.getTitle().toUpperCase() + "%");

		}

		if (options.getText() != null && options.getText().length() > 0) {
			query.setParameter("postText", "%"
					+ options.getText().toUpperCase() + "%");

		}

		if (options.getAuthor() != null && options.getAuthor().length() > 0) {
			query.setParameter("postAuthor", "%"
					+ options.getAuthor().toUpperCase() + "%");
		}

		if (options.getDate() != null) {
			query.setParameter("postDate", options.getDate());
		}

		if (options.getBlogId() != null) {
			query.setParameter("blogId", options.getBlogId());
		}

		if (options.getPostId() != null) {
			query.setParameter("postId", options.getPostId());
		}
	}

	public void deletePost(Post post) {

		Post managedPost = manager.find(Post.class, post.getId());

		manager.remove(managedPost);

	}

	public void updatePost(Post post) {

		manager.merge(post);

	}

}

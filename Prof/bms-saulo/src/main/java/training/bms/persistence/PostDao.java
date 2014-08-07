package training.bms.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import training.bms.business.Post;
import training.bms.business.PostSearchOptions;

@Component
public class PostDao {
	private @PersistenceContext EntityManager manager; 
	
	public void insertPost(Post post) {
		manager.persist(post);
	}
	
	public int searchPostCount(PostSearchOptions options) {
		StringBuilder predicate = toPredicate(options);				
		String jpql = "select count(post) from Post post where " + predicate;
		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		setParameters(options, query);
		Long result = query.getSingleResult();
		return result.intValue();
	}		

	private StringBuilder toPredicate(PostSearchOptions options) {
		StringBuilder predicate = new StringBuilder("1 = 1");
		if (options.getPostId() != null) {
			predicate.append(" and post.id = :postId");
		}		
		if (options.getBlogId() != null) {
			predicate.append(" and post.blog.id = :blogId");
		}
		if (options.getTitle() != null && options.getTitle().length() > 0) {
			predicate.append(" and upper(post.title) like :postTitle");			
		}
		if (options.getBody() != null && options.getBody().length() > 0) {
			predicate.append(" and upper(post.body) like :postBody");
		}
		return predicate;
	}

	private void setParameters(PostSearchOptions options, TypedQuery<?> query) {
		if (options.getPostId() != null) {
			query.setParameter("postId", options.getPostId());
		}				
		if (options.getBlogId() != null) {
			query.setParameter("blogId", options.getBlogId());
		}		
		if (options.getTitle() != null && options.getTitle().length() > 0) {
			query.setParameter("postTitle", "%" + options.getTitle().toUpperCase() + "%");
		}
		if (options.getBody() != null && options.getBody().length() > 0) {
			query.setParameter("postBody", "%" + options.getBody().toUpperCase() + "%");
		}
	}

	public List<Post> searchPost(PostSearchOptions options) {
		StringBuilder predicate = toPredicate(options);
		if (options.getOrder() != null) {
			predicate.append(" order by post.");
			predicate.append(options.getOrder().getValue());
			if (options.getDesc()) {
				predicate.append(" desc");
			}
		}
		String jpql = "select post from Post post where " + predicate;
		TypedQuery<Post> query = manager.createQuery(jpql, Post.class);		
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

	public void updatePost(Post post) {
		manager.merge(post);
	}
	
	public void deletePost(Post post) {
		Post managedPost = manager.find(Post.class, post.getId());		
		manager.remove(managedPost);
	}	
}
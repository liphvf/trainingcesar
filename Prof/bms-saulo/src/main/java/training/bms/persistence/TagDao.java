package training.bms.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import training.bms.business.Tag;
import training.bms.business.TagSearchOptions;

@Component
public class TagDao {
	private @PersistenceContext EntityManager manager;

	public void insertTag(Tag tag) {
		manager.persist(tag);
	}
	
	public int searchTagCount(TagSearchOptions options) {
		StringBuilder predicate = toPredicate(options);		
		String jpql = "select count(tag) from Tag tag where " + predicate;
		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		setParameters(options, query);
		Long result = query.getSingleResult();
		return result.intValue();
	}
	
	private StringBuilder toPredicate(TagSearchOptions options) {
		StringBuilder predicate = new StringBuilder("1 = 1");
		if (options.getTagId() != null) {
			predicate.append(" and tag.id = :tagId");			
		}				
		if (options.getName() != null && options.getName().length() > 0) {
			predicate.append(" and upper(tag.name) like :tagName");			
		}		
		return predicate;
	}

	private void setParameters(TagSearchOptions options, TypedQuery<?> query) {
		if (options.getTagId() != null) {
			query.setParameter("tagId", options.getTagId());
		}		
		if (options.getName() != null && options.getName().length() > 0) {
			query.setParameter("tagName", "%" + options.getName().toUpperCase() + "%");
		}
	}	
	
	public List<Tag> searchTag(TagSearchOptions options) {
		StringBuilder predicate = toPredicate(options);
		if (options.getOrder() != null) {
			predicate.append(" order by tag.");
			predicate.append(options.getOrder().getValue());
			if (options.getDesc()) {
				predicate.append(" desc");
			}
		}
		String jpql = "select tag from Tag tag where " + predicate;
		TypedQuery<Tag> query = manager.createQuery(jpql, Tag.class);		
		setParameters(options, query);
		if (options.getStartPosition() != null) {
			query.setFirstResult(options.getStartPosition());
		}
		if (options.getMaxResults() != null) {
			query.setMaxResults(options.getMaxResults());	
		}
		List<Tag> result = query.getResultList();
		return result;
	}
	
	public void updateTag(Tag tag) {
		manager.merge(tag);
	}
	
	public void deleteTag(Tag tag) {
		Tag managedTag = manager.find(Tag.class, tag.getId());		
		manager.remove(managedTag);
	}
	
	public boolean containsTag(String tagName) {
		return searchTag(tagName) != null;
	}

	public Tag searchTag(String tagName) {
		TypedQuery<Tag> query = manager.createQuery(
			"select tag from training.bms.business.Tag tag where upper(tag.name) = :tagName", 
			Tag.class
		);
		query.setParameter("tagName", tagName.toUpperCase());		
		List<Tag> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}		
}
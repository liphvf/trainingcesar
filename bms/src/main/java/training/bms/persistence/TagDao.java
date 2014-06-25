package training.bms.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import training.bms.business.Tag;
import training.bms.business.TagSearchOptions;

public class TagDao {
	private @PersistenceContext
	EntityManager manager;

	public void insertTag(Tag tag) {
		manager.persist(tag);

	}

	public void deleteTag(Tag tags) {

	}

	public void updateTag(Tag tags) {

	}

	public Tag searchTag(String tagName) {
		TypedQuery<Tag> query = manager
				.createQuery(
						"SELECT tag FROM training.bms.business.Tag tag WHERE UPPER(tag.name) = :tagName",
						Tag.class);
		query.setParameter("tagName", tagName.toUpperCase());
		List<Tag> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	public List<Tag> searchTag(TagSearchOptions options) {

		StringBuilder predicate = new StringBuilder("1 = 1");

		if (options.getId() != null) {
			predicate.append(" and tag.id = :tagId");
		}

		if (options.getName() != null && options.getName().length() > 0) {
			predicate.append(" and upper(tag.name) like :tagName");
		}

		TypedQuery<Tag> query = manager.createQuery(
				"SELECT tag FROM training.bms.business.Tag tag where "
						+ predicate, Tag.class);

		if (options.getId() != null) {
			query.setParameter("tagId", options.getId());
		}

		if (options.getName() != null && options.getName().length() > 0) {
			query.setParameter("tagName", "%" + options.getName().toUpperCase()
					+ "%");
		}

		List<Tag> result = query.getResultList();

		return result;
	}

}

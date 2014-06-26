package training.bms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import training.bms.persistence.PostDao;
import training.bms.persistence.TagDao;

@Component
public class TagController {

	private @Autowired
	TagDao dao;

	public TagDao getDao() {
		return dao;
	}

	public void setDao(TagDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void saveTag(Tag tag) {
		dao.insertTag(tag);
	}

	@Transactional
	public void deleteTag(Tag tag) {
		dao.deleteTag(tag);
	}

	@Transactional
	public void updateTag(Tag tag) {
		dao.updateTag(tag);
	}

	public int postCount() {

		PostSearchOptions options = new PostSearchOptions();
		options.setAuthor("");
		PostDao dao = new PostDao();

		return dao.searchPostCount(options);
	}

	public List<Tag> searchTag(TagSearchOptions options) {
		return dao.searchTag(options);
	}
}

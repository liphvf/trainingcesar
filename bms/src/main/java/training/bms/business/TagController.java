package training.bms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import training.bms.persistence.PostDao;
import training.bms.persistence.TagDao;

@Component
public class TagController {

	private @Autowired TagDao dao;

	public TagDao getDao() {
		return dao;
	}

	public void setDao(TagDao dao) {
		this.dao = dao;
	}

	public void saveTag(Tag tag) {
		dao.insertTag(tag);
	}

	public void deleteTag(Tag tag) {
		dao.deleteTag(tag);
	}

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

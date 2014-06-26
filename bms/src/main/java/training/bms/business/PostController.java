package training.bms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import training.bms.persistence.PostDao;

@Component
public class PostController {

	private @Autowired PostDao dao;
	

	@Transactional
	public void savePost(Post post) {

		dao.insertPost(post);

	}

	public PostDao getDao() {
		return dao;
	}

	public void setDao(PostDao dao) {
		this.dao = dao;
	}

	public List<Post> searchPost(PostSearchOptions options) {

		return dao.searchPost(options);
	}

	public Integer searchPostCount(PostSearchOptions options) {

		return dao.searchPostCount(options);
	}

	@Transactional
	public void deletePost(Post post) {

		dao.deletePost(post);
	}

	// public void updatePost(Post post) {
	//
	// Post databasePost = dao.searchPost(post.getTitle());
	//
	// if (databasePost == null) {
	// dao.updatePost(post);
	// } else {
	//
	// if (post.getId().equals(databasePost.getId())) {
	//
	// dao.updatePost(post);
	//
	// } else {
	// throw new BusinessException(" the is a Post named "
	// + post.getTitle() + " already ");
	//
	// }
	// }
	//
	// }

	@Transactional
	public void updatePost(Post post) {
		dao.updatePost(post);
	}

}

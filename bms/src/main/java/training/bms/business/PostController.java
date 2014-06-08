package training.bms.business;

import java.util.List;

import javax.management.RuntimeErrorException;

import training.bms.persistence.PostDao;

public class PostController {

	public PostController() {
		dao = new PostDao();

	}

	private PostDao dao;

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

	public void deletePost(Post post) {

		dao.deletePost(post);
	}

//	public void updatePost(Post post) {
//
//		Post databasePost = dao.searchPost(post.getTitle());
//
//		if (databasePost == null) {
//			dao.updatePost(post);
//		} else {
//
//			if (post.getId().equals(databasePost.getId())) {
//
//				dao.updatePost(post);
//
//			} else {
//				throw new BusinessException(" the is a Post named "
//						+ post.getTitle() + " already ");
//
//			}
//		}
//
//	}

	
	public void updatePost(Post post) {
		dao.updatePost(post);
	}
	
}

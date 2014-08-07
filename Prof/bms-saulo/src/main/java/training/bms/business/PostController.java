package training.bms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import training.bms.persistence.PostDao;

@Component
public class PostController {
	private @Autowired PostDao dao;
		
	public void setDao(PostDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public void savePost(Post post) {
		dao.insertPost(post);
	}
	
	public Integer searchPostCount(PostSearchOptions options) {
		return dao.searchPostCount(options);
	}
	
	public List<Post> searchPost(PostSearchOptions options) {
		return dao.searchPost(options);
	}	

	@Transactional
	public void updatePost(Post post) {
		dao.updatePost(post);
	}
	
	@Transactional
	public void deletePost(Post post) {
		dao.deletePost(post);
	}	
}
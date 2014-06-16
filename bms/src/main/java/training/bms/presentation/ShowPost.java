package training.bms.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;

import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.PostSearchOptions;
//control + shift + o
@ManagedBean
public class ShowPost {

	private int postId;
	private Post post;
	
	

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getPostId() {
		return postId;
		
	}

	public void setPostId(int postId) {
		PostSearchOptions options = new PostSearchOptions();
		options.setPostId(postId);
		PostController controller = new PostController();
		List<Post> posts = controller.searchPost(options);
		
		if (posts.size() > 0) {
			post = posts.get(0);
			
		}
		
		
		this.postId = postId;
	}
	
	
	
	
}

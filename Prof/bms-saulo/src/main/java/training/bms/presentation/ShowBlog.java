package training.bms.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.Blog;
import training.bms.business.BlogController;
import training.bms.business.BlogSearchOptions;
import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.PostSearchOptions;
import training.bms.business.PostSearchOptions.Order;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ShowBlog {
	private @Autowired BlogController controller;
	private @Autowired PostController postController;
	private int blogId;
	private Blog blog;
	private List<Post> posts;
	
	public void setBlogId(int blogId) {
		this.blogId = blogId;
		
		BlogSearchOptions options = new BlogSearchOptions();
		options.setId(blogId);
		List<Blog> blogs = controller.searchBlog(options);
		if (blogs.size() > 0) {
			blog = blogs.get(0);
			
			PostSearchOptions postOptions = new PostSearchOptions();
			postOptions.setBlogId(blogId);
			postOptions.setOrder(Order.CREATION_DATE);
			postOptions.setDesc(true);			
			posts = postController.searchPost(postOptions);			
		}
	}
	
	public int getBlogId() {
		return blogId;
	}
	
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	public Blog getBlog() {
		return blog;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	
	public String getPostBodyPreview(Post post) {
		StringBuilder builder = new StringBuilder(); 
		for (int i = 0; i < post.getBody().length(); ++i) {
			char c = post.getBody().charAt(i);
			if (c == '\n' || c == '\r') {
				break;
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
}
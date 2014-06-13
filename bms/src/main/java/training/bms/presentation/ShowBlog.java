package training.bms.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;

import training.bms.business.Blog;
import training.bms.business.BlogController;
import training.bms.business.BlogSearchOptions;


@ManagedBean
public class ShowBlog {
	
	private Blog blog;
	private int blogId;


	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
		
		BlogSearchOptions options = new BlogSearchOptions();
		
		
		options.setId(blogId);
		
		BlogController controller = new BlogController();
		List<Blog> blogs = controller.searchBlog(options);
		
		if (blogs.size() > 0) {
			blog = blogs.get(0);
		}
	}
	
	
	

}

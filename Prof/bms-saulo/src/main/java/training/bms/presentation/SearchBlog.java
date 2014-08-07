package training.bms.presentation;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.Blog;
import training.bms.business.BlogController;
import training.bms.business.BlogSearchOptions;
import training.bms.business.BusinessException;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SearchBlog {
	private @Autowired BlogController controller;
	private BlogSearchOptions options;
	private List<Blog> result;
	private Blog blog;
	private boolean blogDeleted;
	
	public SearchBlog() {
		reset();
	}
	
	public void reset() {
		options = new BlogSearchOptions();
		result = null;
	}	
	
	public void setOptions(BlogSearchOptions options) {
		this.options = options;
	}
	
	public BlogSearchOptions getOptions() {
		return options;
	}
	
	public void setResult(List<Blog> result) {
		this.result = result;
	}
	
	public List<Blog> getResult() {
		return result;
	}
	
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	public Blog getBlog() {
		return blog;
	}
	
	public void setBlogDeleted(boolean blogDeleted) {
		this.blogDeleted = blogDeleted;
	}
	
	public boolean getBlogDeleted() {
		return blogDeleted;
	}
	
	public void search() {
		result = controller.searchBlog(options);
	}
	
	public String update(Blog blog) {		
		Blog blogAux = blog.clone();
/*
		blogAux.setId(blog.getId());
		blogAux.setName(blog.getName());
		blogAux.setDescription(blog.getDescription());
*/				
		this.blog = blogAux;
		return "updateBlog";
	}
	
	public void confirmUpdate() {
		String cliendId;
		FacesMessage message = new FacesMessage();
		try {
			controller.updateBlog(blog);
			reset();
			cliendId = null;			
			message.setSummary("Blog was successfully updated");
			message.setSeverity(FacesMessage.SEVERITY_INFO);			
		} catch (BusinessException e) {
			cliendId = "form:blog:name";
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);						
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(cliendId, message);
	}
		
	public String delete(Blog blog) {
		this.blog = blog;
		this.blogDeleted = false;
		return "deleteBlog";
	}
	
	public void confirmDeletion() {
		controller.deleteBlog(blog);		
		blogDeleted = true;
		reset();
		FacesMessage message = new FacesMessage();
		message.setSummary("Blog was successfully deleted");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);		
	}
}








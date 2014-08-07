package training.bms.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.Blog;
import training.bms.business.BlogController;
import training.bms.business.BusinessException;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NewBlog {
	private @Autowired BlogController controller;
	private Blog blog;	
	
	public NewBlog() {
		blog = new Blog();
	}
	
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	public Blog getBlog() {
		return blog;
	}
	
	public void saveBlog() {
		String clientId;
		FacesMessage message = new FacesMessage();		
		try {
			controller.saveBlog(blog);
			clientId = null;
			message.setSummary("Blog was successfully saved");
			message.setSeverity(FacesMessage.SEVERITY_INFO);			
		} catch (BusinessException e) {
			clientId = "form:blog:name";
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);						
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(clientId, message);
	}
}
package training.bms.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.BusinessException;
import training.bms.business.PostController;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NewPost {
	private @Autowired PostController controller;
	private PostForm form;
	
	public NewPost() {
		form = new PostForm();
	}
	
	public void setForm(PostForm form) {
		this.form = form;
	}
	
	public PostForm getForm() {
		return form;
	}
	
	public void savePost() {
		String clientId;
		FacesMessage message = new FacesMessage();		
		try {
			controller.savePost(form.getPost());
			clientId = null;
			message.setSummary("Post was successfully saved");
			message.setSeverity(FacesMessage.SEVERITY_INFO);			
		} catch (BusinessException e) {
			clientId = "form:post:name";
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);						
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(clientId, message);
	}
}
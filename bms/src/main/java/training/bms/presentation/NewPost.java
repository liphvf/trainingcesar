package training.bms.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.BusinessException;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NewPost {

	private PostForm form;
	private @Autowired PostController controller;

	public NewPost() {
		form = new PostForm();
	}

	public PostForm getForm() {
		return form;
	}

	public void setForm(PostForm form) {
		this.form = form;
	}

	public void savePost() {

		// cria a messsagem
		FacesMessage message = new FacesMessage();

		try {

			controller.savePost(form.getPost());
			message.setSummary("post was sucessfully saved");
			message.setSeverity(FacesMessage.SEVERITY_INFO);

		} catch (BusinessException e) {
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

		}

		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, message);

	}
}

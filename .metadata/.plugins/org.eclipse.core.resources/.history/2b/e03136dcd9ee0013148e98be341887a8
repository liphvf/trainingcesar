package training.bms.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.BusinessException;

@ManagedBean
public class NewPost {

	public NewPost() {
		post = new Post();
	}

	private Post post;



	public Post getPost() {
		return post;
	}



	public void setPost(Post post) {
		this.post = post;
	}



	public void savePost() {
		PostController controller = new PostController();

		// cria a messsagem
		FacesMessage message = new FacesMessage();

		try {
			controller.savePost(post);
			message.setSummary("post was sucessfully saved");
			message.setSeverity(FacesMessage.SEVERITY_INFO);

		} catch (BusinessException e) {
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

		}

		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage("form:post:title", message);

	}
}

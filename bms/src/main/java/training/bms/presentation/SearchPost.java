package training.bms.presentation;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.PostSearchOptions;
import training.bms.business.BusinessException;

@ManagedBean
@SessionScoped
public class SearchPost {

	private PostSearchOptions options;
	private List<Post> result;
	private Post post;
	private boolean postDeleted = false;
	private PostForm form;

	public PostForm getForm() {
		return form;
	}

	public void setForm(PostForm form) {
		this.form = form;
	}

	public SearchPost() {
		reset();

	}

	public void reset() {
		options = new PostSearchOptions();
		result = null;

	}

	public PostSearchOptions getOptions() {
		return options;
	}

	public void setOptions(PostSearchOptions options) {
		this.options = options;
	}

	public List<Post> getResult() {
		return result;
	}

	public void setResult(List<Post> result) {
		this.result = result;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public boolean isPostDeleted() {
		return postDeleted;
	}

	public void setPostDeleted(boolean postDeleted) {
		this.postDeleted = postDeleted;
	}

	public void search() {

		PostController controller = new PostController();
		result = controller.searchPost(options);
	}

	public String updatePost(Post post) {

		Post postAux = new Post();
		this.form = new PostForm();
		this.form.setPost(postAux);

		this.post = postAux;
		return "updatePost";
		// estamos retornando um autocamp, o faces-config vão

	}

	public void confirmUpdate() {
		FacesMessage message = new FacesMessage();

		try {
			PostController controller = new PostController();
			controller.updatePost(post);
			// deixa os valores em branco ao apertar o botao back
			reset();
			message.setSummary("post was sucessfully saved");
			message.setSeverity(FacesMessage.SEVERITY_INFO);

		} catch (BusinessException e) {
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

		}

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);

	}

	public String deletePost(Post post) {

		this.form = new PostForm();
		this.form.setPost(post);
		this.post = post;
		this.postDeleted = false;
		return "deletePost";
	}

	public void confirmDeletion() {

		FacesMessage message = new FacesMessage();

		PostController controller = new PostController();
		controller.deletePost(form.getPost());
		reset();
		
		postDeleted = true;
		message.setSummary(" post was sucessfully deleted ");
		message.setSeverity(FacesMessage.SEVERITY_INFO);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);

	}
}

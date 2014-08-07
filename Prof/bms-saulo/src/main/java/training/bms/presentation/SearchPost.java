package training.bms.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.BusinessException;
import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.PostSearchOptions;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SearchPost {
	private static final int RESULTS_PER_PAGE = 2;

	private @Autowired PostController controller;
	private PostSearchOptions options;
	private List<Integer> pages;
	private int page;
	private List<Post> result;
	private PostForm form;
	private boolean postDeleted;
	
	public SearchPost() {
		reset();
	}
	
	public void reset() {
		options = new PostSearchOptions();
		result = null;
	}	
	
	public void setOptions(PostSearchOptions options) {
		this.options = options;
	}
	
	public PostSearchOptions getOptions() {
		return options;
	}
	
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	
	public List<Integer> getPages() {
		return pages;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setResult(List<Post> result) {
		this.result = result;
	}
	
	public List<Post> getResult() {
		return result;
	}
	
	public void setForm(PostForm form) {
		this.form = form;
	}
	
	public PostForm getForm() {
		return form;
	}
		
	public void setPostDeleted(boolean postDeleted) {
		this.postDeleted = postDeleted;
	}
	
	public boolean getPostDeleted() {
		return postDeleted;
	}
	
	public void search() {
		int resultCount = controller.searchPostCount(options);
		int pageCount = resultCount / RESULTS_PER_PAGE;
		if (resultCount % RESULTS_PER_PAGE > 0) {
			++pageCount;
		}
		pages = new ArrayList<Integer>();
		for (int page = 1; page <= pageCount; ++page) {
			pages.add(page);
		}
		goToPage(1);
	}
	
	public void goToPage(int page) {
		this.page = page;
		
		int startPosition = (page - 1) * RESULTS_PER_PAGE;
		options.setStartPosition(startPosition);
		options.setMaxResults(RESULTS_PER_PAGE);
		result = controller.searchPost(options);
	}
	
	public String getPageClass(int page) {
		if (page == this.page) {
			return "active"; 
		} else {
			return "";
		}
	}
	
	public String update(Post post) {
		PostSearchOptions options = new PostSearchOptions();
		options.setPostId(post.getId());
		Post postAux = controller.searchPost(options).get(0);
//		Post postAux = post.clone();

/*
		postAux.setId(post.getId());
		postAux.setName(post.getName());
		postAux.setDescription(post.getDescription());
*/

		this.form = new PostForm();
		this.form.setPost(postAux);
		return "updatePost";
	}
	
	public void confirmUpdate() {
		String cliendId;
		FacesMessage message = new FacesMessage();
		try {
			controller.updatePost(form.getPost());
			reset();
			cliendId = null;			
			message.setSummary("Post was successfully updated");
			message.setSeverity(FacesMessage.SEVERITY_INFO);			
		} catch (BusinessException e) {
			cliendId = "form:post:name";
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);						
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(cliendId, message);
	}
		
	public String delete(Post post) {
		PostSearchOptions options = new PostSearchOptions();
		options.setPostId(post.getId());
		Post postAux = controller.searchPost(options).get(0);
		
		this.form = new PostForm();
		this.form.setPost(postAux);
		this.postDeleted = false;
		return "deletePost";
	}
	
	public void confirmDeletion() {
		controller.deletePost(form.getPost());		
		postDeleted = true;
		reset();
		FacesMessage message = new FacesMessage();
		message.setSummary("Post was successfully deleted");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);		
	}
}
package training.bms.presentation;

import java.util.ArrayList;
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

	private static final int RESULTS_PER_PAGE = 2;
	private PostSearchOptions options;
	private List<Post> result;
	private Post post;
	private boolean postDeleted = false;
	private PostForm form;
	private ArrayList<Integer> pages;
	// esse page é a página atual
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

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

	public ArrayList<Integer> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Integer> pages) {
		this.pages = pages;
	}

	public static int getResultsPerPage() {
		return RESULTS_PER_PAGE;
	}

	public void search() {

		PostController controller = new PostController();
		// result = controller.searchPost(options);

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
		// System.out.println(controller.searchPostCount(options));
	}

	public void goToPage(int page) {
		PostController controller = new PostController();

		this.page = page;
		// (pagina - 1) * results per pagina + 1
		// tirou o +1 pois o starPosition começa de 0
		options.setStartPosition((page - 1) * RESULTS_PER_PAGE);
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

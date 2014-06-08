package training.bms.presentation;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import training.bms.business.Blog;
import training.bms.business.BlogController;
import training.bms.business.BlogSearchOptions;
import training.bms.business.BusinessException;

@ManagedBean
@SessionScoped
// dita a vida util do menagedbean, dizendo que após receber uma requisição ele
// não descartará os valores do managedbean(e ele próprio)
// cada usuario tem sua sessão que é uma area de memoria aplicada a ele
// sessão tem um tempo de vida, pois se não teria problema que memoria
// request headers -> procura identificador de usuário
// caso não acha ele manda um cookie para aquele usuário ->
// cookie reiject (quando tenta capturar o cookie)
public class SearchBlog {

	private BlogSearchOptions options;
	private List<Blog> result;
	private Blog blog;
	private boolean blogDeleted = false;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public SearchBlog() {
		// options = new BlogSearchOptions();

		reset();

	}

	public void reset() {
		options = new BlogSearchOptions();
		result = null;

	}

	public BlogSearchOptions getOptions() {
		return options;
	}

	public void setOptions(BlogSearchOptions options) {
		this.options = options;
	}

	public List<Blog> getResult() {
		return result;
	}

	public void setResult(List<Blog> result) {
		this.result = result;
	}

	public boolean isBlogDeleted() {
		return blogDeleted;
	}

	public void setBlogDeleted(boolean blogDeleted) {
		this.blogDeleted = blogDeleted;
	}

	public void search() {
		
		
		BlogController controller = new BlogController();
		result = controller.searchBlog(options);
	}

	public String updateBlog(Blog blog) {

		// foi criar um propriedade blog, que salva esse blog no searchBlog, com
		// isso o updateBlog.xhtml eu posso acessar o searchBlog.java
		// this.blog = blog;

		Blog blogAux = new Blog();
		blogAux.setId(blog.getId());
		blogAux.setName(blog.getName());
		blogAux.setDescription(blog.getDescription());

		this.blog = blogAux;
		return "updateBlog";
		// estamos retornando um autocamp, o faces-config vão

	}

	public void confirmUpdate() {

		// // controller.saveBlog(blog);
		// passou para dentro do try
		// controller.updateBlog(blog);

		FacesMessage message = new FacesMessage();

		try {
			BlogController controller = new BlogController();
			controller.updateBlog(blog);
			// deixa os valores em branco ao apertar o botao back
			reset();
			message.setSummary("blog was sucessfully saved");
			message.setSeverity(FacesMessage.SEVERITY_INFO);

		} catch (BusinessException e) {
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

		}

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);

	}

	// enquanto ele está processando ele mantem o manage bean e todos os objetos
	// na memoria
	// cada botão é uma requisição no caso, ler -> processa -> apaga

	// como a lista e blog e o atributo blog, apotando para a mesmo objeto, a
	// mudandança em blog reflete na lista, que quando atualizado a pagina sem
	// apertar o botao search ele reflete essa mudança.

	public String deleteBlog(Blog blog) {
		this.blog = blog;
		// para o botao voltar a funcionar
		this.blogDeleted = false;
		return "deleteBlog";
	}

	public void confirmDeletion() {
		
		//não tem o try catch pois na regra de negocio não tem nenhuma execption

		FacesMessage message = new FacesMessage();

		BlogController controller = new BlogController();
		controller.deleteBlog(blog);
		// deixa os valores em branco ao apertar o botao back
		reset();
		// desabilita o botao
		blogDeleted = true;
		message.setSummary(" blog was sucessfully deleted ");
		message.setSeverity(FacesMessage.SEVERITY_INFO);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		
		//context está assosiado a requisição (ou seja menor que uma sessão) (perceba que ao re-carregar a pagina a menssagem some)

	}
}

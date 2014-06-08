package training.bms.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import training.bms.business.Blog;
import training.bms.business.BlogController;
import training.bms.business.BusinessException;

//Classes quer queremos veincular o click de um botão por exemplo, tem que ter a anotação em cima da classe @MenagedBean
// conceito data bainding

@ManagedBean
public class NewBlog {

	public NewBlog() {
		blog = new Blog();
	}

	private Blog blog;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public void saveBlog() {
		BlogController controller = new BlogController();

		// cria a messsagem
		FacesMessage message = new FacesMessage();

		try {
			controller.saveBlog(blog);

			// seta resumo
			message.setSummary("blog was sucessfully saved");

			// diz e severidade dele, a importancia
			message.setSeverity(FacesMessage.SEVERITY_INFO);

		} catch (BusinessException e) {
			// seta resumo
			message.setSummary(e.getMessage());

			// diz e severidade dele, a importancia
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

		}

		FacesContext context = FacesContext.getCurrentInstance();
		// no caso de null seria
		context.addMessage("form:blog:name", message);
		
		
		/* 	context.addMessage("id", message);
		 * 
		 * no xhtml
		 * <h:inputText id="#id" value="#{newBlog.blog.name}"></h:inputText>
		 * 
		 * <h:message for==>
		 * 
		 * DEPOIS VEJO
		 * 
		 * */

		// control + shift + r = procura por recurso ou seja arquivo o T,
		// porcura por classes

	}
}

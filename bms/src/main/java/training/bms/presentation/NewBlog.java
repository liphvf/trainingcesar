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

//Classes quer queremos veincular o click de um botão por exemplo, tem que ter a anotação em cima da classe @MenagedBean
// conceito data bainding

//@ManagedBean
@Component
// o que não tem session escope ficarioa REQUEST
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NewBlog {

	public NewBlog() {
		blog = new Blog();
	}

	// pedindo para o spring ejetar

	private Blog blog;
	private @Autowired
	BlogController controller;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public void saveBlog() {
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

	}
}

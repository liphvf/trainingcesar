package training.bms.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.BusinessException;
import training.bms.business.TagController;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NewTag {
	private @Autowired TagController controller;
	private TagForm form;
	
	public NewTag() {
		form = new TagForm();
	}
	
	public void setForm(TagForm form) {
		this.form = form;
	}
	
	public TagForm getForm() {
		return form;
	}
	
	public void saveTag() {
		String clientId;
		FacesMessage message = new FacesMessage();		
		try {
			controller.saveTag(form.getTag());
			clientId = null;
			message.setSummary("Tag was successfully saved");
			message.setSeverity(FacesMessage.SEVERITY_INFO);			
		} catch (BusinessException e) {
			clientId = "form:tag:name";
			message.setSummary(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);						
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(clientId, message);
	}
}
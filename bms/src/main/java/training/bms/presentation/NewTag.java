package training.bms.presentation;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.Post;
import training.bms.business.Tag;
import training.bms.business.TagController;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class NewTag {

	private Tag tag;
	private ArrayList<Post> postCount;
	private @Autowired TagController controller;

	public NewTag() {
		tag = new Tag();
		postCount = new ArrayList<>();  
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public void saveTag() {


		controller.saveTag(tag);
	}
	
	

	public ArrayList<Post> getPostCount() {
		return postCount;
	}

	public void setPostCount(ArrayList<Post> postCount) {
		this.postCount = postCount;
	}



}

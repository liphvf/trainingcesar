package training.bms.presentation;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import training.bms.business.Post;
import training.bms.business.Tag;
import training.bms.business.TagController;

@ManagedBean
public class NewTag {

	private Tag tag;
	private ArrayList<Post> postCount;

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

		TagController controller = new TagController();

		controller.saveTag(tag);
	}
	
	

	public ArrayList<Post> getPostCount() {
		return postCount;
	}

	public void setPostCount(ArrayList<Post> postCount) {
		TagController controller = new TagController();
		this.postCount = postCount;
	}



}

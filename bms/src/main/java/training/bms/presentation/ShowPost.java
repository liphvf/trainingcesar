package training.bms.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.PostSearchOptions;

//control + shift + o
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ShowPost {

	private int postId;
	private Post post;
	private @Autowired PostController controller;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getPostId() {
		return postId;

	}

	public void setPostId(int postId) {
		PostSearchOptions options = new PostSearchOptions();
		options.setPostId(postId);
		List<Post> posts = controller.searchPost(options);

		if (posts.size() > 0) {
			post = posts.get(0);

		}

		this.postId = postId;
	}

	public String getText() {

		String escapedText = StringEscapeUtils.escapeHtml(post.getText());

		StringBuilder text = new StringBuilder();

		text.append("<p>");
		escapedText= escapedText.replaceAll("[(\\n\\r)(\\n)(\\r)]+", "</p><p>");
		text.append(escapedText);
		text.append("</p>");

		return text.toString();
	}

}

package training.bms.presentation;

import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import training.bms.business.Post;
import training.bms.business.PostController;
import training.bms.business.PostSearchOptions;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ShowPost {
	private @Autowired PostController controller;
	private int postId;
	private Post post;
	
	public void setPostId(int postId) {
		this.postId = postId;
		
		PostSearchOptions options = new PostSearchOptions();
		options.setPostId(postId);
		List<Post> posts = controller.searchPost(options);
		if (posts.size() > 0) {
			post = posts.get(0);
		}
	}
	
	public int getPostId() {
		return postId;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	public Post getPost() {
		return post;
	}
	
	public String getPostBody() {
		String escapedBody = StringEscapeUtils.escapeHtml(post.getBody());

		StringBuilder body = new StringBuilder();
		body.append("<p>");
		escapedBody = escapedBody.replaceAll("[(\\n\\r)(\\n)(\\r)]+", "</p><p>");
		body.append(escapedBody);
		body.append("</p>");
		return body.toString();
		
/*		
		for (int i = 0; i < escapedBody.length(); ++i) {
			char c = escapedBody.charAt(i);
			if (c == '\n' || c == '\r') {
				body.append("</p><p>");
			} else {
				body.append(c);
			}
		}
*/		
	}
}











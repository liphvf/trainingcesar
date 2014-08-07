package training.bms.business;

public class PostSearchOptions {
	public enum Order {
		TITLE("title"),
		CREATION_DATE("creationDate");
		
		private String value;
		
		private Order(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}

	private Integer postId;
	private Integer blogId;
	private String title; 
	private String body;
	private Order order;
	private boolean desc;
	private Integer startPosition;
	private Integer maxResults;
	
	public PostSearchOptions() {
		order = Order.TITLE;
	}
	
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	public Integer getPostId() {
		return postId;
	}
	
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	
	public Integer getBlogId() {
		return blogId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setDesc(boolean desc) {
		this.desc = desc;
	}
	
	public boolean getDesc() {
		return desc;
	}
	
	public void setStartPosition(Integer startPosition) {
		this.startPosition = startPosition;
	}
	
	public Integer getStartPosition() {
		return startPosition;
	}
	
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}
	
	public Integer getMaxResults() {
		return maxResults;
	}
}
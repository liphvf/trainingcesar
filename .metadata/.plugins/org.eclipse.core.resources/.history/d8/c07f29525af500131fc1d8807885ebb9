package training.bms.business;

import java.util.Date;

public class PostSearchOptions {
	
	public PostSearchOptions () {
		// deixa esse como default,
		order = Order.TITLE;
	}

	public enum Order {
		TITLE("title"), DATE("date");

		private String value;

		private Order(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	private Integer id;
	private String title;
	private String text;
	private Date date;
	private String author;
	private Integer StartPosition;
	private Integer MaxResults;
	private boolean desc;
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	private Integer blogId;

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getStartPosition() {
		return StartPosition;
	}

	public void setStartPosition(Integer startPosition) {
		StartPosition = startPosition;
	}

	public Integer getMaxResults() {
		return MaxResults;
	}

	public void setMaxResults(Integer maxResults) {
		MaxResults = maxResults;
	}

}

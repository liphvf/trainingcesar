package training.bms.business;

public class BlogSearchOptions {
	private Integer id;
	private String name;
	private String description;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "BlogSearchOptions [name=" + name + ", description=" + description + "]";
	}
}
package training.bms.business;

public class BlogSearchOptions {

	private String name;
	private String description;
	private Integer Id;

	public BlogSearchOptions() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BlogSearchOptions [name=" + name + ", description="
				+ description + "]";
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}



	
	

}

package training.bms.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="BLO_BLOG")
public class Blog implements Cloneable {
	private Integer id;
	private String name;
	private String description;
	private List<Post> posts;
	
	public Blog() {
		posts = new ArrayList<>();
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BLO_ID")
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min=1, max=100)
	@Column(name="BLO_NAME")
	public String getName() {
		return name;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Size(min=1, max=1000)
	@Column(name="BLO_DS")
	public String getDescription() {
		return description;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@OneToMany(
		mappedBy="blog", 
		cascade=CascadeType.REMOVE
	)	
	public List<Post> getPosts() {
		return posts;
	}
		
	@Override
	public Blog clone() {
		try {
			return (Blog) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error(" A VM está louca!");
		}  
	}
}
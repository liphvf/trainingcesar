package training.bms.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="TAG_TAG")
public class Tag implements Cloneable {
	private Integer id;
	private String name;
	private List<Post> posts;
	
	public Tag() {
		posts = new ArrayList<>();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TAG_ID")
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min=1, max=100)
	@Column(name="TAG_NAME")
	public String getName() {
		return name;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@ManyToMany(mappedBy="tags")
	public List<Post> getPosts() {
		return posts;
	}
	
	@Override
	public Tag clone() {
		try {
			return (Tag) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error(" A VM está louca!");
		}  
	}	
}
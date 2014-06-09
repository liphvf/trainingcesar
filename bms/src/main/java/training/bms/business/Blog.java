package training.bms.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
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
@Table(name = "BLO_BLOG")
public class Blog {
	private Integer id;
	private String name;
	private String description;
	private List<Post> posts;

	
	private void Blog() {

		posts = new ArrayList<>();
		
	}
	//quando uma propriedade é marcada com mapped by, ele só funciona para leitura
	
	@Size(min = 1, max = 100)
	@Column(name = "BLOG_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// SE TIVER UM CAMPO NO BANCO COM DESCRIÇÃO FICA DS
	@Size(min = 1, max = 1000)
	@Column(name = "BLOG_DS")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BLOG_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	//aqui no atributo mappedby o nome da propriedade na entidade que esta no lado muitos que referencia a própria entidade
	//post está no lado muitos
	//no caso a propriedade de retorna uma própria blog é o atributo blog
	
	@OneToMany(mappedBy="blog", cascade=CascadeType.REMOVE)
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}

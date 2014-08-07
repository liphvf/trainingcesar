package training.bms.business;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

//agora eu defino que essa é uma entidade que deve ser persistida
@Entity
public class Blog {
	private Integer id;
	private String name;
	private String description;

	@Size(min=1, max=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Size(min=1, max=1000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// declarar o getId
	@Id
	// pede para que o banco de dados gere um id único.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy=GenerationType.SEQUENCE) ele utilizaria o
	// sequence ele utilizaria um contador só para mais de uma tabela, por
	// exemplo, primeiro blog id 1 depois em outra tabela id post 2.
	// você consegue ver os saltos no banco.
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@Override
//	public String toString() {
//		return "Blog [id=" + id + ", name=" + name + ", description="
//				+ description + "]";
//	}
	
	
	

}

package training.bms.business;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
// to colocando o nome da tabela.
@Table(name = "POST_POST")
public class Post {
	private Integer id;
	private String title;
	private String text;
	private Date date;
	private String author;
	private Blog blog;

	// represente um tipo de relacionamento de muitos para 1.
	@ManyToOne
	// usa para definir o nome de uma coluna, o comando é diferente pois são
	// relacionamento diferentes
	@JoinColumn(name = "BLOG_ID")
	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Size(min = 1, max = 100)
	@Column(name = "POS_TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Size(min = 1, max = 10000)
	@Column(name = "POS_TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "POS_CREATION_DATE")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Size(min = 1, max = 100)
	@Column(name = "POS_AUTHOR")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POS_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

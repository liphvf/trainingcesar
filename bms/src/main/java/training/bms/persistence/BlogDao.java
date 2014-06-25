package training.bms.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import training.bms.business.Blog;
import training.bms.business.BlogSearchOptions;

@Component
public class BlogDao {

	private @PersistenceContext
	EntityManager manager;

	// classe statles, sem atributos, por isso tread safe, ser capais de invocar
	// diversos metodos concorentimente sem problema.

	// livro fantasico sobre concorrencia em java = JAVA CONCURRENCY PRACTICE
	// (PAPERBACK) BY BRIAN GOETZ, TIM PEIERLS

	// private final EntityManagerFactory factory =
	// EntityManagerFactoryHolder.factory;
	// continuaria como tred safe pois, ela é final, só lê

	public boolean containsBlog(String blogName) {
		// // o factory poderia ser colocado no construtor, já que ele é uma
		// // variavel de EntityManagerFactoryHolder
		// EntityManagerFactory factory = EntityManagerFactoryHolder.factory;
		// EntityManager manager = factory.createEntityManager();
		//
		// TypedQuery<Blog> query = manager
		// .createQuery(
		// "select blog from training.bms.business.Blog blog where upper(blog.name) = :blogName ",
		// Blog.class);
		//
		// query.setParameter("blogName", blogName.toUpperCase());
		//
		// List<Blog> result = query.getResultList();
		//
		// return result.isEmpty() == false;

		return searchBlog(blogName) != null;
	}

	public void insertBlog(Blog blog) {

		// no caso estou referenciando a fabrica presente em
		// EntityManagerFactoryHolder

		// ele cria conecção com o bando de dados, salva o referencia da factory
		// para criar conecxão

		// crie uma transação

		// inicia transação

		// Blog blog = new Blog();
		// o id está sendo criado automagicamente pelo banco de dados
		manager.persist(blog);

		// termina transação comita =)

	}

	public List<Blog> searchBlog(BlogSearchOptions options) {
		StringBuilder predicate = new StringBuilder("1=1");

		// ficaria:
		// "1=1 and blog.name like :blogName"
		// com isso ele sempre vai colocar 1=1 no predicate, não tendo que se
		// preocupar com o and.
		// exemplo, se não colocar ele ficaria um and na frente sem ter nada
		// para o and, e daria problema.
		if (options.getId() != null) {
			predicate.append(" and blog.id = :blogId");

		}

		if (options.getName() != null && options.getName().length() > 0) {
			predicate.append(" and upper(blog.name) like :blogName");

		}

		if (options.getDescription() != null
				&& options.getDescription().length() > 0) {
			predicate
					.append(" and upper(blog.description) like :blogDescription");

		}

		TypedQuery<Blog> query = manager.createQuery(
				"select blog from Blog blog where " + predicate, Blog.class);

		if (options.getId() != null) {
			query.setParameter("blogId", +options.getId());

		}

		if (options.getName() != null && options.getName().length() > 0) {
			query.setParameter("blogName", "%"
					+ options.getName().toUpperCase() + "%");

		}

		if (options.getDescription() != null
				&& options.getDescription().length() > 0) {
			query.setParameter("blogDescription", "%"
					+ options.getDescription().toUpperCase() + "%");

		}

		List<Blog> result = query.getResultList();

		return result;
	}

	// mudei o nome de select blog para searchBlog
	public Blog searchBlog(String blogName) {

		TypedQuery<Blog> query = manager
				.createQuery(
						"select blog from training.bms.business.Blog blog where upper(blog.name) = :blogName ",
						Blog.class);

		query.setParameter("blogName", blogName.toUpperCase());

		List<Blog> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}

	}

	public void deleteBlog(Blog blog) {

		// carregando o blog do banco
		Blog managedBlog = manager.find(Blog.class, blog.getId());

		// removendo
		manager.remove(managedBlog);

		// para excluir a pessoa tem que usar o remove no mesmo manager que eu
		// carreguei o objeto no banco

	}

	// update
	public void updateBlog(Blog blog) {

		// merge está no JPA
		manager.merge(blog);

	}

}

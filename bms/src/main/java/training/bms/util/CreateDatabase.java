package training.bms.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import training.bms.business.Blog;
import training.bms.business.Post;

public class CreateDatabase {

	public static void main(String[] args) {

		// esse factory ele varre procurando @Entity, só precisa de um factory
		// pois vai ser re-utilizado, e computacionalmente caro
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("BMS");
		
		//ele cria conecção com o bando de dados, salva o referencia da factory para criar conecxão
		EntityManager manager = factory.createEntityManager();

		// crie uma transação
		EntityTransaction transaction = manager.getTransaction();

		// inicia transação
		transaction.begin();

		Blog blog = new Blog();
		// o id está sendo criado automagicamente pelo banco de dados
		blog.setName("Saulo");
		blog.setDescription("Araujo");
		manager.persist(blog);
		
		
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.DAY_OF_MONTH,1);
//		Date creationDate = calendar.getTime();

		
		Post post = new Post();
		post.setTitle("Saulo");
		post.setText("Araujo");
		post.setAuthor("Saulo Araujo");
		post.setDate(new Date());
		post.setBlog(blog);
		manager.persist(post);
		
		// termina transação comita =)
		transaction.commit();

//		TypedQuery<Blog> query = manager
//				.createQuery(
//						"select blog from training.bms.business.Blog blog where upper(blog.name) = :blogName",
//						Blog.class);
//
//		// ':blogName' nesse caso eu posso definit os parametros em vez de
//		// colocar simplesmente "SAULO"
//
//		query.setParameter("blogName", "SAULO");
//
//		List<Blog> result = query.getResultList();
//
//		System.out.println(result);
//		
		
		post = manager.find(Post.class, 1);
		System.out.println(post.getTitle());
		blog = post.getBlog();
		System.out.println(blog.getName());
		
		
	}

}

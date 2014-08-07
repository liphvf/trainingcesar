package training.bms.util;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import training.bms.business.Blog;
import training.bms.business.Post;
import training.bms.business.Tag;

public class CreateDatabase {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BMS");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Blog blog = new Blog();
		blog.setName("Blog 1");
		blog.setDescription("Blah blah blah");
		manager.persist(blog);
		
		Tag tag1 = new Tag();
		tag1.setName("Tag 1");		
		manager.persist(tag1);
		
		Tag tag2 = new Tag();
		tag2.setName("Tag 2");
		manager.persist(tag2);
		
		Post post = new Post();
		post.setTitle("Post 1");
		post.setBody("Blah blah blah");
		post.setCreationDate(new Date());
		post.setBlog(blog);
		post.getTags().add(tag1);
		post.getTags().add(tag2);		
		manager.persist(post);
						
		transaction.commit();
		
		manager.clear(); 
		
		post = manager.find(Post.class, 1);
		manager.close();
		System.out.println(post.getBlog());
		List<Tag> tags = post.getTags();
		System.out.println(post.getTags().size());
	}
}











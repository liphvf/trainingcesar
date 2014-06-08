package training.bms.business;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import training.bms.persistence.BlogDao;

public class BlogControllerTest {
	@Test
	public void happyTest() {
		Blog blog = new Blog();
		blog.setName("Saulo");
		blog.setDescription("Araujo");

		BlogDao dao = EasyMock.createMock(BlogDao.class);
		EasyMock.expect(dao.containsBlog("Saulo")).andReturn(false);
		dao.insertBlog(blog);
		EasyMock.replay(dao);

		BlogController controller = new BlogController();
		controller.setDao(dao);
		controller.saveBlog(blog);

		EasyMock.verify(dao);
	}

	@Test
	public void unhappyTest() {
		Blog blog = new Blog();
		blog.setName("Saulo");
		blog.setDescription("Araujo");

		BlogDao dao = EasyMock.createMock(BlogDao.class);
		EasyMock.expect(dao.containsBlog("Saulo")).andReturn(true);
		EasyMock.replay(dao);

		BlogController controller = new BlogController();
		controller.setDao(dao);
		try {
			controller.saveBlog(blog);
			Assert.fail("Exceção não levantada");
		} catch (BusinessException e) {
		}

		EasyMock.verify(dao);
	}

	@Test
	public void testUpdateBlog() {
		Blog blog = new Blog();
		blog.setName("Saulo");
		blog.setDescription("Araujo");
		blog.setId(1);

		BlogDao dao = EasyMock.createMock(BlogDao.class);
		EasyMock.expect(dao.searchBlog("Saulo")).andReturn(null);
		dao.updateBlog(blog);
		EasyMock.replay(dao);

		BlogController controller = new BlogController();
		controller.setDao(dao);
		controller.updateBlog(blog);

		EasyMock.verify(dao);
	}

	@Test
	public void testUpdateBlog2() {
		Blog blog = new Blog();
		blog.setName("Saulo");
		blog.setDescription("Araujo");
		blog.setId(1);

		Blog databaseBlog = new Blog();
		databaseBlog.setId(1);
		databaseBlog.setName("Saulo");
		databaseBlog.setDescription("um valor qual quer");

		BlogDao dao = EasyMock.createMock(BlogDao.class);
		EasyMock.expect(dao.searchBlog("Saulo")).andReturn(databaseBlog);
		dao.updateBlog(blog);
		EasyMock.replay(dao);

		BlogController controller = new BlogController();
		controller.setDao(dao);
		controller.updateBlog(blog);

		EasyMock.verify(dao);
	}

	// unhappy
	@Test
	public void testUpdateBlog3() {
		Blog blog = new Blog();
		blog.setName("Saulo");
		blog.setDescription("Araujo");
		blog.setId(1);

		Blog databaseBlog = new Blog();
		databaseBlog.setId(2);
		databaseBlog.setName("Saulo");
		databaseBlog.setDescription("um valor qual quer");

		BlogDao dao = EasyMock.createMock(BlogDao.class);
		EasyMock.expect(dao.searchBlog("Saulo")).andReturn(databaseBlog);
		// não ira acontecer
		// dao.updateBlog(blog);
		EasyMock.replay(dao);

		BlogController controller = new BlogController();
		controller.setDao(dao);

		try {
			controller.updateBlog(blog);
			Assert.fail("Exceção não levantada");
		} catch (BusinessException e) {
		}
		// não ira acontecer
		// controller.updateBlog(blog);

		EasyMock.verify(dao);
	}
	
//não fiz o test para search options

}

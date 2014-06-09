package training.osms.business;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import training.osms.business.Category;
import training.osms.business.CategoryController;
import training.osms.persistence.CategoryDao;

public class CategoryControllerTest {
	
	@Test
	public void testSaveCategory () {
		
		Category category = new Category();
		
		category.setName("Saulo");
		category.setDescription("Araujo");
		
		CategoryDao dao = EasyMock.createMock(CategoryDao.class);
		EasyMock.expect(dao.containsCategory("Saulo")).andReturn(false);
		
		dao.insertCategory(category);
		EasyMock.replay(dao);
		
		
		//caminho triste
		
		CategoryController controller = new CategoryController();
		
		controller.setDao(dao);
		controller.saveCategory(category);
		
		EasyMock.verify(dao);
	}
	
	@Test
	public void unhappyTest() {
		
		Category category = new Category();
		
		category.setName("Saulo");
		category.setDescription("Araujo");
		
		CategoryDao dao = EasyMock.createMock(CategoryDao.class);
		EasyMock.expect(dao.containsCategory("Saulo")).andReturn(false);
		
		dao.insertCategory(category);
		EasyMock.replay(dao);
		
		
		//caminho triste
		
		CategoryController controller = new CategoryController();
		
		controller.setDao(dao);
		
		
		try {
			controller.saveCategory(category);
			Assert.fail("Exeção não levantada");
		} catch (RuntimeException e) {

		}
		
		
		EasyMock.verify(dao);
		
	}
	

}

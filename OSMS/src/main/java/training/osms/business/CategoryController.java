package training.osms.business;

import training.osms.persistence.CategoryDao;

public class CategoryController {

	private CategoryDao dao;

	public CategoryDao getDao() {
		return dao;
	}

	public void setDao(CategoryDao dao) {
		this.dao = dao;
	}

	public void saveCategory(Category category) {

		if (dao.containsCategory(category.getName())) {
			throw new RuntimeException("the is a blog named"
					+ category.getName() + " Already");

		} else {
			dao.insertCategory(category);

		}

	}
}

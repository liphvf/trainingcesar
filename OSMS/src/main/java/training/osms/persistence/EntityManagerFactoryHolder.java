package training.osms.persistence;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryHolder {

	public static final EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("BMS");

}

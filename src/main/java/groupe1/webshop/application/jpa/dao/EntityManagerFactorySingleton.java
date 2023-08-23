package groupe1.webshop.application.jpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {

	/**
	 * 
	 */
	public final static EntityManagerFactorySingleton INSTANCE = new EntityManagerFactorySingleton();

	/**
	 * 
	 */
	private static final String PERSISTENCE_UNIT_NAME = "persistenceUnit";
	/**
	 * 
	 */
	private EntityManagerFactory entityManagerFactory;

	/**
	 * 
	 */
	private EntityManagerFactorySingleton() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	/**
	 * @return
	 */
	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

}

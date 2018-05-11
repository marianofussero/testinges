package cc.churrasco.spark.test.managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager
{
	private static PersistenceManager instance = null;
	
	private EntityManagerFactory emFactory;
	
	public static PersistenceManager instance()
	{
		if ( instance == null ) instance = new PersistenceManager();
		return instance;
	}
	
	private PersistenceManager()
	{
		emFactory = Persistence.createEntityManagerFactory("SparkTest");
	}
	
	public EntityManager getEntityManager()
	{
		return emFactory.createEntityManager();
	}
	
	public void close()
	{
		emFactory.close();
	}
}

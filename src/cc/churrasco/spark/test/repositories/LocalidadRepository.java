package cc.churrasco.spark.test.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cc.churrasco.spark.test.entities.LocalidadEntity;
import cc.churrasco.spark.test.managers.PersistenceManager;

@SuppressWarnings("unchecked")
public enum LocalidadRepository
{
	INSTANCE;
	
	public LocalidadEntity listarLocalidad()
	{
		EntityManager em = PersistenceManager.instance().getEntityManager();
		LocalidadEntity localidad = em.find(LocalidadEntity.class, 6415L);
		
		em.close();
		return localidad;
	}
	
	public List<LocalidadEntity> listarPorProvincia()
	{
		EntityManager em = PersistenceManager.instance().getEntityManager();
		Query query = em.createNativeQuery("SELECT * FROM localidad WHERE provincia = 7 ", LocalidadEntity.class);
		List<LocalidadEntity> retorno = query.getResultList();
		return retorno;
	}
	
	public void saveOrUpdate(LocalidadEntity localidad)
	{
		try
		{
			EntityManager em = PersistenceManager.instance().getEntityManager();
			em.getTransaction().begin();
			localidad = em.merge(localidad);
			em.persist(localidad);
			em.getTransaction().commit();
			
			em.close();
			// PersistenceManager.instance().close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

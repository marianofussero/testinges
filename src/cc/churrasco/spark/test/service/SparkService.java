package cc.churrasco.spark.test.service;

import java.util.ArrayList;
import java.util.List;

import cc.churrasco.spark.test.LocalidadDTO;
import cc.churrasco.spark.test.entities.LocalidadEntity;
import cc.churrasco.spark.test.managers.PersistenceManager;
import cc.churrasco.spark.test.repositories.LocalidadRepository;
import spark.Request;
import spark.Response;

public class SparkService
{
	public List<LocalidadDTO> listarLocalidades( Request req, Response res )
	{
		try
		{
			 List<LocalidadEntity> localidad = LocalidadRepository.INSTANCE.listarPorProvincia();
			 List<LocalidadDTO> retorno = new ArrayList<>();
			 
			 for(LocalidadEntity en : localidad)
			 {
				 retorno.add(new LocalidadDTO(en));
			 }
			 return retorno;
			 
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public void shutdown()
	{
		PersistenceManager.instance().close();
	}
}

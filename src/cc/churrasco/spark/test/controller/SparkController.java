package cc.churrasco.spark.test.controller;

import static spark.Spark.get;
import static spark.Spark.port;

import cc.churrasco.spark.test.service.SparkService;

public class SparkController
{
	private static final String JSON = "application/json";
	
	private SparkService service;
	private JsonTransformer transformer;
	
	public void init()
	{
		port(8421);
		transformer = new JsonTransformer();
		service = new SparkService();
		configureLocalidades();
	}
	
	private void configureLocalidades()
	{
		get("/localidades", "application/json", (req, res) -> {
			res.type(JSON);
			return service.listarLocalidades(req, res);
		}, transformer );
		
	}
	
	public void shutDown()
	{
		service.shutdown();
	}
	
}

package cc.churrasco.spark.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer
{
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String render(Object model)
	{
		try
		{
			return mapper.writeValueAsString(model);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
			return "{}";
		}
	}
}

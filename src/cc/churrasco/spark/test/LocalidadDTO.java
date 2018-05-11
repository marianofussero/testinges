package cc.churrasco.spark.test;

import cc.churrasco.spark.test.entities.LocalidadEntity;

public class LocalidadDTO
{
	public long id;
	public String nombre;
	public long provincia;
	
	public LocalidadDTO() {}
	public LocalidadDTO(long i, String n, long p)
	{
		this.id = i;
		this.nombre = n;
		this.provincia = p;
	}
	
	public LocalidadDTO( LocalidadEntity loc )
	{
		this.id = loc.getId();
		this.nombre = loc.getLocalidad();
		this.provincia = loc.getProvincia();
	}
}

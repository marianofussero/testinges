package cc.churrasco.spark.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Localidad")
@Table( name = "Localidad")
public class LocalidadEntity
{
	@Column(name="id", columnDefinition="INT(10)")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="provincia", columnDefinition="INT(10)")
	private Long provincia;

	
	public LocalidadEntity() {}
	
	public LocalidadEntity(Long id, String localidad, Long provincia)
	{
		this.id = id;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLocalidad()
	{
		return localidad;
	}

	public void setLocalidad(String localidad)
	{
		this.localidad = localidad;
	}

	public Long getProvincia()
	{
		return provincia;
	}

	public void setProvincia(Long provincia)
	{
		this.provincia = provincia;
	}
	
}

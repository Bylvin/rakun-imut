package mega.itdp.bookauthor.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Person implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -1637306232385302235L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Long version;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
package mega.itdp.bookauthor.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Book implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 349985280040442426L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Long version;
	
	private String title;
	private int price;
	
	@ManyToOne
	private Person author;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}
}

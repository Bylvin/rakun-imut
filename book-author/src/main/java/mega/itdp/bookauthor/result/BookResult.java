package mega.itdp.bookauthor.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResult
{
	private Long id;
	private Long version;
	private String title;
	private int price;
	
	@JsonProperty(value="author_id")
	private Long authorId;
	
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
	public Long getAuthor() {
		return authorId;
	}
	public void setAuthor(Long authorId) {
		this.authorId = authorId;
	}
}

package mega.itdp.bookauthor.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import mega.itdp.bookauthor.entity.Book;

public class BookResult
{
	private Long id;
	private Long version;
	private String title;
	private int price;
	
	@JsonProperty(value="author_id")
	private Long authorId;
	
	private Date createdAt;
	private Date modifiedAt;
	
	public BookResult()
	{
		
	}
	
	public BookResult(Book book)
	{
		this.id = book.getId();
		this.version = book.getVersion();
		this.title = book.getTitle();
		this.price = book.getPrice();
		this.authorId = book.getAuthor().getId();
		this.createdAt = book.getCreatedAt();
		this.modifiedAt = book.getModifiedAt();
	}
	
	public Book backToEntity(BookResult result)
	{
		Book book = new Book();
		book.setId(result.getId());
		book.setVersion(result.getVersion());
		book.setTitle(result.getTitle());
		book.setPrice(result.getPrice());
		
		return book;
	}
	
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
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}

package models;

public class Book extends Material {

	private String author;
	private String isbn;
	private int noOfPages;
	
	public Book(String id, String title, String author, String isbn,String branch,int noOfPages)
	{
		super(id,title,branch);
		
		this.author = author;
		this.isbn = isbn;
		this.noOfPages=noOfPages;
		
	}
	
	
	public String getAuthor()
	{
		return author;
	}
	public String getIsbn()
	{
		return isbn;
	}
	
	public void sendForRepair()
	{
		System.out.println("Book has sent for repair");
	}


	@Override
	public int getLoanPeriod() {
		return 21;
	}
	
	@Override
	public String toString() {
		return "BOOK: "+getID()+" "+getTitle() +" / "+ getAuthor();
	}


	public int getNumberOfPages() {
		// TODO Auto-generated method stub
		return noOfPages;
	}
}

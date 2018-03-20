package models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Book;

class BookTest {

	@Test
	void test1() {
		Book book1 = new Book("1","Inro to Java","shri","12344","Anytime",400);
		Book book2 = new Book("1","Inro to Java","shri","12344","Anytime",400);
assertTrue(book1.equals(book2));

	}
	
	@Test
	public void test2() {
Book book1= new Book("1","Inro to Java","shri","12344","Anytime",400);
Book book2 = new Book("2","Inro to Java","shri","12344","Anytime",400);

assertFalse(book1.equals(book2));
	}

}

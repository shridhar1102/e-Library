package models.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import models.Book;
import models.Customer;
import models.Loan;
import utility.GenderType;

class LoanTest {

	@Test
	void testGetDueDate() {
		Book book = new Book("1","Inro to Java","shri","12344","Anytime",400);
		Customer customer =new Customer("Mr","Shridhar","Kevati","Banaglore","12234","Shridhar@shri",1234,GenderType.MALE);
 Loan loan= new Loan(1,customer,book);
 GregorianCalendar gc= new GregorianCalendar();
 gc.add(GregorianCalendar.DAY_OF_WEEK, 14);

 GregorianCalendar gcActual= new GregorianCalendar();
 
 gcActual.setTime(loan.getDueDate());
 
 assertEquals(gc.get(GregorianCalendar.YEAR), gcActual.get(GregorianCalendar.YEAR));
 assertEquals(gc.get(GregorianCalendar.MONTH), gcActual.get(GregorianCalendar.MONTH));
 assertEquals(gc.get(GregorianCalendar.DAY_OF_MONTH), gcActual.get(GregorianCalendar.DAY_OF_MONTH));

	}

}

package ui;
import models.Book;

import models.DVD;
import models.MaterialCatalogInterface;
import models.MaterialCatalogMemoryVersion;

public class Main {

	public static void main(String[] args) {
		
		
	
		MaterialCatalogInterface materialCatalog= new MaterialCatalogMemoryVersion();
		Book book1 = new Book("1","Inro to Java","shri","12344","Anytime",400);
		Book book2 = new Book("2234","Inro to C++","shri","234252", "Anytime", 150);
		Book book3 = new Book("356","Inro to python","shri","78690", "Anytime", 66);
		Book book4 = new Book("4567","Inro to CS","shri","4556", "Anytime", 77);
		Book book5 = new Book("53242","Inro to IS+","shri","87567", "Anytime", 88);
		DVD dvd1=new DVD ("56645", "raja", "String branch", "String director", 100 , 1233);
		DVD dvd= new DVD("3", "epic film","anytime","stephen",999887,120);
		//System.out.println(dvd.getTitle());
		
		book1.relocate("Mycity Branch");
		materialCatalog.addMaterial(book1);
		materialCatalog.addMaterial(book2);
		materialCatalog.addMaterial(book3);
		materialCatalog.addMaterial(book4);
		materialCatalog.addMaterial(book5);
		materialCatalog.addMaterial(dvd1);
		materialCatalog.addMaterial(dvd);
		UI ui= new UI();
		ui.displayHeader();
		
		ui.printMaterialCatalog(materialCatalog.getMaterialMap());
//		
//		try {
//		Book foundBook=bookCatalog.findBook("Inro toC++");
//		System.out.println("we found  " + foundBook.getTitle());
//
//		}
//		catch (BookNotFoundException e)
//		{
//			System.out.println("Not Found");
//		}
//		 
//		
//	Customer customer =new Customer("Mr","Shridhar","Kevati","Banaglore","12234","Shridhar@shri",1234,GenderType.MALE);
//	
//	System.out.println(customer.getExpiryDate());
//	
//	Loan firstLoan= new Loan(1,customer,book1);
//	System.out.println(firstLoan.getDueDate());
//	System.out.println(firstLoan);
//
//	LoanRegistry registry= new LoanRegistry();
//			
//		try {
//			registry.addLoan(firstLoan);
//			System.out.println("addLoan worked");
//		}
//	catch(LoanAlreadyExistException e)
//	{
//		System.out.println("addLoan failed");
//	}
//		
//		try {
//			registry.addLoan(firstLoan);
//			System.out.println("addLoan worked");
//		}
//	catch(LoanAlreadyExistException e)
//	{
//		System.out.println("addLoan failed");
//	}
//		
//		System.out.println(registry.isBookOnLoan(book1.getID()));
//		firstLoan.enLoan();
//		System.out.println(registry.isBookOnLoan(book1.getID()));

			}
	}



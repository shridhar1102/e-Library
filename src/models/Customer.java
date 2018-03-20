package models;
import java.util.Date;
import java.util.GregorianCalendar;

import utility.GenderType;

public class Customer {
	
	private String title;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private int customerNumber;
	private GenderType gender;
	private boolean isvaild;
	private Date expiryDate;
	
	
	public Customer(String title, String firstName, String lastName,String address, String phoneNumber, String email, int customerNumber, GenderType gender)
	{
		setName(title,firstName,lastName);
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.customerNumber=customerNumber;
		this.gender=gender;
		this.isvaild=true;
		GregorianCalendar gCal= new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR, 1);
		this.expiryDate= gCal.getTime();
		
		
	}
	
	public  String getFirstName()
	{
		return firstName;
	}
	public  String getLastName()
	{
		return lastName;
	}
		
	private void setName(String title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;

		}
	
	
	public String getMailingName() {
	StringBuilder sb= new StringBuilder(title);
	sb.append("");
	sb.append(firstName.subSequence(0, 1));
	sb.append("");
	sb.append(lastName);
	return sb.toString();
	
	}
	public GenderType getGender()
	{
		return gender;
	}
	public Date getExpiryDate()
	{
		return expiryDate;
	}

	
}

package models;

public class DVD extends Material {
	
	private String director;
	private int catalogNo;
	private int runningTime;
	private boolean licenced;
	
	
	public DVD(String id, String title, String branch, String director, int catalogNo, int runningTime) {
		super(id, title, branch);
		this.director = director;
		this.catalogNo = runningTime;
		this.runningTime = runningTime;
		licenced=false;
	}
	
	public void licence()
	{
		licenced=true;
	}
 public boolean lend(Customer customer)
 {
	 if(licenced) {
		 return super.lend(customer);
	 }
	 else {
		 return false;
	 }
 }
 public String getDirector()
 {
	 return director;
 }

@Override
public int getLoanPeriod() {
	return 7;
}

@Override
public String toString()
{
	return "DVD :" +getID()+ " "+ getTitle()+" / "+getDirector()
;}

public int getCatalogNumber() {
	// TODO Auto-generated method stub
	return catalogNo;
}

public int getRunningTime() {
	// TODO Auto-generated method stub
	return runningTime;
}

public boolean getLicenced() {
	// TODO Auto-generated method stub
	return licenced;
}
}

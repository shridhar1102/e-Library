package models;

public abstract class Material {
	
	private String id;
	private String title;
	private String branch;
	private Customer borrower;
	public Material(String id, String title, String branch) {
		this.id = id;
		this.title = title;
		this.branch = branch;
	}

	public String getTitle() {
		return title;
	}
	public String getID()
	{
		return id;
	}
public void relocate(String newBranch)
{
	this.branch=newBranch;
}

public boolean lend(Customer customer)
{
	if(borrower==null) {
		borrower = customer;
		return true;
	}
	else {
		return true;
	}
}
public abstract int getLoanPeriod();



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Material other = (Material) obj;
	if (id != other.id)
		return false;
	return true;
}

public String toString()
{
	return id+" "+title;
}

}


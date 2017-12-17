import java.util.*;

public class admin extends user {
	static int counter=100;
	static Vector< prod_Entity>request_Prod= new Vector<prod_Entity>();
	
	private int adminID;
	admin()
	{
		adminID=-1;
	}
	admin(String n,String pass,String ad,String ph,String em,int agee)
	{
		counter++;
		setName(n);
		setPassword(pass);
		setAddress(ad);
		setPhone_num(ph);
		setEmail(em);
		setAge(agee);
		adminID=counter;
			
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		admin.counter = counter;
	}
	public static Vector<prod_Entity> getRequest_Prod() {
		return request_Prod;
	}
	public static void setRequest_Prod(Vector<prod_Entity> request_Prod) {
		admin.request_Prod = request_Prod;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	admin(String n,String pass)
	{
		setName(n);
		setPassword(pass);
		for(int i=0 ; i<DB.admins.size() ;i++)
		{
			if(DB.admins.get(i).getName().equals(n) && DB.admins.get(i).getPassword().equals(pass)) {
				adminID=DB.admins.get(i).adminID;
				break;
			}
			else
				adminID=-1;
		}
	}
	
	public boolean Insert()
	{
		for(int i=0 ; i<DB.admins.size() ; i++)
		{
			if(DB.admins.get(i).getName().equals(this.getName()))
				return false;
		}
		DB.admins.add(this);
		return true;
	}
	
	public boolean Delete(int id)
	{
		for(int i=0 ;i<DB.admins.size() ;i++)
		{
			if(DB.admins.get(i).adminID==id)
			{
				DB.admins.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean Update()
	{
		for(int i=0 ; i<DB.admins.size() ;i++)
		{
			if(DB.admins.get(i).adminID==this.adminID)
			{
				DB.admins.get(i).setName(this.getName());
				DB.admins.get(i).setAddress(this.getAddress());
				DB.admins.get(i).setPhone_num(this.getPhone_num());
				DB.admins.get(i).setEmail(this.getEmail());
				DB.admins.get(i).setAge(this.getAge());
				return true;
			}
		}
		return false;
	}
	public admin Select(int id)
	{
		for(int i=0 ; i<DB.admins.size() ;i++)
		{
			if(DB.admins.get(i).adminID==id)
			{
				return DB.admins.get(i);
			}
		}
	admin zft = new admin();
	 return zft;
	}
}

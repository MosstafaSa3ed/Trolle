import java.util.Vector;

public class seller extends user {
	
	private static int counter=200;
	private int sellerID;
	private boolean type;
	private Vector<store_Entity> stores=new Vector<store_Entity>();
	
	seller()
	{
		sellerID=-1;
	}
	seller(String n,String pass,String ad,String ph,String em,int agee,store_Entity s,boolean type)
	{
		this.type=type;
		password=pass;
		counter++;
		name=n;
		address=ad;
		phone_num=ph;
		email=em;
		age=agee;
		sellerID=counter;
		stores.add(s);
		s.Insert();
			
	}
	seller(String n,String pass,boolean type)
	{
		name=n;
		password=pass;
		
		if(!type) {
			
			sellerID=-1;
			for(int i=0 ; i<DB.sellers.size() ;i++)
			{
				if(DB.sellers.get(i).name.equals(n) && DB.sellers.get(i).password.equals(pass)) {
					sellerID=DB.sellers.get(i).sellerID;
					break;
				}
				else
					sellerID=-1;
			}
		}
		else
		{
			sellerID=-1;
			for(int i=0 ; i<DB.premiums.size() ;i++)
			{
				if(DB.premiums.get(i).name.equals(n) && DB.premiums.get(i).password.equals(pass)) {
					sellerID=DB.premiums.get(i).sellerID;
					break;
				}
				else
					sellerID=-1;
			}
		}
	}
	
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		seller.counter = counter;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public Vector<store_Entity> getStores() {
		return stores;
	}
	public void setStores(Vector<store_Entity> stores) {
		this.stores = stores;
	}
	public boolean Insert()
	{
		if(!type) {
			for(int i=0 ; i<DB.sellers.size() ; i++)
			{
				if(DB.sellers.get(i).name.equals(this.name))
					return false;
			}
			DB.sellers.add(this);
			return true;
		}
		else
		{
			for(int i=0 ; i<DB.premiums.size() ; i++)
			{
				if(DB.premiums.get(i).name.equals(this.name))
					return false;
			}
			DB.premiums.add(this);
			return true;
		}
			
	}
	public boolean Delete(int id)
	{
		for(int i=0 ;i<DB.sellers.size() ;i++)
		{
			if(DB.sellers.get(i).sellerID==id)
			{
				DB.sellers.remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean Update(seller a)
	{
		for(int i=0 ; i<DB.sellers.size() ;i++)
		{
			if(DB.sellers.get(i).sellerID==a.sellerID)
			{
				DB.sellers.get(i).name=a.name;
				DB.sellers.get(i).address=a.address;
				DB.sellers.get(i).phone_num=a.phone_num;
				DB.sellers.get(i).email=a.email;
				DB.sellers.get(i).age=a.age;
				return true;
			}
		}
		return false;
	}
	public seller Select(int id,boolean type)
	{
		if(!type) {
				for(int i=0 ; i<DB.sellers.size() ;i++)
				{
					if(DB.sellers.get(i).sellerID==id)
					{
						return DB.sellers.get(i);
					}
				}
			seller zft = new seller();
			 return zft;
		}
		else 
		{
			for(int i=0 ; i<DB.premiums.size() ;i++)
			{
				if(DB.premiums.get(i).sellerID==id)
				{
					return DB.premiums.get(i);
				}
			}
		seller zft = new seller();
		 return zft;
		}
	}
	public void add_store(store_Entity s)
	{
		stores.add(s);
		System.out.println("done adding store.");
	}
	
}



public class seller extends user {
	store store;
	static int counter=200;
	int sellerID;
	
	seller()
	{
		sellerID=-1;
	}
	seller(String n,String ad,String ph,String em,int agee)
	{
		counter++;
		name=n;
		address=ad;
		phone_num=ph;
		email=em;
		age=agee;
		sellerID=counter;
			
	}
	
	public boolean Insert()
	{
		DB.sellers.add(this);
		return true;
	}
	public boolean Delete(int id)
	{
		for(int i=0 ;i<DB.sellers ;i++)
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
		for(int i=0 ; i<DB.sellers ;i++)
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
	public seller Select(int id)
	{
		for(int i=0 ; i<DB.sellers ;i++)
		{
			if(DB.sellers.get(i).sellerID==id)
			{
				return DB.sellers.get(i);
			}
		}
	seller zft = new seller();
	 return zft;
	}
	
	public boolean Do_offers()
	{
		
	}
}

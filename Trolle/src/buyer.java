

public class buyer extends user {
	int vouch;
 	int buyerID;
 	
	static int counter=300;
	
	
	buyer()
	{
		buyerID=-1;
	}
	buyer(String n,String pass,String ad,String ph,String em,int agee)
	{
		counter++;
		setName(n);
		setAddress(ad);
		setPhone_num(ph);
		setEmail(em);
		setAge(agee);
		setPassword(pass);
		buyerID=counter;	
	}
	
	buyer(String n,String pass)
	{
		setName(n);
		setPassword(pass);
		for(int i=0 ; i<DB.buyers.size() ;i++)
		{
			if(DB.buyers.get(i).getName().equals(n) && DB.buyers.get(i).getPassword().equals(pass)) {
				buyerID=DB.buyers.get(i).buyerID;
				break;
			}
			else
				buyerID=-1;
		}
		
	}
	
	public int getVouch() {
		return vouch;
	}
	public void setVouch(int vouch) {
		this.vouch = vouch;
	}
	public int getBuyerID() {
		return buyerID;
	}
	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		buyer.counter = counter;
	}
	public boolean Insert()
	{
		for(int i=0 ; i<DB.buyers.size() ; i++)
		{
			if(DB.buyers.get(i).getName().equals(this.getName()))
				return false;
		}
		DB.buyers.add(this);
		return true;
	}
	public boolean Delete(int id)
	{
		for(int i=0 ;i<DB.buyers.size() ;i++)
		{
			if(DB.buyers.get(i).buyerID==id)
			{
				DB.buyers.remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean Update(buyer a)
	{
		for(int i=0 ; i<DB.buyers.size() ;i++)
		{
			if(DB.buyers.get(i).buyerID==a.buyerID)
			{
				DB.buyers.get(i).setName(a.getName());
				DB.buyers.get(i).setAddress(a.getAddress());
				DB.buyers.get(i).setPhone_num(a.getPhone_num());
				DB.buyers.get(i).setEmail(a.getEmail());
				DB.buyers.get(i).setAge(a.getAge());
				return true;
			}
		}
		return false;
	}
	public buyer Select(int id)
	{
		for(int i=0 ; i<DB.buyers.size() ;i++)
		{
			if(DB.buyers.get(i).buyerID==id)
			{
				return DB.buyers.get(i);
			}
		}
		buyer zft = new buyer();
		return zft;
	}
 	
	public boolean order(prod_Entity p)
	{
		return false;
		
	}
}

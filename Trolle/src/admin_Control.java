import java.util.Random;

public class admin_Control {
	
	public void provide_Vouch()
	{
		if(DB.buyers.size()==0)
		{
			System.out.println("there is no users in the system.. ");
			return;
		}
		int incrment=50;
		Random ran=new Random();
		if(DB.buyers.size()>1) {
			int ind=ran.nextInt(DB.buyers.size()-1);
			DB.buyers.get(ind).vouch+=incrment;
		}
		else if(DB.buyers.size()==1)
			DB.buyers.get(0).vouch+=incrment;
	}
	
	public void add_new_prod(prod_Entity prod)
	{
		DB.system_products.add(prod);
	}
}

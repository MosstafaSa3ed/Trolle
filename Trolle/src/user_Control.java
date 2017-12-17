import java.util.Scanner;

public class user_Control {
	
	buyer login(buyer tem)
	{
		return tem.Select(tem.buyerID);
	}
	seller login(seller tem,boolean type)
	{
		return tem.Select(tem.getSellerID(),type);
	}
	admin login(admin tem)
	{
		return tem.Select(tem.getAdminID());
	}
	////////////////sign up
	boolean signUp(buyer tem)
	{
		return tem.Insert();
	}
	boolean signUp(seller tem)
	{
		return tem.Insert();
	}
	
	/////////////////////////////////////////////
	
	public int first_show(int choice)
	{
		Scanner scan= new Scanner(System.in);
		
		if(choice==1)
		{
			
			System.out.println("this is the categories we have choose one to show products in it");
			
			for(int i=0;i<DB.categories.size();i++)
			{
				System.out.println(i+1 + "- "+DB.categories.get(i).getName());
			}
			choice=scan.nextInt();
			if(choice>DB.categories.size())
				return -1;
			if(DB.categories.get(choice-1).getProducts().size()==0) {
				System.out.println("There are no products here.");
				return -1;
			}
			cate_Control.view_prod(DB.categories.get(choice-1)); 
			System.out.print("Please choose the products id you wanna view :- ");
			int id=scan.nextInt();
			
			prod_Control c = new prod_Control();
			if(!c.view(id))
				return -1;
			else 
				return id;
		}
		else
		{
			System.out.println("this is the stores we have choose one to show produts in it");
			
			for(int i=0;i<DB.stores.size();i++)
			{
				System.out.println(i+1 + "- "+DB.stores.get(i).getName());
			}
			choice=scan.nextInt();
			if(choice> DB.stores.size())
				return -1;
			
			if(DB.stores.get(choice-1).getProducts().size()==0) {
				System.out.println("There are no products here.");
				return -1;
			}			
			store_Control.view_prod(DB.stores.get(choice-1));
			
			System.out.print("Please choose the products id you wanna view :- ");
			int id=scan.nextInt();
			
			prod_Control c = new prod_Control();
			if(!c.view(id))
				return -1;
			else 
				return id;
		}
		
	}
}

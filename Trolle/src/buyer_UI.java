import java.util.Scanner;

public class buyer_UI {
	
	public void show(buyer b)
	{
		System.out.println("************welcome "+b.getName()+" ************");
		
		while(true) {	
			System.out.println("DO you want to choose from \n1- categories.\n2- stores\n3-suggest prod \n4- logout");
			Scanner scan= new Scanner(System.in);
			int choice=scan.nextInt();
			
			if(choice !=1 && choice!=2 && choice !=3)
				return;
			else if(choice==3)
			{
				cate_Control c=new cate_Control();
				c.Suggest_product();
			}
			else
			{
				user_Control uc=new user_Control();
				
				int id=uc.first_show(choice);
				if(id==-1)
					continue;
				System.out.println("Do you wanna buy it :- \n1-Yes\n2-NO");
				
				choice=scan.nextInt();
				if(choice==1)
				{
					prod_Control c=new prod_Control();
					prod_Entity p=new prod_Entity();
					c.buy(p.Select(id), b);
				}
			}
		}
	}
}

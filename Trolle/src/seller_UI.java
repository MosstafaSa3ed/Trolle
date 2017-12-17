import java.util.Scanner;

public class seller_UI {
	
	public void show(seller sell)
	{
		System.out.println("************welcome "+sell.getName()+" ************");
		Scanner scan=new Scanner(System.in);
		while(true) {
			
			System.out.println("\nDO you want to choose from \n1- categories.\n2- stores\n3- Add store\n4- Add product to your store\n5-suggest product");
			System.out.println("6- Get most viewed Product in store \"if premium\"\n7-explore number of views to each product in store \"if premium\" \n or log out");
			int choice =scan.nextInt();
			if(choice ==1 || choice==2)
			{
				user_Control u=new user_Control();
				u.first_show(choice);
			}
			else if(choice ==3)
			{
				String name,type,address;
				scan.nextLine();
				System.out.print("store Name: ");
				name=scan.nextLine();
				System.out.print("type: ");
				type=scan.nextLine();
				System.out.print("store address: ");
				address=scan.nextLine();
				store_Entity s= new store_Entity(name,address,type);
				s.setSeller(sell);
				sell.getStores().add(s);
				s.Insert();
			}
			else if(choice==4)
			{
				System.out.println("choose store to add product in it.\n");
				for(int i=0;i<sell.getStores().size();i++)
					System.out.println(sell.getStores().get(i).getID() +" "+ sell.getStores().get(i).getName());
				choice=scan.nextInt();
				
				store_Entity s=new store_Entity();
				s=s.Select(choice);
				if(s.getID()==-1)
					continue;
				else 
				{
						System.out.println("please choose one of the existing products :-");
						for(int i=0;i<DB.system_products.size();i++)
							System.out.println(i+1 + " "+ DB.system_products.get(i).getName());
						
						int tem=scan.nextInt();
						if(tem <=DB.system_products.size())
						{
							String color,weight,des;
							String name=DB.system_products.get(tem-1).getName();
							cate_Entity c=DB.system_products.get(tem-1).getCategory();
							
							double price;
							scan.nextLine();
							System.out.print("Enter the following :-\nColor: ");
							color=scan.nextLine();
							System.out.print("weight: ");
							weight=scan.nextLine();
							System.out.print("description: ");
							des=scan.nextLine();
							System.out.print("price: ");
							price=scan.nextDouble();
							prod_Entity p=new prod_Entity(name,color,weight,des,c,price,s);
							p.Insert();
						}
						else
							System.out.print("that is not vaild please suggest this product and try again later\n");
				
				}
			}
			else if(choice==5)
			{
				cate_Control c=new cate_Control();
				c.Suggest_product();
			}
			else if(choice==6)
			{
				if(!sell.isType())
				{
					System.out.print("yalla ya taaaafh ro7 e3ml account premium el awl. \n");
				}
				else
				{
					System.out.println("choose store to view the most viewed product.\n");
					for(int i=0;i<sell.getStores().size();i++)
						System.out.println(i+1 +" "+ sell.getStores().get(i).getName());
					choice=scan.nextInt();
					
					if(choice<= sell.getStores().size() && choice >0)
					{
						store_Control s=new store_Control();
						s.most_viewd(sell.getStores().get(choice-1));
					}
					
				}
			}
			
			else if(choice==7)
			{
				if(!sell.isType())
				{
					System.out.print("yalla ya taaaafh ro7 e3ml account premium el awl. \n");
				}
				else
				{
					System.out.println("choose store to view the most viewed product.\n");
					for(int i=0;i<sell.getStores().size();i++)
						System.out.println(i+1 +" "+ sell.getStores().get(i).getName());
					choice=scan.nextInt();
					
					if(choice<= sell.getStores().size() && choice >0)
					{
						store_Control s=new store_Control();
						s.num_prod(sell.getStores().get(choice-1));
					}
					
				}
			}
			else
				break;
			
			
			
	
		}
	}
}

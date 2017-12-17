import java.util.Scanner;

public class admin_UI 
{
	public void show(admin sell)
	{
		System.out.println("************welcome "+sell.getName()+" ************");
		Scanner scan=new Scanner(System.in);
		while(true) 
		{
			System.out.println("\nDO you want to choose from \n1- categories.\n2- stores\n3- Add product tothe system\n4-add category");
			System.out.println("5-Provide voucher card \n6- add admon\n or log out");
			int choice =scan.nextInt();
			if(choice ==1 || choice==2)
			{
				user_Control u=new user_Control();
				u.first_show(choice);
			}
			else if(choice==3)
			{
				System.out.println("choose category ");
				for(int i=0;i<DB.categories.size();i++)
				{
					System.out.println(i+1 + "- "+DB.categories.get(i).getName());
				}
				
				choice=scan.nextInt();
				scan.nextLine();
				if(choice>DB.categories.size())
					return;
				
				String name;
				cate_Entity c=DB.categories.get(choice-1);
				System.out.print("Enter name of the product: ");
				name=scan.nextLine();
				
				prod_Entity p=new prod_Entity(name,c);
				DB.system_products.add(p);
			}
			else if(choice==4)
			{
				String name,des;
				scan.nextLine();
				System.out.println("Enter name of the category ");
				name=scan.nextLine();
				System.out.println("Enter description of the category ");
				des=scan.nextLine();
				cate_Entity p=new cate_Entity(name,des);
				DB.categories.add(p);
			}
			else if(choice==5)
			{
				admin_Control ad=new admin_Control();
				ad.provide_Vouch();
			}
			else if(choice==6)
			{
				String name,pass,address,email,phone;
				int age;
				scan.nextLine();
				System.out.print("admin Name: ");
				name=scan.nextLine();
				System.out.print("Password: ");
				pass=scan.nextLine();
				System.out.print("address: ");
				address=scan.nextLine();
				System.out.print("email: ");
				email=scan.nextLine();
				System.out.print("phone number: ");
				phone=scan.nextLine();
				System.out.print("age: ");
				age=scan.nextInt();
				admin admon=new admin(name,pass,address,phone,email,age);
				admon.Insert();
			}
			else
				return;
		}
	}

}

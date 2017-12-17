import java.util.Scanner;

public class cate_Control 
{
	public void Add_existing_product(prod_Entity pro,cate_Entity cat)
	{
		cat.getProducts().add(pro);
	}
	public void Suggest_product()
	{
		prod_Entity pro=new prod_Entity();
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<DB.categories.size();i++)
			System.out.print(i+1 +"- "+DB.categories.get(i).getName());
		int choice=scan.nextInt();
		if(choice <= DB.categories.size())
		{
			System.out.print("Enter product name : ");
			String name=scan.next();
			pro.setName(name);
			pro.setCategory(DB.categories.get(choice-1));
			admin.request_Prod.add(pro);
		}
		else
			System.out.println("ent 3'alat ... yalla he4");
		
	}
	public static void view_prod(cate_Entity c)
	{
		for(int i=0;i<c.getProducts().size();i++)
		{
			System.out.println(c.getProducts().get(i).getSerial_num() +" - "+c.getProducts().get(i).getName());
			System.out.println("---------------");
		}
	}
	
}

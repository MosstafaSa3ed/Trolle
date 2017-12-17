import java.util.Scanner;
import java.util.Vector;

public class prod_Control 
{
	public boolean view(int id)
	{
		prod_Entity prod=new prod_Entity();
		prod=prod.Select(id);
		if(prod.getSerial_num()==-1)
		{
			System.out.println("You entered a wrong ID");
			return false;
		}
			
		System.out.print("Name : "+prod.getName()+"\nColor : "+prod.getColor()+"\nDescription : "+prod.getDescription()+"\nWeight : "+prod.getWeight());
		System.out.println("\nPrice : "+prod.getPrice());
		return true;
	}
	
	public void buy(prod_Entity prod,buyer customer)
	{
		int cnt=1,choice;
		
		System.out.print("You can pay with:-\n ");
		System.out.print(cnt++ +"- Vouch\n"+cnt++ +"- Visa\n"+cnt++ +"- Cash on delivery\n"+ cnt++ +"- Exit");
		
		Scanner scan=new Scanner(System.in);
		choice=scan.nextInt();
		if(choice==1 )
		{
			if(customer.vouch>=prod.getPrice())
			{
				customer.vouch-=prod.getPrice();
				prod.Delete(prod.getSerial_num());
				System.out.print("Done we will contact you shortly\n");
			}
			else 
				System.out.print("el voucher bta3k me4 mkfe .. ro7 e5tar 7aga tdf3 feha flos ya lolo\n");
		}
		else if(choice==2)
		{
			scan.nextLine();
			System.out.print("please enter serial number of your visa : ");
			scan.nextLine();
			prod.Delete(prod.getSerial_num());
			System.out.print("Done we will contact you shortly\n");
		}
		else if(choice==3)
		{
			prod.Delete(prod.getSerial_num());
			System.out.print("Done we will contact you shortly\n");
		}
		else
			return;
	}
}

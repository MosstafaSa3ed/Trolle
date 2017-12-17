import java.util.Scanner;

public class Registration_UI {
	private seller sell,pre;
	private admin adm;
	private buyer buy;
	private user_Control uc;
	public Registration_UI()
	{
		sell=new seller();
		pre=new seller();
		adm=new admin();
		uc=new user_Control();
	}
	void show()
	{
		String name,pass,address,email,phone;
		int age;
		boolean ok;
		Scanner scan=new Scanner(System.in);
		while(true) {
		System.out.println("***********Welcome to Trolle***********\n\n1- Login\n2- Sign Up");
		String choice=scan.next();
		if(choice.equals("1")) 
		{
			System.out.print("Are you:-\n1- Customer\n2- Store owner\n3- Premium Store owner\n4- Admin\n ");
			
				choice=scan.next();
				scan.nextLine();
				if(!choice.equals("4") && !choice.equals("3") &&!choice.equals("2") &&!choice.equals("1") ) {
					System.out.print("Rakz ya 7amada\n");
					continue;
				}
				System.out.print("User Name: ");
				name=scan.nextLine();
				System.out.print("Password: ");
				pass=scan.nextLine();
				if(choice.equals("1"))
				{
					buy=new buyer(name,pass);
					if(buy.buyerID==-1)
						System.out.println("Ro7 Register el awl ya 7amada");
					else {
						buy=uc.login(buy);
						buyer_UI b_UI=new buyer_UI();
						b_UI.show(buy);
					}
				}
				else if(choice.equals("2"))
				{
					sell=new seller(name,pass,false);
					
					if(sell.getSellerID()==-1)
						System.out.println("Ro7 Register el awl ya 7amada");
					else {
						sell=uc.login(sell,false);
						seller_UI s_UI =new seller_UI();
						s_UI.show(sell);
					}
				}
				else if(choice.equals("3"))
				{
					pre=new seller(name,pass,true);
					System.out.println(pre.getSellerID());
					if(pre.getSellerID()==-1)
						System.out.print("Ro7 Register el awl ya 7amada");
					else {
						pre=uc.login(pre,true);
						seller_UI s_UI =new seller_UI();
						s_UI.show(pre);
					}
				}
				else if(choice.equals("4"))
				{
					adm=new admin(name,pass);
					if(adm.getAdminID()==-1)
						System.out.println("5ali 7d kber yd5lk");
					else {
						adm=uc.login(adm);
					admin_UI a_UI=new admin_UI();
					a_UI.show(adm);
					}
				}
			
		}
		else
		{
			System.out.print("Are you:-\n1- Customer\n2- Store owner\n3- Premium Store owner\n ");
			
				choice=scan.next();
				
				scan.nextLine();
				if(!choice.equals("3") &&!choice.equals("2") &&!choice.equals("1") ) {
					System.out.print("Rakz ya 7amada\n");
					continue;
				}
				System.out.print("User Name: ");
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
				scan.nextLine();
				//String n,String ad,String ph,String em,int agee
				if(choice.equals("1"))
				{
					buy = new buyer(name,pass,address,phone,email,age);
					ok= uc.signUp(buy);
					if(!ok)
						System.out.println("this name is already exist..try another one :)");
					else {
						buyer_UI b_UI=new buyer_UI();
						b_UI.show(buy);
					}
				}
				else if(choice.equals("2"))
				{
					System.out.print("store Name: ");
					String n=scan.nextLine();
					System.out.print("type: ");
					String type=scan.nextLine();
					System.out.print("store address: ");
					String addr=scan.nextLine();
					
					store_Entity s= new store_Entity(n,addr,type);
					sell= new seller(name,pass,address,phone,email,age,s,false);
					//s.Insert();
					s.setSeller(sell);
					ok= uc.signUp(sell);
					if(!ok)
						System.out.println("this name is already exist..try another one :)");
					else
					{
						seller_UI s_UI=new seller_UI();
						s_UI.show(sell);
					}
				}
				else if(choice.equals("3"))
				{
					System.out.print("store Name: ");
					String n=scan.nextLine();
					System.out.print("type: ");
					String type=scan.nextLine();
					System.out.print("store address: ");
					String addr=scan.nextLine();
					
					store_Entity s= new store_Entity(n,addr,type);
					pre= new seller(name,pass,address,phone,email,age,s,true);
					//s.Insert();
					s.setSeller(pre);
					ok= uc.signUp(pre);
					if(!ok)
						System.out.println("this name is already exist..try another one :)");
					else
					{
						seller_UI s_UI=new seller_UI();
						s_UI.show(pre);
					}
				}
			
		}
		}
	}
	public seller getSell() {
		return sell;
	}
	public void setSell(seller sell) {
		this.sell = sell;
	}
	public seller getPre() {
		return pre;
	}
	public void setPre(seller pre) {
		this.pre = pre;
	}
	public admin getAdm() {
		return adm;
	}
	public void setAdm(admin adm) {
		this.adm = adm;
	}
	public buyer getBuy() {
		return buy;
	}
	public void setBuy(buyer buy) {
		this.buy = buy;
	}
	public user_Control getUc() {
		return uc;
	}
	public void setUc(user_Control uc) {
		this.uc = uc;
	}
}

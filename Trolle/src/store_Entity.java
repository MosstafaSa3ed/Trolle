import java.util.Vector;

public class store_Entity {
	private seller Seller;
	private String address,name,type;
	private int ID;
	private Vector<prod_Entity>products=new Vector<prod_Entity>();
	
	private static int cnt=2000;
	
	public store_Entity()
	{
		ID=-1;
	}
	
	public store_Entity(String name,String address,String type)
	{
		this.name=name;
		this.address=address;
		this.ID=cnt++;
		this.type=type;
		
	}
	public void Insert()
	{
		DB.stores.add(this);
	}
	
	public boolean Delete(int id)
	{
		for(int i=0;i<DB.stores.size();i++)
		{
			if(id==DB.stores.get(i).ID)
			{
				DB.stores.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean Update()
	{
		for(int i=0;i<DB.stores.size();i++)
		{
			if(this.ID==DB.stores.get(i).ID)
			{
				DB.stores.get(i).name=name;
				DB.stores.get(i).address=address;
				DB.stores.get(i).type=type;
				DB.stores.get(i).Seller=Seller;
				
				return true;
			}
		}
		return false;
	}
	
	public seller getSeller() {
		return Seller;
	}

	public void setSeller(seller seller) {
		Seller = seller;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Vector<prod_Entity> getProducts() {
		return products;
	}

	public void setProducts(Vector<prod_Entity> products) {
		this.products = products;
	}

	public static int getCnt() {
		return cnt;
	}

	public static void setCnt(int cnt) {
		store_Entity.cnt = cnt;
	}

	public store_Entity Select(int id)
	{
		for(int i=0;i<DB.stores.size();i++)
		{
			if(DB.stores.get(i).ID==id)
			{
				return DB.stores.get(i);
			}
		}
		store_Entity tem=new store_Entity();
		return tem;
	}
}

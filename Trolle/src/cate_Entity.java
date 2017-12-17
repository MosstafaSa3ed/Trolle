import java.util.Vector;

public class cate_Entity {
	static int cnt=1000;
	private String name,Description;
	private int ID;
	private Vector<prod_Entity> products=new Vector<prod_Entity>();
	
	public cate_Entity()
	{
		ID=-1;
	}
	
	public cate_Entity(String name,String Des)
	{
		this.name=name;
		this.Description=Des;
		this.ID=cnt++;
	}
	
	public void Insert()
	{
		DB.categories.add(this);
	}
	
	public boolean Delete(int id)
	{
		for(int i=0;i<DB.categories.size();i++)
		{
			if(id==DB.categories.get(i).ID)
			{
				DB.categories.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean Update()
	{
		for(int i=0;i<DB.categories.size();i++)
		{
			if(this.ID==DB.categories.get(i).ID)
			{
				DB.categories.get(i).name=name;
				DB.categories.get(i).Description=this.Description;
				DB.categories.get(i).products.clear();
				DB.categories.get(i).products.addAll(this.products);
				return true;
			}
		}
		return false;
	}
	
	public cate_Entity Select(int id)
	{
		for(int i=0;i<DB.categories.size();i++)
		{
			if(DB.categories.get(i).ID==id)
			{
				return DB.categories.get(i);
			}
		}
		cate_Entity tem=new cate_Entity();
		return tem;
	}

	public static int getCnt() {
		return cnt;
	}

	public static void setCnt(int cnt) {
		cate_Entity.cnt = cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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
}

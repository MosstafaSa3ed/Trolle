
public class prod_Entity
{
	static int cnt_prods=5000;
	private String name,color,weight,description;
	private cate_Entity category;
	private store_Entity store;
	private int serial_num,cnt_view=0;
	private double price;
	
	public prod_Entity() {
		serial_num=-1;
	}
	public prod_Entity(String name,cate_Entity category) 
	{
		this.name=name;
		this.category=category;
	}
	public prod_Entity(String name,String color,String weight,String description,cate_Entity category,double price,store_Entity s)
	{
		this.name=name;
		this.color=color;
		this.weight=weight;
		this.description=description;
		this.category=category;
		category.getProducts().add(this);
		this.price=price;
		this.serial_num=cnt_prods++;
		store=s;
		s.getProducts().add(this);
	}
	public static int getCnt_prods() {
		return cnt_prods;
	}
	public static void setCnt_prods(int cnt_prods) {
		prod_Entity.cnt_prods = cnt_prods;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public cate_Entity getCategory() {
		return category;
	}
	public void setCategory(cate_Entity category) {
		this.category = category;
	}
	public store_Entity getStore() {
		return store;
	}
	public void setStore(store_Entity store) {
		this.store = store;
	}
	public int getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(int serial_num) {
		this.serial_num = serial_num;
	}
	public int getCnt_view() {
		return cnt_view;
	}
	public void setCnt_view(int cnt_view) {
		this.cnt_view = cnt_view;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void Insert()
	{
		DB.products.add(this);	
	}
	public boolean Delete(int serial_num)
	{
		for(int i=0;i<DB.products.size();i++)
		{
			if(DB.products.get(i).serial_num==serial_num)
			{
				DB.products.get(i).category.getProducts().remove(DB.products.get(i));
				DB.products.get(i).store.getProducts().remove(DB.products.get(i));
				DB.products.remove(i);
				return true;
			}
		}
		return false;	
	}
	public boolean Update()
	{
		for(int i=0;i<DB.products.size();i++)
		{
			if(DB.products.get(i).serial_num==this.serial_num)
			{
				DB.products.get(i).name=this.name;
				DB.products.get(i).color=this.color;
				DB.products.get(i).weight=this.weight;
				DB.products.get(i).description=this.description;
				DB.products.get(i).category=this.category;
				DB.products.get(i).price=this.price;
				return true;
			}
		}
		return false;	
	}
	public prod_Entity Select(int id)
	{
		prod_Entity prod=new prod_Entity();
			for(int j=0;j<DB.products.size();j++)
			{
				if(id==DB.products.get(j).serial_num)
				{
					DB.products.get(j).cnt_view++;
					prod= DB.products.get(j);
					break;
				}
			}
		return prod;
	}
	
}

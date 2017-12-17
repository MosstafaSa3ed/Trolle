
public class store_Control {
	public void explore_store(store_Entity s)
	{
		System.out.println("******************************************");
		for(int i=0 ; i<s.products.size() ;i++)
		{
			System.out.println(i+1 +" " + s.products.get(i).name +" "+s.products.get(i).serial_num );
			System.out.println("---------------");
		}
		System.out.println("******************************************");
	}
	
	public void add_prod_store(prod_Entity prod,cate_Entity cate,store_Entity store)
	{
		boolean flag=false;
		for(int i=0;i<DB.system_products.size();i++)
		{
			if(prod.name.equals(DB.system_products.get(i).name))
			{
				flag=true;
				break;
			}
		}
		if(flag) {
			store.products.add(prod);
			prod.category=cate;
			cate.products.add(prod);
			DB.products.add(prod);
		}
		else 
			System.out.print("Please request this product first.\n");
	}
	
	public static void view_prod(store_Entity store)
	{
		for(int i=0;i<store.products.size();i++)
		{
			System.out.println(store.products.get(i).serial_num +" "+store.products.get(i).name);
			System.out.println("---------------");
		}
	}
	public void num_prod(store_Entity store)
	{
		for(int i=0;i<store.products.size();i++)
		{
			System.out.println(store.products.get(i).name+" "+store.products.get(i).cnt_view);
			System.out.println("---------------");
		}
	}
	public void most_viewd(store_Entity store)
	{
		int max=0,ind = 0;
		for(int i=0;i<store.products.size();i++)
		{
			if(store.products.get(i).cnt_view>=max)
				{	
					max=store.products.get(i).cnt_view;
					ind=i;
				}
		}
		System.out.println(store.products.get(ind).name+" "+max);
	}
}

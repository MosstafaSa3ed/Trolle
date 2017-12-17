
public class store_Control {
	public void explore_store(store_Entity s)
	{
		System.out.println("******************************************");
		for(int i=0 ; i<s.getProducts().size() ;i++)
		{
			System.out.println(i+1 +" " + s.getProducts().get(i).getName() +" "+s.getProducts().get(i).getSerial_num() );
			System.out.println("---------------");
		}
		System.out.println("******************************************");
	}
	
	public void add_prod_store(prod_Entity prod,cate_Entity cate,store_Entity store)
	{
		boolean flag=false;
		for(int i=0;i<DB.system_products.size();i++)
		{
			if(prod.getName().equals(DB.system_products.get(i).getName()))
			{
				flag=true;
				break;
			}
		}
		if(flag) {
			store.getProducts().add(prod);
			prod.setCategory(cate);
			cate.getProducts().add(prod);
			DB.products.add(prod);
		}
		else 
			System.out.print("Please request this product first.\n");
	}
	
	public static void view_prod(store_Entity store)
	{
		for(int i=0;i<store.getProducts().size();i++)
		{
			System.out.println(store.getProducts().get(i).getSerial_num() +" "+store.getProducts().get(i).getName());
			System.out.println("---------------");
		}
	}
	public void num_prod(store_Entity store)
	{
		for(int i=0;i<store.getProducts().size();i++)
		{
			System.out.println(store.getProducts().get(i).getName()+" "+store.getProducts().get(i).getCnt_view());
			System.out.println("---------------");
		}
	}
	public void most_viewd(store_Entity store)
	{
		int max=0,ind = 0;
		for(int i=0;i<store.getProducts().size();i++)
		{
			if(store.getProducts().get(i).getCnt_view()>=max)
				{	
					max=store.getProducts().get(i).getCnt_view();
					ind=i;
				}
		}
		System.out.println(store.getProducts().get(ind).getName()+" "+max);
	}
}

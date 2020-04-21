public class Hashtable<K extends Comparable<K>,T> {
	public  DHnode<K,T>[] arr;
	public  arraylist<Integer>index;
	private int tablesize,size;
	private float load;
//	private DHnode<K,T> temp= new DHnode<K,T>(null,null);
	
	public Hashtable() {
		index=new arraylist<Integer>();
		tablesize=16;
		size=0;
		load=0.0f;
		arr=new DHnode[tablesize];
	}


	public void insert(K key, T obj) {

		int x=key.hashCode();
		if(x<0)x=-x;
		int hash1=(x%tablesize);
		DHnode<K,T> n =new DHnode<K,T>(key,obj);
		int h=hash1;
		while(arr[h]!=null) {
			h=(h+1)%tablesize;
		}
		size++;
	//	System.out.println("HASH "+h+"  "+obj.toString());
		index.add(h);
		arr[h]=n;
		load=(float)size/(float)tablesize;
		if(load>0.5f)
			Rehash();
		
	}
	
	

	public void Rehash() {
		tablesize=2*tablesize;
		load=(float)size/(float)tablesize;
		DHnode<K,T>[] newarr=new DHnode[tablesize];
		int x=0;
		int h;
		arraylist<Integer>indexes=new arraylist<Integer>();

		for(int i=0;i<size;i++) {
			//hash1=((index.get(i)%tablesize));
		x=arr[index.get(i)].getKey().hashCode();
		if(x<0)x=-1*x;
		h=x%tablesize;
		while(newarr[h]!=null)
		{
			h=(h+1)%tablesize;
		}
		newarr[h]=arr[index.get(i)];
		indexes.add(h);
		}
		arr=newarr;
		index=indexes;
		
	}
	public boolean contains(K key) {
		int x=key.hashCode();
		if(x<0)x=-1*x;
		int hash1=(x%tablesize);
		int h=hash1;
		while(arr[h]!=null){
			
				if(arr[h].getKey().equals(key)){
					return true;
				}
			h=(h+1)%tablesize;
		}return false;

	}

	public T get(K key) 
	{	
		int x=key.hashCode();
		if(x<0)x=-1*x;
		int hash1=(x%tablesize);
		int h=hash1;
		while(arr[h]!=null){
				if(arr[h].getKey().equals(key)){
					return arr[h].getvalue();
				}
			h=(h+1)%tablesize;
		}
		return null;

	}



}

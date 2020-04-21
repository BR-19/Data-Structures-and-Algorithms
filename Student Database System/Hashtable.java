

import java.lang.Math;

public class Hashtable<K,T> implements MyHashTable_<K, T> {
	private DHnode<K,T>[] arr;
	private int tablesize;
	private DHnode<K,T> temp= new DHnode<K,T>(null,null);
	public Hashtable(int size) {
		arr=new DHnode[size];
		tablesize=size;
	}

	public static long djb2(String str, int hashtableSize) { 
		long hash = 5381; 
		for (int i = 0; i < str.length(); i++) { 
			hash = ((hash << 5) + hash) + str.charAt(i); 
		} 
		return Math.abs(hash) % hashtableSize; 
	}

	public static long sdbm(String str, int hashtableSize) { 
		long hash = 0; 
		for (int i = 0; i < str.length(); i++) { 
			hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
		} 
		return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}

	public int insert(K key, T obj) {
		String x=key.toString();
		int count=0;
		long hash1=djb2(x,tablesize);
			long hash2=sdbm(x,tablesize);
			DHnode<K,T> n =new DHnode<K,T>(key,obj);
//System.out.println(hash1 + "voila!"+hash2);
	long h=hash1;
		while(arr[(int) h]!=null &&arr[(int)h]!=temp) {
		//System.out.println("VV"+hash1);
			h=(h+hash2)%tablesize;
			count++;
		}
	arr[(int)h]=n;
		count++;
//		System.out.println(h + "voila!");
		return count;
	}
	public boolean contains(K key) {
		String x=key.toString();
			long hash1=djb2(x,tablesize);
			long hash2=sdbm(x,tablesize);
			long h=hash1;
			while(arr[(int)h]!=null ||arr[(int)h]==temp){
				if(arr[(int)h]!=temp){
				if(arr[(int)h].getKey().toString().compareTo(x)==0){
					return true;
}
			}h=(h+hash2)%tablesize;
				}return false;

	}

	public int delete(K key) {
		String x=key.toString();
		int count=0;
		long hash1=djb2(x,tablesize);
		long hash2=sdbm(x,tablesize);
		//System.out.println(x+"maarl"+" "+hash1);
		long h=hash1;
	
		while(true) {
			if(arr[(int)h]!=null&&arr[(int)h]!=temp){
			if(arr[(int) h].getKey().toString().compareTo(x)==0) {
				//System.out.println(arr[(int)hash1].fname());
				arr[(int) h]=temp;
				count++;
				break;
			}
			}
			h=(h+hash2)%tablesize;
			count++;
		}
		return count;

	}
	public int update(K key, T obj) {
		String x=key.toString();
		int count=0;
		long hash1=djb2(x,tablesize);
		long hash2=sdbm(x,tablesize);
		long h=hash1;
		count++;
		while(true){
			if(arr[(int)h]!=temp&&arr[(int)h]!=null){
			if(arr[(int) h].getKey().toString().compareTo(x)==0) {
				arr[(int)h].setvalue(obj);
				break;
			}
		}
				h=(h+hash2)%tablesize;
			count++;
		}
		

		return count;
	}

	@SuppressWarnings("unchecked")
	public T get(K key) throws NotFoundException
	{	
		String x=key.toString();
		long hash1=djb2(x,tablesize);
			long hash2=sdbm(x,tablesize);
			long h=hash1;
			
			while(arr[(int)h]!=null ||arr[(int)h]==temp){
				if(arr[(int)h]!=temp){
				if(arr[(int)h].getKey().toString().compareTo(x)==0){
					return arr[(int)h].getvalue();
}
			}h=(h+hash2)%tablesize;
				}
			return null;

	}
	public String address(K key) throws NotFoundException{
	String x=key.toString();
long hash1=djb2(x,tablesize);
			long hash2=sdbm(x,tablesize);
			long h=hash1;
			
			while(arr[(int)h]!=null ||arr[(int)h]==temp){
				if(arr[(int)h]!=temp){
				if(arr[(int)h].getKey().toString().compareTo(x)==0){
					return (Integer.toString((int)h));
}
			}h=(h+hash2)%tablesize;
				}
			return "E";

	}


}

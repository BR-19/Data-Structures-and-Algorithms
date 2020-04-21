
public class arraylist<T>{
	Object[] list;
	private int size=0;
	private int current_size;
	
	public arraylist() {
		list=new Object[16];
		size=16;
	}
	
	public void add(T obj) {
		if(current_size==size-1) {
			size*=2;
			Object[] newlist=new Object[size];
			for(int i=0;i<list.length;i++) {
				newlist[i]=list[i];
			}
			list=newlist;
		}
		list[current_size]=obj;
		current_size++;
	}
	public T get(int i) {
		return (T)list[i];
	}
	
	public int size() {
		return current_size;
	}
	public boolean contains(T obj) {
		for(int i=0;i<this.size();i++) {
			if(list[i]!=null &&list[i].equals(obj)){
				return true;
			}
		}return false;
		
	}
	
	public void set(int n,T obj) {
		list[n]=obj;
		
	}
	

	

}

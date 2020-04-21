
public class node<K ,T> {
	private K key;
	private T value;
	public  node<K,T> left;
	public  node<K,T> right;
	
	public K GetKey() {
		return key;
	}
	public T getvalue() {
		return value;
	}
	public void setkey(K ke){
		key=ke;
	}
	
	public void setvalue(T obj) {
		value=obj;
	}
	public node(K key,T value) {
		this.key=key;
		this.value=value;
		this.left=null;
		this.right=null;
	}
	
	
	
	
}

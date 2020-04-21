
public class DHnode<K ,T> {
	private K key;
	private T value;
	
	public K getKey() {
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
	public DHnode(K key,T value) {
		this.key=key;
		this.value=value;
	}
	
	
	
	
}

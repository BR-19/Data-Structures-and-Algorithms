
public class Pair<T extends Comparable<T> ,V extends Comparable<V>> implements Comparable<Pair<T,V>>{
	private T first;
	private V second;
	public Pair(T first,V second) {
		this.first=first;
		this.second=second;
	}
	
	public void setfirst(T first) {
		this.first=first;
	}
	public void setsecond(V second) {
		this.second=second;
	}

	public T getfirst() {
		return first ;
	}
	public V getSecond() {
		return second;
	}
@Override
public int compareTo(Pair<T,V> p) {
	
	if(this.first.compareTo(p.getfirst())==0) {
	return(this.getSecond().compareTo(p.getSecond()));	
	}else return(this.first.compareTo(p.getfirst()));
}

	
}

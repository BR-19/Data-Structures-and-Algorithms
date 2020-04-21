public class Pair<T extends Comparable<T>,V extends Comparable<V>>implements Comparable<Pair<T,V>> {
	private T first;
	private V second;
	public Pair(T first,V second) {
		this.first=first;
		this.second=second;
	}

	public T getfirst() {
		return first ;
	}
	public V getSecond() {
		return second;
	}

	public String toString() {
		return ((String)first + (String)second);
	}
	public int compareTo(Pair<T,V> k) {
		int x=this.getfirst().compareTo(k.getfirst());
return x;

	}

}
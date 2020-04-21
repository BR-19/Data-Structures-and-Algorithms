
public class Graph_node<T extends Comparable<T>> implements Comparable<Graph_node<T>> {
T X,Y,Z;

public Graph_node(T X,T Y ,T Z) {
	this.X=X;
	this.Y=Y;
	this.Z=Z;
}
@Override
public int compareTo(Graph_node T) {
	return 0;
}


@Override
public int hashCode() {
	int x=X.hashCode();
	int y=Y.hashCode();
	int z=Z.hashCode();
return (x+y+z);	
}

@Override
public boolean equals(Object obj) {
	if(this==obj)
		return true;
	else if(!(obj instanceof Graph_node<?>)) {
		return false;
	}
	Graph_node<T> e=(Graph_node<T>) obj;
	
	if((this.X.compareTo(e.X)==0 &&this.Y.compareTo(e.Y)==0&&this.Z.compareTo(e.Z)==0)||
			(this.X.compareTo(e.X)==0 &&this.Y.compareTo(e.Z)==0&&this.Z.compareTo(e.Y)==0)||
			(this.X.compareTo(e.Y)==0 &&this.Y.compareTo(e.X)==0&&this.Z.compareTo(e.Z)==0)||
			(this.X.compareTo(e.Y)==0 &&this.Y.compareTo(e.Z)==0&&this.Z.compareTo(e.X)==0)||
			(this.X.compareTo(e.Z)==0 &&this.Y.compareTo(e.Y)==0&&this.Z.compareTo(e.X)==0)||
			(this.X.compareTo(e.Z)==0 &&this.Y.compareTo(e.X)==0&&this.Z.compareTo(e.Y)==0))
		return true ;
	return false;
}


}

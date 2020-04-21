
public class Edge implements EdgeInterface,Comparable<Edge> {

private PointInterface[] endpt;
public arraylist<Triangle> triangles;
private double edge_length;
	public Edge(Point X,Point Y) {
		endpt=new PointInterface[2];
	if(X.compareTo(Y)<0){
		endpt[0]=X;
		endpt[1]=Y;
	}else{
		endpt[1]=X;
		endpt[0]=Y;
	}	
	triangles=new arraylist<Triangle>();
		
	}
	public Point getX() {
		return (Point)endpt[0];
	}
	public Point getX1() {
		return (Point)endpt[1];
	}
	
	@Override
	public PointInterface[] edgeEndPoints() {
		// TODO Auto-generated method stub
		return endpt;
	}
	public void addtriangle(Triangle T) {

		for(int i=0;i<this.triangles.size();i++) {
			Triangle t=this.triangles.get(i);
			if(!t.neighbour_t.contains(T))
			t.addtriangle_neighbour(T);
			T.addtriangle_neighbour(t);
		}
		
	//	if(!triangles.contains(T))
		triangles.add(T);
	
	}
	
	public double edge_length() {
		 return Math.sqrt(Math.pow((double)(this.getX().X-this.getX1().X), 2)
		            + Math.pow((double)(this.getX().Y-this.getX1().Y), 2)
		            + Math.pow((double)(this.getX().Z-this.getX1().Z),2));
	}
	
	public double check(Edge e) {
		return ((this.getX().X-this.getX1().X)*(e.getX().X-e.getX1().X)+(this.getX().Y-this.getX1().Y)*(e.getX().Y-e.getX1().Y)+(this.getX().Z-this.getX1().Z)*(e.getX().Z-e.getX1().Z))/(this.edge_length*e.edge_length());
	}
	
	public int mesh() {
//		System.out.println(triangles.size());
		return triangles.size();
	}

	@Override 
	public int compareTo(Edge e) {
		if(this.getX().compareTo(e.getX())==0){
			return (this.getX1().compareTo(e.getX1()));
		}else 
			return (this.getX().compareTo(e.getX()));


	}
	
	@Override 
	public boolean equals(Object obj) {
		
		if(this==obj)
			return true;
		else if(!(obj instanceof Edge)) {
			return false;
		}
		Edge e=(Edge) obj;
		if(this.getX().compareTo(e.getX())==0 &&this.getX1().compareTo(e.getX1())==0) {
			return true;
		}else if(this.getX().compareTo(e.getX1())==0&&this.getX1().compareTo(e.getX())==0) {
							return true;
		}return false;
	}

}

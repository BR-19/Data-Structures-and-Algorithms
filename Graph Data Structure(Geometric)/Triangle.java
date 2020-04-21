
public class Triangle implements TriangleInterface {
	boolean isVisited;
	Point[] tri;
	int hop;
	arraylist<Triangle>neighbour_t;
	arraylist<Triangle>extended_t;
	Edge E1,E2,E3;
	int id=0;
	public Triangle(Point X,Point Y,Point Z,Edge E1,Edge E2,Edge E3) {
		tri = new Point[3];
		tri[0]=X;
		tri[1]=Y;
		tri[2]=Z;
		this.E1=E1;
		this.E2=E2;
		this.E3=E3;
		neighbour_t=new arraylist<Triangle>();
		extended_t=new arraylist<Triangle>();
		isVisited=false;
		hop=0;
	}
	
	public void setid(int x) {
			id=x;
	}
	public void hop(int x) {
		hop=x;
	}
	
	public void unset() {
		this.isVisited=false;
	}
	public void set() {
		this.isVisited=true;
	}
	
	public Triangle(Point X,Point Y,Point Z) {
		tri = new Point[3];
		tri[0]=X;
		tri[1]=Y;
		tri[2]=Z;
	}
	public boolean check(Point e) {
		if(tri[0].compareTo(e)==0||tri[1].compareTo(e)==0||tri[2].compareTo(e)==0) {
			return true;
		}return false;
	}
	
	public void addtriangle_extended(Triangle T) {
		if(!extended_t.contains(T))
	extended_t.add(T);
	}
	public void addtriangle_neighbour(Triangle T) {
		if(!neighbour_t.contains(T))
		neighbour_t.add(T);
		}
	
	public boolean boundary_check() {
		return (E1.triangles.size()==1||E2.triangles.size()==1||E3.triangles.size()==1);
	}
	
	@Override
	public PointInterface[] triangle_coord() {
		// TODO Auto-generated method stub
		return tri;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		else if(!(obj instanceof Triangle)) {
			return false;
		}
		Triangle e=(Triangle) obj;
		
		if((this.tri[0].compareTo(e.tri[0])==0 &&this.tri[1].compareTo(e.tri[1])==0&&this.tri[2].compareTo(e.tri[2])==0)||
				(this.tri[0].compareTo(e.tri[0])==0 &&this.tri[1].compareTo(e.tri[2])==0&&this.tri[2].compareTo(e.tri[1])==0)||
				(this.tri[0].compareTo(e.tri[1])==0 &&this.tri[1].compareTo(e.tri[0])==0&&this.tri[2].compareTo(e.tri[2])==0)||
				(this.tri[0].compareTo(e.tri[1])==0 &&this.tri[1].compareTo(e.tri[2])==0&&this.tri[2].compareTo(e.tri[0])==0)||
				(this.tri[0].compareTo(e.tri[2])==0 &&this.tri[1].compareTo(e.tri[1])==0&&this.tri[2].compareTo(e.tri[0])==0)||
				(this.tri[0].compareTo(e.tri[2])==0 &&this.tri[1].compareTo(e.tri[0])==0&&this.tri[2].compareTo(e.tri[1])==0))
			return true ;
		return false;
	}
	

}

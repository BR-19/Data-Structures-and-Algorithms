
public class Point implements PointInterface,Comparable<Point> {
	float X,Y,Z;
arraylist<Triangle> triangles;
arraylist<Edge>edges;
arraylist<Point>points;
boolean isVisited;
	public Point(float X,float Y,float Z) {
		this.X=X;
		this.Y=Y;
		this.Z=Z;
		triangles=new arraylist<Triangle>();
		edges=new arraylist<Edge>();
		points=new arraylist<Point>();
		isVisited=false;
	}
	public void set() {
		this.isVisited=true;
	}
	public void unset() {
		this.isVisited=false;
	}
	public void add(Point p) {
		this.X=this.X+p.X;
		this.Y=this.Y+p.Y;
		this.Z=this.Z+p.Z;
		
	}
	public void addtriangle(Triangle T) {
		for(int i=0;i<this.triangles.size();i++) {
			Triangle t=this.triangles.get(i);
			if(!t.extended_t.contains(T))
			t.addtriangle_extended(T);
			
			T.addtriangle_extended(t);
		}
		//if(!triangles.contains(T))
		triangles.add(T);
	}
	public void addedge(Edge e) {
		edges.add(e);
	}
	public void addpoint(Point p) {
		points.add(p);
	}
	
	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return X;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return Y;
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return Z;
	}

	@Override
	public float[] getXYZcoordinate() {
		// TODO Auto-generated method stub
		float[] cord= {X,Y,Z};
		return cord;
	}


public float abs(float x){
if(x<0) return -1*x;
else return x;
}

public boolean equal(float x,float y){

if(abs(x-y)<0.0001f){
	return true;
}else 
return false;
}


	@Override
	public int compareTo(Point p) {
		if(equal(this.X,p.getX())) {
			if(equal(this.Y,p.getY())) {
				if(equal(this.Z,p.getZ()))
				return 0;
				else if(this.Z>p.getZ()){
					return 1;
				}
				else return -1;
			}else if(this.Y>p.getY()) return 1;
				else return -1;
			}
		else if (this.X>p.getX())return 1;
		else return -1;

	}
		
	
	@Override 
	public boolean equals(Object obj) {
		
		if(this==obj)
			return true;
		else if(!(obj instanceof Point)) {
			return false;
		}
		Point e=(Point) obj;
	
		if(this.compareTo(e)==0) {
			return true;
		}else return false;
	}
		@Override
		public int hashCode() {
			int x=Float.hashCode(X);
			int y=Float.hashCode(Y);
			int z=Float.hashCode(Z);
			int hash=31*x;
			hash=31*(hash)+y;
			hash=31*(hash)+z;
		
		return ((hash));
		}

		

}

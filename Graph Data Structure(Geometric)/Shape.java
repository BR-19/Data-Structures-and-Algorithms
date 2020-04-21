

public class Shape implements ShapeInterface {
private arraylist<Triangle> dfst;
private arraylist<Edge> edges;
private Hashtable<Point,Point>points;
private Hashtable<Graph_node<Point>,Triangle>triangle;
private arraylist<Point> point;
int mesh_type;
int id;
public Shape() {
	triangle=new Hashtable();
	points=new Hashtable();
	edges=new arraylist<Edge>();
	dfst=new arraylist<Triangle>();
	point=new arraylist<Point>();
	mesh_type=0;
	id=0;
}


public void merge(arraylist<Edge> ar,int l,int m,int r) {
	int x=m-l+1;
	int y=r-m;
	Edge j1[] = new Edge[x];
	Edge j2[]=new Edge[y];

	for(int i=0;i<x;i++) {
		j1[i]=ar.get(i+l);
	}
	for(int i=0;i<y;i++) {
		j2[i]=ar.get(i+m+1);
	}
	int i=0;
	int j=0;
	int n=l;

	while(i<x &&j<y) {
		if(j1[i].edge_length() <=j2[j].edge_length()) {
			ar.set(n,j1[i]);
			i++;
		}
		else if(j1[i].edge_length() >j2[j].edge_length()){
			ar.set(n,j2[j]);
			j++;
		}
		n++;
	}
while(i<x)
{
	ar.set(n,j1[i]);
	i++;
	n++;
}	
while(j<y) 
{
	ar.set(n,j2[j]);
	j++;
	n++;
}
	
	
}

public void sort (arraylist<Edge> ar, int l,int r)
{
	if(l<r)
	{
		int m=(l+r)/2;
		sort(ar,l,m);
		sort(ar,m+1,r);
		merge(ar,l,m,r);
	}
}


public boolean check_collinear(Edge X,Edge Y,Edge Z) {

	if( (Math.abs(Math.tan(Math.acos(X.check(Y))) )) <=0.001 ||(Math.abs(Math.tan(Math.acos(Y.check(Z))) )) <=0.001 ||(Math.abs(Math.tan(Math.acos(X.check(Z))) )) <=0.001   )
		return true;
	return false ;
}
public boolean ADD_TRIANGLE(float [] triangle_coord){
	id++;
	Point X1=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
	Point X2=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
	Point X3=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
	Edge E1=new Edge(X1,X2);
	Edge E2=new Edge(X1,X3);
	Edge E3=new Edge(X2,X3);

	if(check_collinear(E1,E3,E2)) return false;
	
Edge n=E1;
Edge m=E2;
Edge mn=E3;


	if(!edges.contains(E1)) {
	
		edges.add(E1);
		
	}else
	{
		for(int i=0;i<edges.size();i++) {
	
		if(edges.get(i).compareTo(E1)==0) {
		
			n=edges.get(i);
		
		}
	}
	}


	if(!edges.contains(E2)) {
		//System.out.println("FIRST TIME "+E2.toString());
		//E2.addtriangle(Tri);
		edges.add(E2);
		
	}else
	{
		for(int i=0;i<edges.size();i++) {
		//	System.out.println("COMPARISON "+edges.get(i).compareTo(E2)+" "+edges.get(i).toString()+" "+E2.toString());
			if(edges.get(i).compareTo(E2)==0) {
		//		System.out.println("CHECK"+edges.get(i).toString()+" "+E2.toString());
				m=edges.get(i);
				//	edges.get(i).addtriangle(Tri);
			}
		}
	}
	if(!edges.contains(E3)) {
		//System.out.println("FIRST TIME "+E3.toString());
		//E3.addtriangle(Tri);
		edges.add(E3);		
	}else
	{
		for(int i=0;i<edges.size();i++) {
		//	System.out.println("COMPARISON "+edges.get(i).compareTo(E3));
			if(edges.get(i).compareTo(E3)==0) {
		//		System.out.println("CHECK"+edges.get(i).toString()+" "+E3.toString());
				mn=edges.get(i);
				//	edges.get(i).addtriangle(Tri);
			}
		}
	}


	Point e=X1;
	Point e1=X2;
	Point e2=X3;
		
	
	if(!points.contains(X1)) {
	//	X1.addtriangle(Tri);
		e.addedge(E1);
		e.addedge(E2);
		e.addpoint(X2);
		e.addpoint(X3);
		point.add(e);
		points.insert(e,e);
	}else 
	{
		e =points.get(X1);
		//e.addtriangle(Tri);
		if(!e.edges.contains(E1))
		e.addedge(E1);
		if(!e.edges.contains(E2))
		e.addedge(E2);
		if(!e.points.contains(X3)) {
		//	System.out.println(e.X+" "+e.Y+" "+e.Z+"  1 CHINs  "+X3.X+" "+X3.Y+" "+X3.Z);
		e.addpoint(X3);
		}
		if(!e.points.contains(X2)) {
		//	System.out.println("1 CHINss  "+X2.X+" "+X2.Y+" "+X2.Z);
		e.addpoint(X2);
		}	
	}
	if(!points.contains(X2)) {
	//	X2.addtriangle(Tri);
		e1.addedge(E1);
		e1.addedge(E3);
		e1.addpoint(X1);
		e1.addpoint(X3);
		point.add(e1);
		points.insert(e1,e1);	
	}else 
	{
	    e1 =points.get(X2);
	    if(!e1.edges.contains(E1))
		e1.addedge(E1);
	    if(!e1.edges.contains(E3))
		e1.addedge(E3);
		//e.addtriangle(Tri);
		if(!e1.points.contains(X3)) {
		//	System.out.println(e.X+" "+e.Y+" "+e.Z+"  2 CHINs  "+X3.X+" "+X3.Y+" "+X3.Z);
			e1.addpoint(X3);
			}
			if(!e1.points.contains(X1)) {
		//		System.out.println("2 CHINss  "+X1.X+" "+X1.Y+" "+X1.Z);
			e1.addpoint(X1);
			}	
	}if(!points.contains(X3)) {
		//X3.addtriangle(Tri);
		e2.addedge(E2);
		e2.addedge(E3);
		e2.addpoint(X1);
		e2.addpoint(X2);
		point.add(e2);
		points.insert(e2,e2);
		
	}else 
	{
		e2 =points.get(X3);
		if(!e2.edges.contains(E2))
		e2.addedge(E2);
		if(!e2.edges.contains(E3))
		e2.addedge(E3);
		//e.addtriangle(Tri);
		if(!e2.points.contains(X1)) {
		//	System.out.println("3 CHINs  "+X1.X+" "+X1.Y+" "+X1.Z);
			e2.addpoint(X1);
			}
			if(!e2.points.contains(X2)) {
			//	System.out.println("3 CHINss  "+X2.X+" "+X2.Y+" "+X2.Z);
			e2.addpoint(X2);
			}	
	}
	
	Graph_node<Point> g=new Graph_node<Point>(e,e1,e2);
	Triangle Tri=new Triangle(e,e1,e2,n,m,mn);
	Tri.setid(id);
	e.addtriangle(Tri);
	e1.addtriangle(Tri);
	e2.addtriangle(Tri);
	n.addtriangle(Tri);
	m.addtriangle(Tri);
	mn.addtriangle(Tri);

	triangle.insert(g, Tri);
	
	dfst.add(Tri);

	if(mesh_type!=-1) {
		int x= (n.mesh())*(m.mesh())*(mn.mesh());
				if(n.mesh()>2 || m.mesh()>2 || mn.mesh()>2 ) { mesh_type=-1;
				return true;}
				else {
						if(x==1) mesh_type+=3;
						if(x==2) mesh_type+=1;
						if(x==4) mesh_type-=1;
						if(x==8) mesh_type-=3;
					
				} 
					
	}
	
	
	return true;
	}	


public int TYPE_MESH(){
	/* int count=0;
	 int counts=0;
	 for(int i=0;i<edges.size();i++) {
		 if(edges.get(i).mesh()>2) {
			 return 3;
		 }else if(edges.get(i).mesh()==2) {
			 count++;
		 }else if (edges.get(i).mesh()==1) {
			 counts++;
		 }
	 }
	 if(count==edges.size()) return 1;
	 if(counts>=1)return 2;
	 
	 return -1;  
	 	*/
	
		if(mesh_type<0) return 3;
		else if(mesh_type==0) return 1;
		else return 2;
	
	
}
 

public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates){
	Point X=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
	Point z=points.get(X);
	if(z==null) return null;
	int l=z.triangles.size();
	Triangle[] tri=new Triangle[l];

	for(int i=0;i<l;i++) {
		tri[i]=z.triangles.get(i);
	}
	return tri;
	}


public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates){
	Point X=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
	Point z=points.get(X);
	if(z==null) return null;
	int l=z.edges.size();
	Edge[] tri =new Edge[l];
	for(int i=0;i<l;i++) {
		tri[i]=z.edges.get(i);
	}
	return tri;
}
public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates){
	Point X=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
	Point z=points.get(X);
	if(z==null) return null;
	int l=z.points.size();
	Point[] tri =new Point[l];
	for(int i=0;i<l;i++) {
		tri[i]=z.points.get(i);
	}
	return tri;
	}
public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates){ 
	Point X=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
	Point z=points.get(X);
	if(z==null) return null;
	int l=z.triangles.size();
	Triangle[] tri =new Triangle[l];
	for(int i=0;i<l;i++) {
		tri[i]=z.triangles.get(i);
	}
	return tri;
}
public EdgeInterface [] BOUNDARY_EDGES(){
	arraylist<Edge> ans=new arraylist<Edge>();
	for(int i=0;i<edges.size();i++) {
		if(edges.get(i).triangles.size()==1) {
			ans.add(edges.get(i));
		}
	}
	Edge[] tri =new Edge[ans.size()];
	if(ans.size()==0) return null; 
	
	sort(ans,0,ans.size()-1);
	
	for(int i=0;i<ans.size();i++) {
	//System.out.println(ans.get(i).toString());
		tri[i]=ans.get(i);
	}

	
return tri;
}

public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates){
	Point X=new Point(edge_coordinates[0],edge_coordinates[1],edge_coordinates[2]);
	Point Y=new Point(edge_coordinates[3],edge_coordinates[4],edge_coordinates[5]);
	Edge j=null;
	if(points.contains(X)) {
	Point x=points.get(X);
	for(int i=0;i<x.edges.size();i++) {
		if(x.edges.get(i).getX().compareTo(Y)==0||x.edges.get(i).getX1().compareTo(Y)==0) {
			j=x.edges.get(i);
			break;
		}
	}
	}
	
	if(j!=null) {
		Triangle[] tri=new Triangle[j.triangles.size()];
		for(int i=0;i<j.triangles.size();i++) {
			tri[i]=j.triangles.get(i);
		}
		return tri;
	}
	return null;
	/*	Edge e=new Edge(X,Y);
	int x=-1;
for(int i=0;i<edges.size();i++) {
	if(edges.get(i).equals(e)) {
		x=i;
		break;
	}
}if(x!=-1) {
Triangle[] tri=new Triangle[edges.get(x).triangles.size()];
for(int i=0;i<edges.get(x).triangles.size();i++) {
	tri[i]=edges.get(x).triangles.get(i);
}
return tri;
 }*/
}

 public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord){
		Point X=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		Point Y=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		Point Z=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		Triangle Tri = new Triangle(X,Y,Z);
		//arraylist<Triangle>ans=new arraylist<Triangle>();
		Graph_node<Point> g=new Graph_node<Point>(X,Y,Z);
		if(triangle.contains(g)) {
			Tri=triangle.get(g);
			Triangle[] ans=new Triangle[Tri.neighbour_t.size()];
		for(int i=0;i<Tri.neighbour_t.size();i++) {
			ans[i]= Tri.neighbour_t.get(i);
		}
		esort(ans,0,ans.length-1);
		return ans;
		
		}else 	 
	 return null;
	 }
 
 public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord){
	 	Point X=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
		Point Y=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
		Point Z=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
		Edge[] ans=new Edge[3];
		Graph_node<Point> g=new Graph_node<Point>(X,Y,Z);
		if(triangle.contains(g)) {
			Triangle t=triangle.get(g);
			ans[0]=t.E1;
			ans[1]=t.E2;
			ans[2]=t.E3;
			return ans;
		}else 
	 return null; 
 }
 public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord){
	Point X=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
	Point Y=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
	Point Z=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);

	Graph_node<Point> g=new Graph_node<Point>(X,Y,Z);
	if(triangle.contains(g))
	{Triangle t=triangle.get(g);
	return t.triangle_coord();
	}else 
	 return null;
 }

 public void emerge(Triangle[] ar,int l,int m,int r) {
		int x=m-l+1;
		int y=r-m;
		Triangle j1[] = new Triangle[x];
		Triangle j2[]=new Triangle[y];

		for(int i=0;i<x;i++) {
			j1[i]=ar[i+l];
		}
		for(int i=0;i<y;i++) {
			j2[i]=ar[i+m+1];
		}
		int i=0;
		int j=0;
		int n=l;

		while(i<x &&j<y) {
			if(j1[i].id <j2[j].id) {
				ar[n]=j1[i];
				//ar.set(n,j1[i]);
				i++;
			}
			else if(j1[i].id >j2[j].id){
				ar[n]=j2[j];
				//ar.set(n,j2[j]);
				j++;
			}
			n++;
		}
	while(i<x)
	{
		ar[n]=j1[i];
	//	ar.set(n,j1[i]);
		i++;
		n++;
	}	
	while(j<y) 
	{	ar[n]=j2[j];
		//ar.set(n,j2[j]);
		j++;
		n++;
	}
		
		
	}

	public void esort (Triangle[] ar, int l,int r)
	{
		if(l<r)
		{
			int m=(l+r)/2;
			esort(ar,l,m);
			esort(ar,m+1,r);
			emerge(ar,l,m,r);
		}
	}
 
 

public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord){
	
	Point X=new Point(triangle_coord[0],triangle_coord[1],triangle_coord[2]);
	Point Y=new Point(triangle_coord[3],triangle_coord[4],triangle_coord[5]);
	Point Z=new Point(triangle_coord[6],triangle_coord[7],triangle_coord[8]);
	Triangle Tri = new Triangle(X,Y,Z);
	Graph_node<Point> g=new Graph_node<Point>(X,Y,Z);
	if(triangle.contains(g)) {
		Tri=triangle.get(g);
		Triangle[] ans=new Triangle[Tri.extended_t.size()];
	for(int i=0;i<Tri.extended_t.size();i++) {
		ans[i]= Tri.extended_t.get(i);
		//	System.out.println("id  "+Tri.extended_t.get(i).id);
	}
	esort(ans,0,ans.length-1);
	return ans;
	
	}
	return null;
}

public int COUNT_CONNECTED_COMPONENTS(){
	int count=0;
	arraylist<Triangle>t=new arraylist<Triangle>();
	for(int i=0;i<dfst.size();i++) {
		
		Triangle T=dfst.get(i);
		if(!T.isVisited) {
			DFS_Connected(T,t);
			count++;
		}
	}
	for(int i=0;i<t.size();i++) {
		t.get(i).unset();
	}
//	System.out.println(count);
	return count;
}


public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2){
	Point X=new Point(triangle_coord_1[0],triangle_coord_1[1],triangle_coord_1[2]);
	Point Y=new Point(triangle_coord_1[3],triangle_coord_1[4],triangle_coord_1[5]);
	Point Z=new Point(triangle_coord_1[6],triangle_coord_1[7],triangle_coord_1[8]);

	Triangle Tri = new Triangle(X,Y,Z);
	Point X1=new Point(triangle_coord_2[0],triangle_coord_2[1],triangle_coord_2[2]);
	Point Y1=new Point(triangle_coord_2[3],triangle_coord_2[4],triangle_coord_2[5]);
	Point Z1=new Point(triangle_coord_2[6],triangle_coord_2[7],triangle_coord_2[8]);
	Triangle Tri1 = new Triangle(X1,Y1,Z1);
	
	Graph_node<Point> g=new Graph_node<Point>(X,Y,Z);
	Graph_node<Point> g1=new Graph_node<Point>(X1,Y1,Z1);
	arraylist<Triangle> t=new arraylist<Triangle>();
	Tri=triangle.get(g);
	Tri1=triangle.get(g1);
	if(Tri!=null&&Tri1!=null) {
	
		boolean z=false;
		boolean ans=DFS_connected(Tri,Tri1,z,t);
		for(int i=0;i<t.size();i++) {
		//	System.out.println(t.get(i).toString());
			t.get(i).unset();
		}
		return ans;
	}


	return false;
}



public void DFS_Connected(Triangle T,arraylist<Triangle>t) {
	T.set();
	t.add(T);
	for(int i=0;i<T.neighbour_t.size();i++) {
		if(!T.neighbour_t.get(i).isVisited)
			DFS_Connected(T.neighbour_t.get(i),t);
	}
	
}


public boolean DFS_connected(Triangle X,Triangle Y,boolean Z,arraylist<Triangle>T) {

	X.set();
	T.add(X);

	if(X==Y) { 

		Z=true;
		}
	
	for(int i=0;i<X.neighbour_t.size();i++) {
		
		if(Z)
		{
			break;
		}
		
		if(!X.neighbour_t.get(i).isVisited)
		Z=DFS_connected(X.neighbour_t.get(i),Y,Z,T);
	}
	return Z;
}

public PointInterface CENTROID_OF_COMPONENT(float [] point_coordinates){

	Point k=new Point(point_coordinates[0],point_coordinates[1],point_coordinates[2]);
	arraylist<Point>pr=new arraylist<Point>();
	Point Centroid=new Point(0f,0f,0f);

		k=points.get(k);
		
		if(k==null)return null;
	if(k!=null) {
		Centroid=DFS_Centroid(k,pr,Centroid);
		int size=pr.size();
		Centroid.X=(Centroid.X)/size;
		Centroid.Y=(Centroid.Y)/size;
		Centroid.Z=(Centroid.Z)/size;
		
	}
		for(int i=0;i<pr.size();i++) {
		//	System.out.println("CHECKKKK"+pr.get(i).X+" "+pr.get(i).Y+" "+pr.get(i).Z+" ");
			pr.get(i).unset();
		}

				//	System.out.println("CENTROID "+Centroid.X+" "+Centroid.Y+" "+Centroid.Z);

				return Centroid;
	
	

}


public PointInterface[] CENTROID (){
	arraylist<Point>Centroid=new arraylist<Point>();
	int count=0;
	arraylist<Point> temp=new arraylist<Point>();
	for(int i=0;i<point.size();i++) {
		
	//	System.out.println("CJECL"+point.get(i).X+" "+point.get(i).Y+" "+point.get(i).Z);
	
		Point Cen=new Point(0f,0f,0f);
		
		Point p=point.get(i);
		if(!p.isVisited) {
			
			count=temp.size();
			Cen=DFS_Centroid(p,temp,Cen);
			count=temp.size()-count;
			
			Cen.X=(Cen.X)/((float)count);
			Cen.Y=(Cen.Y)/((float)count);
			Cen.Z=(Cen.Z)/(float)count;
			Centroid.add(Cen);	
		}
		
	
	}
	for(int i=0;i<temp.size();i++) {
	
		temp.get(i).unset();
	}
	
	centroidsort(Centroid,0,Centroid.size()-1);
	
	Point[]ans=new Point[Centroid.size()];
	for(int i=0;i<Centroid.size();i++) {
		ans[i]=Centroid.get(i);
	}
	
	
	return ans;
}

public void mergec(arraylist<Point> ar,int l,int m,int r) {
	int x=m-l+1;
	int y=r-m;
	Point j1[] = new Point[x];
	Point j2[]=new Point[y];

	for(int i=0;i<x;i++) {
		j1[i]=ar.get(i+l);
	}
	for(int i=0;i<y;i++) {
		j2[i]=ar.get(i+m+1);
	}
	int i=0;
	int j=0;
	int n=l;

	while(i<x &&j<y) {
		if(j1[i].compareTo(j2[j])<0) {
			ar.set(n,j1[i]);
			i++;
		}
		else if(j1[i].compareTo(j2[j])>0){
			ar.set(n,j2[j]);
			j++;
		}
		n++;
	}
while(i<x)
{
	ar.set(n,j1[i]);
	i++;
	n++;
}	
while(j<y) 
{
	ar.set(n,j2[j]);
	j++;
	n++;
}
	
	
}

public void centroidsort (arraylist<Point> ar, int l,int r)
{
	if(l<r)
	{
		int m=(l+r)/2;
		centroidsort(ar,l,m);
		centroidsort(ar,m+1,r);
		mergec(ar,l,m,r);
	}
}

public Point DFS_Centroid(Point X,arraylist<Point>p,Point c) {

	X.isVisited=true;
//	System.out.println("ADDDING qe  "+ X.X+" "+X.Y+" "+X.Z+" "+X.isVisited);
	c.add(X);
	p.add(X);
	//System.out.println("ADDDING  "+ X.X+" "+X.Y+" "+X.Z);
	for(int i=0;i<X.points.size();i++) {
		
		Point j=points.get(X.points.get(i));
		
		if(!j.isVisited) {
			//System.out.println("ADDDING CC "+ X.points.get(i).X+" "+X.points.get(i).Y+" "+X.points.get(i).Z);
			c=DFS_Centroid(j,p,c);
		}
	}
	return c;
}


public int MAXIMUM_DIAMETER(){
	
	arraylist<Triangle>t=new arraylist<Triangle>();
	int max_diameter=0;
	int max_triangle=0;
	arraylist<Pair<Integer,Integer>> a=new arraylist<Pair<Integer,Integer>>();
	for(int i=0;i<dfst.size();i++) {
		int n_components=0;
		int diameter=0;
		Pair<Integer,Integer>x=new Pair<Integer,Integer>(diameter,n_components);
		Triangle T=dfst.get(i);
		if(!T.isVisited) {
		//	System.out.println("VISIR"+T.toString());
		x=BFS(T,t,n_components);
		//System.out.println(x.getfirst());
	//	n_components++;
		}
		

		for(int j=0;j<t.size();j++) {
	t.get(j).unset();
           }
         	if(x.getSecond()>=max_triangle){
         		max_triangle=x.getSecond();
           if(x.getfirst()>max_diameter){
           	max_diameter=x.getfirst();
           }
		}
		//Pair<Integer,Integer>ans=new Pair<Integer,Integer>(x.getSecond(),x.getfirst());
		//a.add(ans);
	}
	

for(int i=0;i<t.size();i++) {
	t.get(i).unset();
}

	
	return max_diameter;
}


public Pair<Integer,Integer> BFS(Triangle T,arraylist<Triangle>mark,int comp) {
	int number=comp;
	int diameter=0;
	Queue<Triangle> queue=new Queue<Triangle>();
	T.set();
	mark.add(T);
	queue.enqueue(T);
	
	while(queue.size()!=0) {
		T=queue.dequeue();
		int nu=T.hop;
		T.hop=0;
		for(int i=0;i<T.neighbour_t.size();i++) {
			Triangle n=T.neighbour_t.get(i);
			if(!n.isVisited) {
				n.hop(nu+1);
				n.set();
				mark.add(n);
				queue.enqueue(n);
				number++;
				//System.out.println("HOPS"+n.hop);
				if(diameter<=n.hop) {
					
					diameter=n.hop;
					//System.out.println("DIAMETER"+diameter);
				}
					
			}
		}
	}
	Pair<Integer,Integer> ans=new Pair<Integer,Integer>(diameter,number);
	
	return ans;
}

public 	PointInterface [] CLOSEST_COMPONENTS(){
	arraylist<arraylist<Point>> Components=new arraylist<arraylist<Point>>();
	
	arraylist<Point> temp=new arraylist<Point>();
	
	for(int i=0;i<points.index.size();i++) {
		Point p=points.arr[points.index.get(i)].getvalue();
		arraylist<Point> ans =new arraylist<Point>();
		if(!p.isVisited) {
			
		//	System.out.println("CJECL"+p.X+" "+p.Y+" "+p.Z);
			ans.add(p);
		//	System.out.println(ans.size());
			DFS_closest(p,temp,ans);
	
		}
		Components.add(ans);
	}
	Pair<Point,Point>closest=new Pair<Point,Point>(null,null);
	double distance=Double.MAX_VALUE;

	for(int i=0;i<Components.size()-1;i++) {

		arraylist<Point> p=Components.get(i);
		for(int j=i+1;j<Components.size();j++) {
		
		arraylist<Point>p1=Components.get(j);
		for(int o=0;o<p.size();o++) {
			//System.out.println("SDSAD"+p1.size());
			for(int z=0;z<p1.size();z++) {
			//	System.out.println("SDSAD"+p1.size());
			double d=Distance(p.get(o),p1.get(z));
		//	System.out.println("SDSAD "+ d+" "+distance);
		
			if(distance>d) {
				//System.out.println("SDSAD");
				closest.setfirst(p.get(o));
				closest.setsecond(p1.get(z));
				distance=d;
			}
			}
		}
		
		}
		
		
	}
	
	
//System.out.println("DISATRA"+distance+" "+closest.getfirst().X+" "+closest.getfirst().Y+" "+closest.getfirst().Z);
//System.out.println(closest.getSecond().X+" "+closest.getSecond().Y+" "+closest.getSecond().Z);

	/*for(int i=0;i<Components.size();i++) {
		arraylist<Point> p=Components.get(i);
		for(int j=0;j<p.size();j++) {
			
			System.out.println("CHECKING");
			System.out.println(p.get(j).X+" "+p.get(j).Y+" "+p.get(j).Z);
			System.out.println("CHECKING");
	}
	}*/
	
Point[] p=new Point[2];
	p[0]=closest.getfirst();
	p[1]=closest.getSecond();
	
	
	
	for(int j=0;j<temp.size();j++) 
		temp.get(j).unset();
		
return p;
}



public double Distance(Point X,Point Y) {
	 return Math.sqrt(Math.pow(X.X-Y.X, 2)
	            + Math.pow(X.Y-Y.Y, 2)
	            + Math.pow(X.Z-Y.Z, 2));
}
public void DFS_closest(Point X,arraylist<Point>p,arraylist<Point>ans) {
	//System.out.println("SIIZZE"+ans.size());
	X.set();
	//System.out.println("CJECL"+X.X+" "+X.Y+" "+X.Z);
	//c.add(X);
	p.add(X);
	
	for(int i=0;i<X.points.size();i++) {
		Point x=points.get(X.points.get(i));
	//	System.out.println("PRINTING NEUGH"+x.X+" "+x.Y+" "+x.Z);
		if(!x.isVisited) {
			//System.out.println("PRINTING NEUGH"+x.X+" "+x.Y+" "+x.Z);
			ans.add(x);
		DFS_closest(x,p,ans);
		}
	}
	
}



}

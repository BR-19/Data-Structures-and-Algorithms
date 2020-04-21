import java.io.*;

public class SDS {
	public static void main(String args[]) {
		int T=Integer.parseInt(args[0]);
		String q=args[1];
		if(q.compareTo("SCBST")==0){
		scbst<Pair<String,String>,student> h=new scbst<Pair<String,String>,student>(T);
		BufferedReader b1 = null;
		try {
			b1=new BufferedReader(new FileReader(args[2]));
		String line ;
			while((line=b1.readLine())!=null) {
				String [] arr=line.split(" ");

				if(arr[0].compareTo("insert")==0) {

					student s=new student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					if(h.contains(x)){
						System.out.println("E");
					}else {
					System.out.println(h.insert(x,s));
				}
			}
				if(arr[0].compareTo("update")==0) {
					student s =new student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
		
				if(h.contains(x)){
							int y= h.update(x,s);
				if(y>0){	
					System.out.println(h.update(x, s));
				}else System.out.println("E");}else System.out.println("E");
			}

				if(arr[0].compareTo("delete")==0) {
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					if(h.contains(x)){
					System.out.println(h.delete(x));
				}else System.out.println("E");
			}
				
				if(arr[0].compareTo("contains")==0) {
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					if(h.contains(x)!=true){
System.out.println("F");
					}else System.out.println("T");
				}

				if(arr[0].compareTo("get")==0) {

					try {		
						Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
						student s=h.get(x);
						if(s==null)System.out.println("E");
						else
						System.out.println(s.fname()+" "+s.lname()+" "+s.hostel()+" "+s.department()+" "+s.cgpa());
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("E");
					}
				}

				if(arr[0].compareTo("address")==0) {

					try {	Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					System.out.println(h.address(x));
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("E");
					}
				}


			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("E");
		}
	}
	else if(q.compareTo("DH")==0){
		Hashtable<Pair<String,String>,student> h=new Hashtable<Pair<String,String>,student>(T);
		BufferedReader b1 = null;
		
			
		try {
			b1=new BufferedReader(new FileReader(args[2]));
		String line ;
			while((line=b1.readLine())!=null) {
				String [] arr=line.split(" ");

				if(arr[0].compareTo("insert")==0) {
					student s=new student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					if(h.contains(x)){
						System.out.println("E");
					}else 
					System.out.println(h.insert(x,s));
					
				}

				if(arr[0].compareTo("update")==0) {
					student s =new student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					if(h.contains(x)){
					System.out.println(h.update(x, s));
				}else System.out.println("E");
			}
				if(arr[0].compareTo("delete")==0) {
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					if(h.contains(x)){
					System.out.println(h.delete(x));
				}else System.out.println("E");
			}
				if(arr[0].compareTo("contains")==0) {
					Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
					if(h.contains(x)!=true){
						System.out.println("F");
					}else System.out.println("T"); 
				}
				if(arr[0].compareTo("get")==0) {

					try {		
						Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);
						//System.out.println(x.getfirst()+" "+x.getSecond()+ arr[1]+ arr[2]);
						student s=h.get(x);
				//	System.out.println(s.concatinate());
						if(s!=null){
System.out.println(s.fname()+" "+s.lname()+" "+s.hostel()+" "+s.department()+" "+s.cgpa());
					} else System.out.println("E");
				}catch (NotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("E");
					}
				}
				if(arr[0].compareTo("address")==0) {

					try {	Pair<String,String> x=new Pair<String,String>(arr[1],arr[2]);

					System.out.println(h.address(x));
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("E");
					}
				}


			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("E");
		}	
}
}
}

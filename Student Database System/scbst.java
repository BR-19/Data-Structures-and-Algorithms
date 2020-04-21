

public class scbst<K extends Comparable<K>,T> implements MyHashTable_<K, T>{
private node<K,T>[] bst;
private int size;
public int counter=0;

public scbst(int size) {
	bst=new node[size];
		this.size=size;
	for(int i=0;i<size;i++)
		bst[i]=null;
	
}

public static long djb2(String str, int hashtableSize) { 
	long hash = 5381; 
	for (int i = 0; i < str.length(); i++) { 
		hash = ((hash << 5) + hash) + str.charAt(i); 
	} 
	return Math.abs(hash) % hashtableSize; 
}
public boolean contains(K key) {
String x=key.toString();
		long y=djb2(x,size);
		node<K,T> head=bst[(int)y];
		node<K,T> n=head;
		while(n!=null) {
					if(n.GetKey().toString().compareTo(key.toString())==0)
		{	
			return true;
		}
			if(n.GetKey().compareTo(key)==0 &&n.GetKey().toString().compareTo(key.toString())!=0){
				if(n.GetKey().toString().compareTo(key.toString())<0){
					n=n.right;
				}else if (n.GetKey().toString().compareTo(key.toString())>0){
					n=n.left;
				}
			}else {
		 if(n.GetKey().compareTo(key)<0){
			n=n.right; 
		}
		else if(n.GetKey().compareTo(key)>0){
			n=n.left;
		}
		
	}
}return false;
	}

public T get(K key) throws NotFoundException {
	String x=key.toString();
	int h=(int)djb2(x,size);
	node<K,T> head=bst[h];
	node<K,T> n=head;
	if(contains(key)){
	while(n!=null) {
			if(n.GetKey().toString().compareTo(key.toString())==0)
		{	
			return n.getvalue();
		}
			if(n.GetKey().compareTo(key)==0 &&n.GetKey().toString().compareTo(key.toString())!=0){
				if(n.GetKey().toString().compareTo(key.toString())<0){
					n=n.right;
				}else if (n.GetKey().toString().compareTo(key.toString())>0){
					n=n.left;
				}
			}else {
		 if(n.GetKey().compareTo(key)<0){
			n=n.right; 
		}
		else if(n.GetKey().compareTo(key)>0){
			n=n.left;
		}
		
	}
	}
}
	return null;
}

public int insert(K key,T obj) {
	int count=0;
	String x=key.toString();
	int h=(int)djb2(x,size);
	//System.out.println(h+"vola");
	node<K,T> head= bst[h];
	node<K,T> newNode= new node<K,T>(key,obj);
	node<K,T> n= head;
	node<K,T> z=null;
	if(head==null){
	head=newNode;
	bst[h]=head;
	count++;
}

	while(n!=null) {
		z=n;
		if(n.GetKey().toString().compareTo(key.toString())==0)
		{	
		}
			if(n.GetKey().compareTo(key)==0 &&n.GetKey().toString().compareTo(key.toString())!=0){
				if(n.GetKey().toString().compareTo(key.toString())<0){
					n=n.right;
					count++;
				}else if (n.GetKey().toString().compareTo(key.toString())>0){
					n=n.left;
					count++;
				}
			}else {
		 if(n.GetKey().compareTo(key)<0){
			n=n.right;
			count++; 
		}
		else if(n.GetKey().compareTo(key)>0){
			n=n.left;
			count++;
		}
		
	}
}
	if(z==null){
	z=newNode;
}
	else if(z.GetKey().toString().compareTo(key.toString())>0){
			z.left=newNode;
	count++;
}else {z.right=newNode;
		count++;}
		return count;
}
public int update(K key,T obj) {
	int count=0;
	String x=key.toString();
	int h=(int) djb2(x,size);
	//System.out.println(h+"vola");
	node<K,T> head= bst[h];
	node<K,T> n= head;	
	while(n!=null) {
		if(n.GetKey().toString().compareTo(key.toString())==0)
		{	
			n.setvalue(obj);
			count++;
			return count;
		}
			if(n.GetKey().compareTo(key)==0 &&n.GetKey().toString().compareTo(key.toString())!=0){

				if(n.GetKey().toString().compareTo(key.toString())<0){
					n=n.right;
					count++;
				}else if (n.GetKey().toString().compareTo(key.toString())>0){
					n=n.left;
					count++;
				}
			}else {
		 if(n.GetKey().compareTo(key)<0){
			n=n.right;
			count++; 
		}
		else if(n.GetKey().compareTo(key)>0){
			n=n.left;
			count++;
		}
		
	}
		
	}
		return count;
}

public String address(K key) throws NotFoundException{
String x=key.toString();
int h=(int) djb2(x,size);
String j="";
node<K,T> head=bst[h];
node<K,T> n=head;
if(contains(key)){
while(n!=null){
	if(n.GetKey().toString().compareTo(key.toString())==0)
		{	
			String k=Integer.toString(h);
			return (k+"-"+j);
		}
			if(n.GetKey().compareTo(key)==0 &&n.GetKey().toString().compareTo(key.toString())!=0){
		
				if(n.GetKey().toString().compareTo(key.toString())<0){
					n=n.right;
					j=j+"R";
				}else if (n.GetKey().toString().compareTo(key.toString())>0){
					n=n.left;
					j=j+"L";				}
			}else {
		 if(n.GetKey().compareTo(key)<0){
			n=n.right;
			j=j+"R";
		}
		else if(n.GetKey().compareTo(key)>0){
			n=n.left;
			j=j+"L";
		}
		
	}
}
}return "E";
}
		public node<K,T> minv(node<K,T> n) {
node<K,T>min=n;
		while(n.left!=null) {
			min=n.left;
			n=n.left;
		}return min;
	}

public int delete(K key) {
		 counter=0;
		String x=key.toString();
		int h=(int)djb2(x,size);
		node<K,T> head=bst[h];
	bst[h]=	del(head,key);
	return counter+1;

	}

public node<K,T> del(node<K,T> head,K key){
if(head==null){
	counter = -1;
	return head;
}
if(head.GetKey().compareTo(key)==0&&head.GetKey().toString().compareTo(key.toString())!=0){
if(head.GetKey().toString().compareTo(key.toString())>0){
	counter++;
	head.left=del(head.left,key);

	
}else if (head.GetKey().toString().compareTo(key.toString())<0){
	counter++;
	head.right=del(head.right,key);
	
}
}else if(head.GetKey().compareTo(key)!=0){
if(head.GetKey().compareTo(key)>0){
	counter++;
	head.left=del(head.left,key);
}else if (head.GetKey().compareTo(key)<0){
	counter++;
	head.right=del(head.right,key);
} 
}else {
	if(head.right==null &&head.left==null){
		return null;
	}
else if(head.right==null){
counter++;
return head.left;
}else if (head.left==null){
	counter++;
//	System.out.println("Bharat");
	return head.right;
}
//System.out.println("Bharat");
node<K,T> k=minv(head.right);
head.setkey(k.GetKey());
head.setvalue(k.getvalue());
counter++;
head.right=del(head.right,head.GetKey());
}return head;
}



}
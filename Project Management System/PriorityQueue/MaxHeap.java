package PriorityQueue;
import java.util.ArrayList;
public class MaxHeap<T extends Comparable> implements PriorityQueueInterface<T> {
private int count=0;
	public ArrayList<Pair<T,Integer> > a;
	public MaxHeap(){
		a=new ArrayList<Pair<T,Integer>>();
	}
public boolean isEmpty(){
    return a.isEmpty();
}
	
	public void swap(int x,int y) {
        Pair<T,Integer> q=a.get(x);
        Pair<T,Integer> z=a.get(y);
		//T c=q.getfirst();
		//T p=z.getfirst();
		a.set(x, z);
		a.set(y, q);
	}


    @Override
    public void insert(T element) {
        count++;
        Pair<T,Integer> k= new Pair<T,Integer>(element,count);
       // System.out.println(k.getSecond());
	a.add(k);
    	int x=a.size()-1;
    	int parent_position=((x-1)/2);
    	for(int i=x-1;i>=0;i=parent_position) {
    		 parent_position=((i-1)/2);
             Pair<T,Integer> o=a.get(parent_position);
    		T parent=o.getfirst();
            Pair<T,Integer> v=a.get(i);
    		T child=v.getfirst();
    			if(child.compareTo(parent)>0) {
    		swap(i,parent_position);
    			}else break;
    	}
   
    }

 public void insert(Pair<T,Integer> k) {
       // System.out.println(k.getSecond());
	a.add(k);
    	int x=a.size()-1;
    	int parent_position=((x-1)/2);
    	for(int i=x-1;i>=0;i=parent_position) {
    		 parent_position=((i-1)/2);
             Pair<T,Integer> o=a.get(parent_position);
    		
            Pair<T,Integer> v=a.get(i);
    		
    			if(v.getfirst().compareTo(o.getfirst())>0) {
    		swap(i,parent_position);
    			}else if(v.getfirst().compareTo(o.getfirst())==0){
    				if(v.getSecond()<o.getSecond()){
    					swap(i,parent_position);
    				}else break;
    			}else break;
    	}
   
    }
  
    public void delete() {
    int max=0;
    int p=0;
    int lc=1;
    int rc=2;
        while(lc<a.size()){
    	max=lc;
    	if(rc<a.size()){
    	if(a.get(rc).getfirst().compareTo(a.get(lc).getfirst())>0){
    		max=rc;
    	}else if(a.get(rc).getfirst().compareTo(a.get(lc).getfirst())==0){
            if(a.get(rc).getSecond()<a.get(lc).getSecond()){
                max=rc;
            }
        }
    }
    	if(a.get(p).getfirst().compareTo(a.get(max).getfirst())<0){
    	swap(p,max);
p=max;
lc=2*p+1;
rc=2*p+2;
    }else if(a.get(p).getfirst().compareTo(a.get(max).getfirst())==0)
{
    if(a.get(p).getSecond()>a.get(max).getSecond()){
        swap(p,max);
        p=max;
lc=2*p+1;
rc=2*p+2;
    }else {
        break;
    }
}
    else{
     break;
    }

}
  
    }

    @Override
    public T extractMax() {
    	
   if(a.size()!=0){
   	if(a.size()==1)
 {
 	T m=a.remove(0).getfirst();
 	return m;
 }else {
   	T max=a.get(0).getfirst();
   	Pair<T,Integer> s=a.remove(a.size()-1);
   	a.set(0,s);
   //	a.set(a.size()-1,null);
   	delete();
   	return max;
}
   }else return null;
}


 public Pair<T,Integer> ExtractMax() {
    	
   if(a.size()!=0){
   	if(a.size()==1)
 {
 	Pair<T,Integer> m=a.remove(0);
 	return m;
 }else {
   	Pair<T,Integer> max=a.get(0);
   	Pair<T,Integer> s=a.remove(a.size()-1);
   	a.set(0,s);
   //	a.set(a.size()-1,null);
   	delete();
   	return max;
}
   }else return null;
}

}

// This class implements the Queue
public class Queue<V> {
private Node<V> begin;
private Node<V> end;
private int elements;
  public static class Node<V>{
      private V data;
      private Node<V> next;
      public Node(V data){
          this.data=data;
      }
  }
  public Queue(){
      begin =null;
      end =null;
      elements=0;
  }
public int size(){
    return elements;
}
public boolean isEmpty(){
    return (begin==null);
}


public void enqueue(V node){
    Node<V> x=end;
    end=new Node<V>(node);
    end.next=null;
    if(isEmpty())
    begin=end;
    else 
        x.next=end;
    elements++;
}

public V dequeue(){

    V x=begin.data;
    begin=begin.next;
    elements--;
    if(isEmpty())
    end=null;
    return x;
    
}
    
}


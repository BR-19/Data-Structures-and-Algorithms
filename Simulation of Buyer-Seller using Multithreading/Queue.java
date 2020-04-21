// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize;
    private int front =0;
    private int rear =0;
    public Queue(int capacity) {    
  this.capacity=capacity;
  front=0;
  rear=capacity-1;
NodeBase<V>[] q=new NodeBase[capacity];
queue=q;
    }

    public int size() {
    return currentSize;
    }

    public boolean isEmpty() {
    return(currentSize==0);
    }
	
    public boolean isFull() {
    return(currentSize==capacity);
    }

    public void enqueue(Node<V> node) {
    if(!isFull()) {
    rear=(rear+1)%(queue.length);
    queue[rear]=node;
    currentSize=currentSize+1;
    }else {}
    }

    public NodeBase<V> dequeue() {
    if(!isEmpty()) {
    NodeBase<V> f=queue[front];
    queue[front]=null;
    front=(front+1)%(queue.length);
    currentSize--;
    return f;
    }else {return null;}
    }
}


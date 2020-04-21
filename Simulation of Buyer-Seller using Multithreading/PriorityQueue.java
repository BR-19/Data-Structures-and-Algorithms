
public class PriorityQueue<V> implements QueueInterface<V>{

	public NodeBase<V>[] queue;
	private int capacity, currentSize;
	private NodeBase<V>[] q;

	//the Priority Queue implementation

	public PriorityQueue(int capacity) {    
		this.capacity=capacity;
		NodeBase<V>[] q=new NodeBase[capacity];
		queue=q;
		currentSize=0;
	}

	public int size() {
		return currentSize;
	}

	public boolean isEmpty() {
		return (currentSize==0);
	}

	public boolean isFull() {
		return (currentSize==capacity);
	}

	public void enqueue(Node<V> node) {
		if(!isFull()) {
		
			queue[currentSize]=node;
			currentSize++;
			
		}else {}
	}

	// In case of priority queue, the dequeue() should 
	// always remove the element with minimum priority value
	public NodeBase<V> dequeue() {
		if(!isEmpty()) {
			int minIndex=0;
			for(int j=0;j<currentSize;j++) {
				
			
				if(queue[j].getPriority()<=queue[minIndex].getPriority()) {
			
					minIndex=j;
				}
			}NodeBase<V> r=queue[minIndex];

			currentSize--;
			for(int j=minIndex;j<currentSize;j++) {
			queue[j]=queue[j+1];
					}
			return r;
		}else {return null;}
	}
	
	public void display () {
		if (this.isEmpty()) {
			System.out.println("Queue is empty");
		}
		for(int i=0; i<currentSize; i++) {
			queue[i].show();
		}
	}
}


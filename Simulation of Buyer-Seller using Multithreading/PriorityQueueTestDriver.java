// Use this driver for the testing the correctness of your priority queue implementation
// You can change the add, remove sequence to test for various scenarios.
public class PriorityQueueTestDriver {
    public static void main(String[] args) {
	PriorityQueue<String> pq = new PriorityQueue<String>(15);
	Node<String> x =new Node<String>(4,"A");
	Node<String> x1 =new Node<String>(1,"B");
	Node<String> x2 =new Node<String>(0,"M");
	pq.enqueue(x);
pq.enqueue(x1);
pq.enqueue(x2);
pq.display();
	System.out.println();
    while (!pq.isEmpty()){
        NodeBase<String> n=pq.dequeue();
       System.out.println( n.getPriority());
	}
}
}

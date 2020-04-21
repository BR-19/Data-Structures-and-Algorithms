import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {

	public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
		//the constructor method by initializing the attibutes
		// ...
		this.catalog=catalog;
		this.inventory=inventory;
		this.setSleepTime(sleepTime);
		this.lock=lock;
		this.full=full;
		this.empty=empty;

	}

	public void sell() throws InterruptedException {
		try {
			lock.lock();
			// the try block for produce method
			// ...
			while(catalog.isFull()) {
				full.await();
			}
			if (inventory.isEmpty())
				return;
			NodeBase<V> k=inventory.dequeue();
			//System.out.println(inventory.isEmpty());
			catalog.enqueue((Node<V>) k);
			//System.out.print("add");
			//k.show();
			empty.signalAll();


		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			
		}		
	}
}

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {

	public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
		this.setSleepTime(sleepTime);
		this.lock=lock;
		this.full=full;
		this.empty=empty;
		this.setIteration(iteration);
		this.catalog=catalog;
		
	}
	public void buy() throws InterruptedException {
	
		try {
			lock.lock();
			while(catalog.isEmpty()) {
				empty.await();
			}		
			Node<V> n=(Node<V>) catalog.dequeue();
		//	System.out.println(catalog.dequeue().getValue());
			System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
			n.show(); // DO NOT REMOVE (For Automated Testing)
			// ...
		full.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			//Complete this block
		}
	}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sim {
    public int catalogSize; 
    public int numBuyers;
    public int numSellers;
    public int sellerSleepTime, buyerSleepTime;
    public Queue<Item> inventory;
    
    public static void main(String[] args) throws InterruptedException {
	
	Sim a_driver = new Sim();
	BufferedReader reader;
        int itemcount = 0;
	try {
	    reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
	    ArrayList<Node<Item>> list = new ArrayList<Node<Item>>();
	    String[] tokens = line.split(" ");
	    a_driver.catalogSize = Integer.parseInt(tokens[0]);
	    a_driver.numBuyers = Integer.parseInt(tokens[1]);
	    a_driver.numSellers = Integer.parseInt(tokens[2]);
	    a_driver.buyerSleepTime = Integer.parseInt(tokens[3]);
	    a_driver.sellerSleepTime = Integer.parseInt(tokens[4]);
	    
	    while (line != null) {
		line = reader.readLine();
		if (line != null) {
                    itemcount++;
		    tokens = line.split(" ");
		    Item item = new Item(tokens[1], Double.parseDouble(tokens[2]));
		    Node<Item> node = new Node<Item>(Integer.parseInt(tokens[0]), item);
		    list.add(node);
		}
	    }
            a_driver.inventory = new Queue<Item>(list.size());
        int x=list.size();
        for(int i=0;i<x;i++) { 			
      a_driver.inventory.enqueue(list.get(i));
  }
            //Add all elements of the ArrayList named "list" to inventory queue
            // ...
	    
            reader.close();
	} catch (IOException e) {
            e.printStackTrace();
	}
	
	Seller[] sellers = new Seller[a_driver.numSellers];
	Buyer[] buyers = new Buyer[a_driver.numBuyers];
	PriorityQueue<Node<Item>> queue = new PriorityQueue<Node<Item>>(a_driver.catalogSize);
	Lock lock = new ReentrantLock();
	Condition full = lock.newCondition();
	Condition empty = lock.newCondition();
        int iteration = itemcount/a_driver.numBuyers; // No. of purchases each buyer make

	// Create multiple Buyer and Seller Threads and start them.
        // ...
        for(int i=1;i<=a_driver.numBuyers;i++) {
        	Buyer x=new Buyer(a_driver.buyerSleepTime,a_driver.catalogSize,lock,full,empty,queue,iteration);
        	Thread Buy=new Thread(x) ;
        	Buy.start();
        }for(int i=1;i<=a_driver.numSellers;i++) {
        	 Seller y=new Seller(a_driver.sellerSleepTime,a_driver.catalogSize,lock,full,empty,queue,a_driver.inventory);
        	 Thread sell= new Thread(y);
        	sell.start();
        }
               
		
	
    }
}

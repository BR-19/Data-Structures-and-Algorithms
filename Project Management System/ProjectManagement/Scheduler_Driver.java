package ProjectManagement;

import PriorityQueue.PriorityQueueDriverCode;
import RedBlack.RBTree;
import RedBlack.RedBlackNode;
import Trie.Trie;
import Trie.TrieNode;
import PriorityQueue.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class Scheduler_Driver extends Thread implements SchedulerInterface {

private MaxHeap<Job> jobs=new MaxHeap<Job>();
private ArrayList<Project> projects=new ArrayList<Project>();
private RBTree<User,Job> users=new RBTree<User,Job>();
private RBTree<String,Pair<Job,Integer> > nq=new RBTree<String,Pair<Job,Integer> >();
//private Trie<ArrayList<Pair<Job,Integer>> > nq=new Trie<List<Pair<Job,Integer>> >();
private Trie<Job> jb=new Trie<Job>();
private ArrayList<Job> finished=new ArrayList<Job> ();
private ArrayList<Job> notfinished=new ArrayList<Job> ();
private int globaltime=0;
private int countjobs=0;
    public static void main(String[] args) throws IOException {
        Scheduler_Driver scheduler_driver = new Scheduler_Driver();

        File file;
        if (args.length == 0) {
            URL url = PriorityQueueDriverCode.class.getResource("INP");
            file = new File(url.getPath());
        } else {
            file = new File(args[0]);
        }

        scheduler_driver.execute(file);
    }

    public void execute(File file) throws IOException {

        URL url = Scheduler_Driver.class.getResource("INP");
        file = new File(url.getPath());

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("Input file Not found. "+file.getAbsolutePath());
        }
        String st;
        while ((st = br.readLine()) != null) {
            String[] cmd = st.split(" ");
            if (cmd.length == 0) {
                System.err.println("Error parsing: " + st);
                return;
            }

            switch (cmd[0]) {
                case "PROJECT":
                    handle_project(cmd);
                    break;
                case "JOB":
                    handle_job(cmd);
                    break;
                case "USER":
                    handle_user(cmd[1]);
                    break;
                case "QUERY":
                    handle_query(cmd[1]);
                    break;
                case "":
                    handle_empty_line();
                    break;
                case "ADD":
                    handle_add(cmd);
                    break;
                default:
                    System.err.println("Unknown command: " + cmd[0]);
            }
        }


        run_to_completion();

        print_stats();

    }



    @Override
    public void run() {
        // till there are JOBS
        schedule();
    }


    @Override
    public void run_to_completion() {
    	
while(jobs.a.size() > 0){
  //	System.out.println("Remaining jobs: "+jobs.a.size());
	//System.out.println("BHARAT");
schedule();
System.out.println("System execution completed");

}
    }

    @Override
    public void handle_project(String[] cmd) {
    	System.out.println("Creating project");
    String name =cmd[1];
    String Priority=cmd[2];
    String Budget=cmd[3];
  Project y=new Project(name,Priority,Budget);
  projects.add(y);
    }

    @Override
    public void handle_job(String[] cmd) {

    	System.out.println("Creating job");
   String name=cmd[1];
String Projectname=cmd[2];
String username=cmd[3];
String runtime=cmd[4];
Project y=null;
for(int i=0;i<projects.size();i++){
	if(projects.get(i).name.compareTo(Projectname)==0)
 y=projects.get(i);
 }/*if(y!=null){
 	if(y.getValue()!=null)
 System.out.println(y.getValue().name);
 return;
 }*/
User user=new User(username);
//System.out.println(user.name);
RedBlackNode<User,Job> use=users.search(user);
//System.out.println(use);
if(use.getValues()==null){
	System.out.println("No such user exists: "+username);
	return;
}
if(y==null)
{
	System.out.println("No such project exists. "+Projectname);
	return;
}
//System.out.println("SADSAD");

Job x=new Job(name,username,runtime,y);
users.insert(user,x);
//System.out.println(users.search(user).getValue());
jb.insert(name,x);
jobs.insert(x);
//String p=jb.search(name).getValue().toString();
//if(p!=null)
//System.out.println(p+"sadsad");
   countjobs++;
   
 }

    @Override
    public void handle_user(String name) {
    	System.out.println("Creating user");
User x=new User(name);
users.insert(x,null);
//RedBlackNode<User,Job> y=users.search(x);
//System.out.println(y.GetKey().name);
    }

 
    @Override
    public void handle_query(String key) {
    	System.out.println("Querying");
    	TrieNode<Job> x=jb.search(key);
   	//System.out.println(x.getValue().name+"asds");
    	if(x!=null){
    		String status =x.getValue().status;
    		if(status.compareTo("REQUESTED")==0){
    		System.out.println(key+": "+"NOT FINISHED");
 }else {
 	System.out.println(key+": "+"COMPLETED");
}
    return;
    	} 

  	for(Job j :notfinished){
    			if(j.name.equals(key)){
    				System.out.println(key+": NOT FINISHED");
  				  return;			}
    	}
    	for(Job jo :finished){
    			if(jo.name.equals(key)){
    			
    				System.out.println(key+": COMPLETED");
    		return;
    			}
    			
    			
    	}
    	//System.out.println("BHARAT");
				
				System.out.println(key+": NO SUCH JOB"); 

    }




    @Override
    public void handle_empty_line() {
    	//System.out.println("Running code");
schedule();
    System.out.println("Execution cycle completed");
    }

    @Override
    public void handle_add(String[] cmd) {
    	
    	System.out.println("ADDING Budget");
String Projectname=cmd[1];
int Budget=Integer.parseInt(cmd[2]);
Project x=null;
for(int i=0;i<projects.size();i++){
	if(projects.get(i).name.compareTo(Projectname)==0)
 x=projects.get(i);
 }
if(x==null){
	System.out.println("No such project exists. "+Projectname);
}
x.addBudget(Budget);
RedBlackNode<String,Pair<Job,Integer> > n=nq.search(Projectname);

if(n==null || n.getValues().isEmpty())
	return;

	//ArrayList<Job> a=n.getValues();
	for(Pair<Job,Integer> job: n.getValues()){
		if(job.getfirst().status.compareTo("COMPLETED")!=0){
		jobs.insert(job);
		notfinished.remove(job.getfirst());
			countjobs++;
		}
	}
	/*while(jobs.a.size()>0){
		Job z=jobs.extractMax();
		System.out.println(z.name+"SADSAFDWQFQWGNHKJHFLKSASADSAJ");
	}*/
	n.getValues().clear();


    }

    @Override
    public void print_stats() {
System.out.println("--------------STATS---------------");
System.out.println("Total jobs done: "+finished.size());

for(Job j:finished){
	System.out.println(j.toString());
}
System.out.println("------------------------");
System.out.println("Unfinished jobs: ");
    for(Job j:notfinished){
    	System.out.println(j.toString());	
    }
    System.out.println("Total unfinished jobs: "+notfinished.size());
    System.out.println("--------------STATS DONE---------------");

    }

    @Override
    public void schedule() {
    	System.out.println("Running code");
System.out.println("Remaining jobs: "+countjobs);
    	while(true){
    
    		
			countjobs--;
			Pair<Job,Integer> x=jobs.ExtractMax();
			Project y=x.getfirst().project;
			int Budget=y.Budget;
			System.out.println("Executing: " + x.getfirst().name + " from: " + y.name);
			if(x.getfirst().runtime<=Budget){
				x.getfirst().setStatus();
				globaltime=globaltime+x.getfirst().runtime;
				x.getfirst().settime(globaltime);
				y.setBudget(x.getfirst().runtime);
				//System.out.println(x.getfirst()+"SDsaDWQRWQF NMx nnm");
				finished.add(x.getfirst());
				//System.out.println(finished.size()+"SDsaDWQRWQF NMx nnm");
				System.out.println("Project: " + y.name + " budget remaining: "+ y.Budget);
				break;
			} else {

				nq.insert(y.name,x);
				//System.out.println(x.getfirst()+"ASDWQEQWVVGGGGGGGGGGGG");
				notfinished.add(x.getfirst());
				System.out.println("Un-sufficient budget.");

				//if(jobs.a.size()>0)
				//schedule();
			}
			}
		
	}

}
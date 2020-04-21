package ProjectManagement;

public class Job implements Comparable<Job> {
String name;
Project project;
String username;
int runtime;
String status;
int completedtime;
int priority;
public Job(String name,String username,String r,Project xe){
	this.name=name;
	this.username=username;
	runtime=Integer.parseInt(r);
	this.project=xe;
	this.priority=xe.priority;
	status="REQUESTED";
	completedtime=0;
}
    @Override
    public int compareTo(Job job) {
        return (this.priority-job.priority);
    }

    public void setStatus(){
    	status= "COMPLETED";
    }

    public void settime(int time){
    	completedtime=time;
    }
public Project getproject(){
    return project;
}

@Override
public String toString(){
	if(completedtime!=0){
	return "Job{user='"+username+"', project='"+project.name+"', jobstatus="+status+", execution_time="+runtime+", end_time="+completedtime+", name='"+name+"'}";
}else return "Job{user='"+username+"', project='"+project.name+"', jobstatus="+status+", execution_time="+runtime+", end_time="+"null"+", name='"+name+"'}";
}
}
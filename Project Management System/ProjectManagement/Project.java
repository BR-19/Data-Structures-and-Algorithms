package ProjectManagement;


public class Project {
String name;
int priority,Budget;

Project(String name,String p,String B){
	this.name=name;
	priority=Integer.parseInt(p);
	Budget=Integer.parseInt(B);
}
public void addBudget(int x){
	Budget=Budget+x;
}
public void setBudget(int x){
	this.Budget=this.Budget-x;
}
}


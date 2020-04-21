This project implemets following Data Structures :- Priority Queue,Red Black tree,Trie 
After implemeting each of these Data structures , with the use of these A "PROJECT MANAGEMENT SYSTEM" is implemented.

The main component in this part of this project is a Job.Each Job will belong to a Project and created by an User. The name of the Jobs will be unique (this is guaranteed in the test cases). All the jobs have a running time, i.e. the time required to run this job. The priority of a job is same as of that its project and a job can only be executed if its running time is less than the current budget of the Project. Successfully running a Job, will reduce the budget of that project by running time of the project.
All the projects will be stored in a Trie, using the project name as the key. Project names will be unique. All the Jobs will be stored in a Priority Queue, specifically a Max-Heap, using their priorities as the key.

The scheduler will execute a single job whenever it will encounter an empty line in the input specifications. After the end of the INP (input file) file, scheduler will continue to execute jobs till there are jobs left that can be executed.
Each time the scheduler wants to execute a job, it will do the following:

1.It selects the job with the highest priority from the MAX HEAP.
2.It first check the running time of the Job, say t.
3.It will then fetch the project from the RB-Tree and check its budget, say B.
4.If B ≥ t then it executes the job. Executing a job means:Set the status of the job to complete.
Increase the global time by job time.
Set the completed time of the job as the current global time.
Decrease the budget of the project by run-time of the job. i.e. ˆB = B - t, where ˆB is the new budget of the project.
5.If: B < t, then select the next job from the max-heap (where jobs are stored) and try to execute this.
6.A scheduler will return in following cases:
It successfully executed a single job.There are no jobs to be executed.None of the jobs can be executed because of the budget issue.
7.After the execution returns, process the next batch of commands (all the commands till next EMPTY_LINE or EOF).
8.If there are no more commands in the INP (input file) file, then let the scheduler execute jobs till there are no jobs left, or no jobs can be executed because of budget issues. This marks the END of the execution.
9.Print the stats of the current system.


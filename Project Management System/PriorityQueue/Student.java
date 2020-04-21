package PriorityQueue;

public class Student implements Comparable<Student> {
    private String name;
    private Integer marks;

    public Student(String trim, int parseInt) {
        name=trim;
        marks=parseInt;
    }

public int getMarks() {
    return marks;
}
    @Override
    public int compareTo(Student student) {
        return (this.marks.compareTo(student.getMarks()));
    }

    public String getName() {
        return name;
    }

    @Override 
    public String toString(){
        return ("Student{name="+"'"+this.getName()+"'"+","+" marks="+this.getMarks()+"}");
    }
}

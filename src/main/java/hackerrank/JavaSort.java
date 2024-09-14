package hackerrank;

import java.util.*;

/**
 * @author raag
 */
public class JavaSort {

        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());

            List<Student> studentList = new ArrayList<Student>();
            while(testCases>0){
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();

                Student st = new Student(id, fname, cgpa);
                studentList.add(st);

                testCases--;
            }

            studentList.sort(new Comparator<Student>() {
                @Override
                public int compare(Student t1, Student t2) {
                    if (t1.getCgpa() - t2.getCgpa() != 0) {
                        if (t1.getCgpa() > t2.getCgpa()) {
                            return -1;
                        }
                        return 1;
                    }
                    if (t1.getFname().compareTo(t2.getFname()) != 0) {
                        return t1.getFname().compareTo(t2.getFname());
                    }
                    return t1.getId() - t2.getId();
                    // return -1;
                }});

            for(Student st: studentList){
                System.out.println(st.getFname());
            }
        }
    }

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

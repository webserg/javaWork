package thread.folkJoinIssue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * The idea is that a ParallelArray represents a collection 
 * of structurally similar data items, and you use the methods 
 * on ParallelArray to create a description of how you want to 
 * slice and cut the data. You then use the description to 
 * actually execute the array operations (which uses the 
 * fork-join framework under the hood) in parallel. This approach 
 * has the effect of letting you declaratively specify data selection, 
 * transformation, and post-processing operations, and letting the 
 * framework figure out a reasonable parallel execution plan, just as 
 * database systems allow you to specify data operations in SQL and hide 
 * the mechanics of how the operations are implemented. 
 * 
 * @author Sergiy Doroshenko webserg@gmail.com
 * May 28, 2009 5:14:45 PM
 */

/**
 * @TODO replace import jsr 166 to java7
 */
@Deprecated
public class ParallelArrayExample {
    final ForkJoinPool pool = new ForkJoinPool(2);
  //Create a predicate for filtering
//    final Ops.Predicate<Student> aWoman = new Ops.Predicate<Student>() {
//        public boolean op(final Student friend) {
//            return !friend.isMale();
//        }
//    };

    //Create an operation to retrieve the name from an element
//    final Ops.Op retrieveName = new Ops.Op() {
//
//        public Object op(Object o) {
//            return ((Student) o).getName();
//        }
//    };
//    static final Ops.Predicate<Student> isSenior = new Ops.Predicate<Student>() {
//        public boolean op(Student s) {
//            return s.getGraduationYear() == 2009;
//        }
//    };
//
//    static final Ops.ObjectToDouble<Student> selectGpa = new Ops.ObjectToDouble<Student>() {
//        public double op(Student student) {
//            return student.getGpa();
//        }
//    };
public static void main(String[] args) {
    ParallelArrayExample p = new ParallelArrayExample();
    List<Student> l = new ArrayList<Student>();
    l.add(new Student("julia",false,2009,5.0));
    l.add(new Student("rita",false,2008,5.0));
    l.add(new Student("serg",true,2009,9.0));
    Student[] s = new Student[l.size()];
//    ParallelArrayExample<Student> students = ParallelArray.createFromCopy(l.toArray(s), p.pool);
//    final ParallelArray<Student> namesOfWomen =
//        students.withFilter(p.aWoman).withMapping(p.retrieveName).all();
//       System.out.println("namesOfWomen = " + namesOfWomen);
//
//    double bestGpa = students.withFilter(isSenior)
//                             .withMapping(selectGpa)
//                             .max();
//    System.out.println(bestGpa);
}
}
class Student {
    private String name;
    public Student(String name, boolean male,int y,double gpa) {
        super();
        this.name = name;
        this.male = male;
        this.gpa = gpa;
        this.graduationYear= y;
    }
    private int graduationYear;
    private double gpa;
    private boolean male;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGraduationYear() {
        return graduationYear;
    }
    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public boolean isMale() {
        return male;
    }
    public void setMale(boolean male) {
        this.male = male;
    }
    
}


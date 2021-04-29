/**
 * <h1>Lab6b</h1>
 * <h2>CISC 181-052L Spring 2021</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The purpose of Lab 6b is to work with arraylists,
 * implementing pre-defined Object methods(equal,toString,compareTo),
 * Overriding methods for polymorphism, and Implementing Comparable Interface
 *
 * @author London Kumar
 * @since 2021-04-29
 */
import java.util.Objects;
public class Course implements Comparable<Course>{
    /**
     * dept, a String that represents the department of the course
     * courseNum, a int that represents the course number
     * sectionNum, a int that represents the section number
     * MAX_SIZE, a int that represents the max capacity of the class
     */
    private String dept;
    private int courseNum;
    private int sectionNum;
    private int capacity;

    public Course(String dept, int courseNum, int sectionNum, int capacity){
        this.dept = dept.toUpperCase();
        this.courseNum = courseNum;
        this.sectionNum = sectionNum;
        this.capacity = capacity;
    }

    /**
     * This method gets the department
     * @return dept, the department of the class
     */
    public String getDept(){
        return this.dept;
    }

    /**
     * This method gets the course number
     * @return courseNum, the course number
     */
    public int getCourseNum(){
        return this.courseNum;
    }

    /**
     * This method gets the section number
     * @return sectionNum, the section number
     */
    public int getSectNum(){
        return this.sectionNum;
    }

    /**
     * this gets the capacity of the class
     * @return MAX_SIZE, size of the class
     */
    public int getCapacity(){
        return this.capacity;
    }

    @Override
    public String toString() {
        return getDept() + getCourseNum() + "-"+getSectNum();
    }

    /**
     * Overrided the equals class to make my own to compare the strings
     * @param obj, a object
     * @return isEqual, true if they are equal or false if they are not equal
     */
    @Override
    public boolean equals(Object obj) {
        String dept = "";
        String holder = "";
        int courseNum;
        int sectionNum;
        boolean isEqual = true;
        Course c2 = null;

        if(obj instanceof Course){
            c2 = (Course)obj;
        }

        if(this.getCourseNum() != c2.getCourseNum()){
            isEqual = false;
        }
        if(this.getSectNum() != c2.getSectNum()){
            isEqual = false;
        }

       for(int i = 0; i <= 3; i++){
            if(this.getDept().charAt(i) != c2.getDept().charAt(i)){
                isEqual = false;
            }
        }

        return isEqual;
    }

    @Override
    public int compareTo(Course holder) {
        if(dept.compareTo(holder.getDept()) == 0){
            if(courseNum == holder.getCourseNum()){
                return sectionNum - holder.getSectNum();
            }else{
                return courseNum - holder.getCourseNum();
            }
        }
        return dept.compareTo(holder.getDept());
    }




}


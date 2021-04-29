import java.util.*;
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
public class LabCourse extends Course{
    /**
     * MAX_SEATS, the max amount of seats allowed
     * arraySize, the size of the array
     * labSessions, an array of lab sections
     * sectNum, the section number
     */
    final int MAX_SEATS = 20;
    int arraySize = 4;
    Course labSessions[] = new Course[arraySize];
    int sectNum = 100;

    /**
     * This constructor sets up the array list
     * @param dept, the department of the class
     * @param courseNum, the course number of the class
     * @param sectionNum, the section number of the class
     * @param capacity, the capacity of the lecture
     */
    public LabCourse(String dept, int courseNum, int sectionNum, int capacity){
        super(dept,courseNum,sectionNum,capacity);

        //sets the array size to the total amount of lab sessions needed
        this.arraySize = super.getCapacity() / capacity;
        if(getCapacity() % capacity != 0){
            this.arraySize += 1;
        }
        this.arraySize += 1;

        //adds new lab sessions into the labSessions array
        for(int i = 0; i < labSessions.length; i++){
            this.sectNum = 100+ i;
            this.labSessions[i] = new Course(super.getDept(),super.getCourseNum(),this.sectNum, MAX_SEATS);
        }
    }

    /**
     * returns the array of lab sessions
     * @return labSessions, all the lab sessions
     */
    public Course[] getLabSessions(){
        return this.labSessions;
    }

    @Override
    public String toString() {
        String printer = "";
        printer += super.toString() +"\n    ";
        for(int i = 0; i < labSessions.length; i++){
            printer += labSessions[i].toString()+"\n    ";
        }
        return printer;
    }
}

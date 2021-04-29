import java.util.ArrayList;
import java.util.Collections;
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
public class CourseCatalog {
    private ArrayList<Course> courseCatalog;

    /**
     * This constructor allocates space for the arraylist
     */
    public CourseCatalog(){
        this.courseCatalog = new  ArrayList<Course>();
    }

    /**
     * This private method is used to check if a course already
     * exists in the arraylist
     * @param course, the course you are checking if it exists
     * @return true, if the course already exists in the arraylist, false if
     * it doesn't exist in the arraylist
     */
    private boolean courseExists(Course course){
        for(Course courseList : courseCatalog){
            if(course.equals(courseList)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method gives you all the courses in an arraylist
     * @return this.courseCatalog, all the courses in the course in the arraylist
     */
    public ArrayList<Course> getAllCourses(){
        return courseCatalog;
    }

    /**
     * This method checks if there is a course is in the arraylist or not
     * and if it's not, then it adds it
     * @param newCourse, the course that will be added
     * @return true, if the course is added. False if the course is not added
     */
    public boolean addCourse(Course newCourse){
        if(!courseExists(newCourse)){
            courseCatalog.add(newCourse);
            Collections.sort(courseCatalog);
            return true;
        }else {
            return false;
        }
    }

    /**
     * This method checks if a course is in the arraylist and then removes it
     * @param course, the course that would be liked to be removed
     * @return true if the course is removed. false if the course is not removed
     */
    public boolean removeCourse(Course course){
        if(courseExists(course)){
            courseCatalog.remove(course);
            return true;
        }
        return false;
    }

    /**
     * @return prints out all the courses in the catalog
     */
    public String printCourseCatalog()
    {
        String printer = "";
        for (Course course : courseCatalog) {
            printer += course.toString();
        }
        return printer;
    }
}

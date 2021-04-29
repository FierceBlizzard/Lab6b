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
    private int MAX_SIZE;

    public Course(String dept, int courseNum, int sectionNum, int MAX_SIZE){
        this.dept = dept;
        this.courseNum = courseNum;
        this.sectionNum = sectionNum;
        this.MAX_SIZE = MAX_SIZE;
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
        return this.MAX_SIZE;
    }

    @Override
    public String toString() {
        return this.dept.toUpperCase() + this.courseNum + "-"+this.sectionNum;
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

    /**
     * Overrided the compareTo to have my owne custom for this class
     * @param o, a Course object
     * @return 0 if it's equal, -1 if the second string is larger and not the same, and 1 if
     * the first string is larger then the second and not equal
     */
    @Override
    public int compareTo(Course o) {
        int str1 = 0;
        int str2 = 0;
        String holder;

        for(int i = 0; i <= o.toString().length()-1; i++){
            str2 += o.toString().charAt(i);
        }

        for(int i = 0; i <= getDept().length()-1; i++){
            str1 += getDept().charAt(i);
        }

        holder = Integer.toString(getSectNum());
        System.out.println("Holder: "+holder);
        str1 += holder.charAt(0);
        str1 += holder.charAt(1);

        holder = Integer.toString(getCourseNum());
        System.out.println("Holder: "+holder);
        str1 += holder.charAt(0);
        str1 += holder.charAt(1);
        str1 += holder.charAt(2);
        str1 += 45;

        System.out.println();
        if(str1 > str2){
            return 1;
        }else if(str1 < str2){
            return -1;
        }
        return 0;
    }


}


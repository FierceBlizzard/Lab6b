import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @org.junit.Test
    public void test_Course() {
        System.out.println("Testing Course getters");
        Course engl00_10 = new Course("engl",100,10,80);
        Course math243_10 = new Course("Math",243,10,100);
        Course math243_11 = new Course("mAth",243,11,100);

        assertEquals("ENGL",engl00_10.getDept());
        assertEquals("MATH",math243_10.getDept());
        assertEquals("MATH",math243_11.getDept());

        assertEquals(10, engl00_10.getSectNum());
        assertEquals(100,engl00_10.getCourseNum());
        assertEquals(80, engl00_10.getCapacity());


    }


    @Test
    public void test_toString() {
    System.out.println("Testing Course toString");
    Course engl220_10 = new Course("engl",220,10,60);
    assertEquals(engl220_10.toString().equals("ENGL220-10".toString() ),true);
    }


    @Test
    public void test_equals() {
    System.out.println("Testing Course equals");
    Course engl00_10 = new Course("engl",100,10,80);
    Course engl00_10dup = new Course("engl",100,10,80);
    Course engl00_12 = new Course("engl",100,12,80);
    Course math243_10 = new Course("Math",243,10,100);

    assertFalse(engl00_10.equals(engl00_12));
    assertFalse(engl00_10.equals(math243_10));
    assertTrue(engl00_10.equals(engl00_10dup));

    }


    @Test
    public void test_compareTo() {
    System.out.println("Testing Course compareTo");
    Course engl00_10 = new Course("engl",100,10,80);
    Course engl00_10dup = new Course("engl",100,10,80);
    Course engl00_12 = new Course("engl",100,12,80);
    Course engl220_10 = new Course("engl",220,10,60);
    Course math243_10 = new Course("Math",243,10,100);

    assertTrue(engl00_10.compareTo(engl00_12)< 0);
    assertTrue(engl00_10.compareTo(math243_10)< 0);
    assertEquals(0,engl00_10.compareTo(engl00_10dup));
    assertTrue(engl220_10.compareTo(engl00_10)> 0 );
    assertTrue(engl00_12.compareTo(engl00_10)> 0 );
    }


/*
    @Test
    public void test_LabCourse() {
     System.out.println("Testing LabCourse");
     LabCourse cisc181_10 = new LabCourse("cisc", 181, 10, 80);

     Course[] labs = cisc181_10.getLabSessions();
     // Testing number of lab sessions
     assertEquals(labs.length == 4, true);
     //testing values of lab session objects
     for (int i = 0; i < labs.length; i++) {
      assertTrue(labs[i].getDept().equals(cisc181_10.getDept()));
      assertTrue(labs[i].getCourseNum() == cisc181_10.getCourseNum());
      assertTrue(labs[i].getSectNum() == 100 + i);
      assertEquals( 20,labs[i].getCapacity());
     }

    LabCourse cisc220_12 = new LabCourse("cisc", 220, 12, 65);

    labs = cisc220_12.getLabSessions();
    // Testing number of lab sessions
    System.out.println(labs.length);
    assertEquals(labs.length == 4, true);
    //testing values of lab session objects
    for (int i = 0; i < labs.length; i++) {
     assertTrue(labs[i].getDept().equals(cisc220_12.getDept()));
     assertTrue(labs[i].getCourseNum() == cisc220_12.getCourseNum());
     assertTrue(labs[i].getSectNum() == 100 + i);
     assertEquals(20,labs[i].getCapacity());
    }
 }


 @Test
 public void test_LabCourse_toString() {
 System.out.println("Testing LabCourse toString");
 LabCourse cisc181_10 = new LabCourse("cisc",181,10,80);

 Course[] labs = cisc181_10.getLabSessions();
 String courseString = "CISC181-10\n    CISC181-100\n    CISC181-101\n    CISC181-102\n    CISC181-103";
 assertTrue(cisc181_10.toString().trim().equals(courseString.toString()));

 }

@Test
 public void test_CourseCatalogAdd() {
 System.out.println("Testing CourseCatalog Add");
 CourseCatalog UDCatalog = new CourseCatalog();

 Course engl00_10 = new Course("engl",100,10,80);
 UDCatalog.addCourse(engl00_10);

 LabCourse cisc181_12 = new LabCourse("cisc",181,12,80);
 UDCatalog.addCourse(cisc181_12);

 Course math243_10 = new Course("Math",243,10,100);
 UDCatalog.addCourse(math243_10);


 Course math243_11 = new Course("mAth",243,11,100);
 UDCatalog.addCourse(math243_11);

 LabCourse cisc181_10 = new LabCourse("cisc",181,10,80);
 UDCatalog.addCourse(cisc181_10);

 LabCourse cisc220_12 = new LabCourse("cisc",220,12,65);
 UDCatalog.addCourse(cisc220_12);

 Course engl01_10 = new Course("engl",101,10,80);
 UDCatalog.addCourse(engl01_10);



 //check that courses are in sorted order

 ArrayList<Course> compareCatalog = UDCatalog.getAllCourses();

 assertTrue(compareCatalog.get(0).equals(cisc181_10));
 assertTrue(compareCatalog.get(1).equals(cisc181_12));
 assertTrue(compareCatalog.get(2).equals(cisc220_12));
 assertTrue(compareCatalog.get(3).equals(engl00_10));
 assertTrue(compareCatalog.get(4).equals(engl01_10));
 assertTrue(compareCatalog.get(5).equals( math243_10));
 assertTrue(compareCatalog.get(6).equals(math243_11));

 //try adding a course that already exists
 Course engl01_10dup = new Course("engl",101,10,80);
 assertFalse(UDCatalog.addCourse(engl01_10dup));

 //test remove course

 UDCatalog.removeCourse(math243_10);
 compareCatalog = UDCatalog.getAllCourses();

 assertTrue(compareCatalog.get(0).equals(cisc181_10));
 assertTrue(compareCatalog.get(1).equals(cisc181_12));
 assertTrue(compareCatalog.get(2).equals(cisc220_12));
 assertTrue(compareCatalog.get(3).equals(engl00_10));
 assertTrue(compareCatalog.get(4).equals(engl01_10));
 assertTrue(compareCatalog.get(5).equals(math243_11));

 // print the catalog
 UDCatalog.printCourseCatalog();

 }*/

}

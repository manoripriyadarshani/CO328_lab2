package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
        System.out.println("A new test is starting.");
        register = new StudentRegister();
    }

    @After
    public void finishTest()
    {
        System.out.println("Test finished");
    }

    @BeforeClass
    public  static void beforeClass()
    {
        System.out.println("Evaluating test cases in StudentRegisterTest.java");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("All tests are done");
    }

   @Test
    public void testAddStudent()
   {
       register = new StudentRegister();
       try
       {
           register.addStudent(new Student(2, "nimal", "kumara"));
           register.addStudent(new Student(5, "fawzan", "mohomad"));
       }
       catch (Exception ex)
       {
           Assert.fail("Adding student failed");
       }
       System.out.println("Testing add student method");

       Student student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

    @Test
    public void testAddStudentTwice()
    {    // Implement your test code here. Adding a student with same registration number twice should generate an exception.


        try
        {
            register.addStudent(new Student(7, "manori", "priyadarshani"));
            register.addStudent(new Student(8, "nimali", "seuwandi"));
            register.addStudent(new Student(7, "manori", "priyadarshani"));
        }

        catch (Exception ex)
        {
            System.out.println("student register does not allow to insert doublicate");
            // Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
            //catch {} part running means exeption throws in the add student twice
        }

        // if the stuRegister allow to insert doublicates numbers shoud have 7,8,7  But where it includes only 7,8  .
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(7);
        expected.add(8);
        Assert.assertTrue(numbers.equals(expected));

    }

    @Test
    public void testRemoveStudent()
    {
        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Add student failed");
        }
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {
        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        Assert.assertTrue(numbers.equals(expected));
    }

    @Test
    public void testFindStuByName()
    {
        try
        {   register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }

        //where the shearching can done by Last name or firstname
        ArrayList<Student> studentnames  = register.findStudentsByName("tharaka");
        String expected ="tharaka";
        String actualFname= studentnames.get(0).getFirstName();
        String actualLname= studentnames.get(0).getLastName();

        if(actualFname=="tharaka")
            Assert.assertTrue(actualFname.equals(expected));

        else if(actualLname=="tharaka")
            Assert.assertTrue(actualLname.equals(expected));

    }


    @Test
    public void testReset()
    {

        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }

        register.reset();
        boolean actual=register.isEmpty();
        boolean expected=true;
        assertEquals(actual,expected);

    }

}

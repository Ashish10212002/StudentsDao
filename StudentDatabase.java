import java.sql.*;
import java.util.*;
public class StudentDatabase {
    public static void main(String[] args) {
         String url = "jdbc:mysql://localhost:3306/newdb";
         String user = "root";
         String password = "#@Ashish1021";
        try{
    Connection conn = DriverManager.getConnection(url,user,password);
    StudentsDao dao = new StudentsDao(conn);

    // Add a new student
    //  for (int i = 1; i <= 500; i++) {
    //             String name = "Student" + i;
    //             String email = "student" + i + "@example.com";
    //             Students s = new Students(i, name, email);
    //             dao.addUser(s);
    //         }
             // Fetch and print first 10 students to check
            List<Students> students = dao.getAllStudent();
            for (int i = 0; i < 10; i++) {
                Students s = students.get(i);
                System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
            }

             // Get student by ID
            Students fetched = dao.getStudentById(200);
            if (fetched != null) {
                System.out.println("Student: " + fetched.getName() + " - " + fetched.getEmail());
            }

            // // Get all students
            // List<Students> student = dao.getAllStudent();
            // for (Students s : student) {
            //     System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
            // }
        }
      catch(Exception e){
        e.printStackTrace();
      }
}
}

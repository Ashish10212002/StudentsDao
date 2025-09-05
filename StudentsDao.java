import java.sql.*;
import java.util.*; 

public class StudentsDao {
    private Connection conn;

    public StudentsDao(Connection conn){
     this.conn = conn;

  
    } 
        // Insert Student
      public void addUser(Students student){
    try{
     String sql = "insert into Student(id,name,email) values(?,?,?)";
     PreparedStatement psstmt = conn.prepareStatement(sql);
     psstmt.setInt(1,student.getId());
     psstmt.setString(2, student.getName());
     psstmt.setString(3, student.getEmail());
     psstmt.executeUpdate();
     System.out.println(" 👍 Student added");

    }
    catch(Exception e){
        e.printStackTrace();
    }
        
      }

        // Fetch User by ID
        public Students getStudentById(int id){
            Students student = null;
            try{
            String sql = "select * from Student where id=?";
            PreparedStatement psstmt = conn.prepareStatement(sql);
            psstmt.setInt(1, id);
            ResultSet rs = psstmt.executeQuery();

            if(rs.next()){
                student = new Students(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // Fetch All Users

    public List<Students> getAllStudent(){
        List <Students> list = new ArrayList<>();
        try{
          String sql = "select * from student";
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql);

          while(rs.next()){
            list.add(new Students(rs.getInt("id"),rs.getString("name"),
             rs.getString("email")));

          }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }
    
}

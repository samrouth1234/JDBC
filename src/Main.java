import Model.Student;
import org.postgresql.ds.PGSimpleDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // create object is local
    private static  JdbcImp jdbcImp;
    private static Scanner scanner;
    public static void main(String[] args) {

        jdbcImp = new JdbcImp();
        scanner = new Scanner(System.in);
        Student student =new Student();
    /**
        System.out.print("Enter name :");
        student.setName(scanner.nextLine());
        System.out.print("Enter sex :");
        student.setSex(scanner.nextLine());
        System.out.print("Enter Object :");
        student.setObject(scanner.nextLine());

        // Insert SQL
        InsertSQLStudent(student);
     */

    /**
        // Deleted SQL
        System.out.print("Enter id for Deleted :");
        student.setId(scanner.nextInt());
        DeletedSQL(student);

     */
        System.out.print("Enter ID Update :");
        student.setId(scanner.nextInt());

        System.out.print("Enter name :");
        student.setName(scanner.nextLine());
        scanner.nextLine();
        System.out.print("Enter sex :");
        student.setSex(scanner.nextLine());
        System.out.print("Enter Object :");
        student.setObject(scanner.nextLine());

        // Update SQL
        UpdateSql(student);

        // select SQL
        selectSQLStudent();

    }
    // Select table Student
    private static void selectSQLStudent(){
        try (Connection con = jdbcImp.dataSource().getConnection()){
            // print merl schema
            System.out.println(con.getSchema());
            // 1. Create statement SQL
            String selectSql ="SELECT * FROM student";
            PreparedStatement statement = con.prepareStatement(selectSql);
            // 2. Execute SQL statement
            ResultSet resultSet =statement.executeQuery();
            // 3.Process Result with ResultSet
            List<Student> students = new ArrayList<>();
            while (resultSet.next()){
                // create object of Student
                Integer id    = resultSet.getInt("id");
                String name   = resultSet.getString("name");
                String sex    = resultSet.getString("sex");
                String object = resultSet.getString("object");
                students.add(new Student(id,name,sex,object));
            }
            //
            students.stream().forEach(System.out::println);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    // Insert into table Student

    /**
     * Static Insert SQl
    private static void InsertSQLStudent() {
        try (Connection con = jdbcImp.dataSource().getConnection()) {
            String insertSql = "INSERT INTO student (id,name, sex, object) VALUES (?,?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

            // create Set Element
            statement.setInt(1,3);
            statement.setString(2, "Dara");
            statement.setString(3, "M");
            statement.setString(4, "C programming");

            // Execute Statement SQL
            int count = statement.executeUpdate();
            System.out.println(count);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     */


    // Insert SQL
    private static void InsertSQLStudent(Student student) {
        try (Connection con = jdbcImp.dataSource().getConnection()) {
            String insertSql = "INSERT INTO student (name, sex, object) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(insertSql);

            // create Set Element
            statement.setString(1,student.getName());
            statement.setString(2, student.getSex());
            statement.setString(3, student.getObject());

            // Execute Statement SQL
            int count = statement.executeUpdate();
            System.out.println(count);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Deleted SQL
    private  static  void DeletedSQL(Student student){
        try (Connection con = jdbcImp.dataSource().getConnection()) {
            String deleteSql = "DELETE FROM student WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(deleteSql);

            statement.setInt(1,student.getId());

            int count = statement.executeUpdate();
            System.out.println(count + " row(s) deleted.");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


    // Update SQL
    private static void UpdateSql(Student student){
        try(Connection con = jdbcImp.dataSource().getConnection()) {
            String UpdateSql = "UPDATE student SET name = ?, sex = ?, object = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(UpdateSql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getSex());
            statement.setString(3, student.getObject());
            statement.setInt(4, student.getId()); // Assuming getId() returns the student's ID


            // Execute the update operation
            int rowCount = statement.executeUpdate();
            System.out.println(rowCount + " row(s) updated.");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
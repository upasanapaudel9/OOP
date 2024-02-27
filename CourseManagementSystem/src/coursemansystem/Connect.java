package coursemansystem;
// Importing Package 
import java.sql.*;

// Connect class
public class Connect{
	Connection c;
    public Statement s;
    // Constructor
    public Connect() throws SQLException {
    	// Connect and create database
        try{
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "");
            s = c.createStatement();
            s.executeUpdate("Create Database if not exists course_management_system");

        }catch (ClassNotFoundException e){
            e.printStackTrace();

        }
        String url = "jdbc:mysql://localhost:3306/course_management_system";
        c = DriverManager.getConnection(url, "root", "");
        s = c.createStatement();
        // Create Required Table
        s.executeUpdate("Create Table if not exists Admin(Uname varchar(50),pass varchar(150),Role varchar(50))");
        s.executeUpdate("Create Table if not exists Courses(courseName varchar(100))");
        s.executeUpdate("Create Table if not exists Module(moduleCode varchar(100), moduleName varchar(200), courseName varchar(100), level int(5), Type varchar(255) DEFAULT 'Mandatory')");
        ResultSet rs = s.executeQuery("SELECT * FROM Admin WHERE Uname!='"+"' ");
        rs.getMetaData();
        if (!rs.next()) {
        	// Dummy data
            s.executeUpdate("INSERT INTO Admin(Uname, pass, Role) VALUES('admin','admin', 'Admin')");
            s.executeUpdate("INSERT INTO Courses(courseName) VALUES ('BIT')");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level) VALUES ('L41','Academics','BIT', 4)");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level) VALUES ('L42','Intro to Programming','BIT', 4)");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level) VALUES ('L51','ISA','BIT', 5)");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level) VALUES ('L52','Computational Mathematics','BIT', 5)");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level) VALUES ('L6M1','Concept and Tech of AI','BIT', 6)");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level) VALUES ('L6M2','Complex System','BIT', 6)");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level, Type) VALUES ('L6O1','Big Data','BIT', 6,'Optional')");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level, Type) VALUES ('L6O2','Project and Professionalism','BIT', 6, 'Optional')");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level, Type) VALUES ('L6O3','High Performance Computing','BIT', 6, 'Optional')");
            s.executeUpdate("INSERT INTO Module (moduleCode, moduleName, courseName, level, Type) VALUES ('L6O4','Artificial Intelligence and Machine Learning','BIT', 6, 'Optional')");
        }
        // Create table
        s.executeUpdate("Create Table if not exists StudentLogin(name varchar(100),email varchar(150), username varchar(100), pass varchar(50), role varchar(50), dob varchar(10), course varchar(10), level int(5),module1 varchar(200), module2 varchar(200),  PRIMARY KEY (username))");
        s.executeUpdate("Create Table if not exists TeacherLogin(No int NOT NULL AUTO_INCREMENT,name varchar(100),email varchar(150), username varchar(100), pass varchar(50), role varchar(50), dob varchar(10), course varchar(10), level int(5),PRIMARY KEY (No))");
        s.executeUpdate("Create Table if not exists LoginCheck(No int NOT NULL AUTO_INCREMENT, username varchar(100), role varchar(200),PRIMARY KEY (No))");
        s.executeUpdate("Create Table if not exists Marks(username varchar(100), moduleName varchar(200), mark varchar(50), level varchar(100), course varchar (100))");
    }
    
}
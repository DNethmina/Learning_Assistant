package Signup;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class signupModel  {
    protected String UserID;
    protected String Username;
    protected int age;
    protected String gmail;
    protected String address;
    //protected boolean check;
    protected int contactNumber;
    protected int Grade ;
    protected  String Gender;

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    protected String pw ;

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

//    public String getCheck() {
//        return "yes";
//    }
//
//    public void setCheck(boolean check) {
//        this.check = check;
//    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

//    public void setTeacher(boolean selected) {
//    }
//
//    public String getTeacher() {
//        return "Yes";
//    }

    public void Addperson() throws SQLException {
        Connection connection = null;
        Statement  statement = null;

        if(getAge() < 18 && getGrade() < 12){
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                String conPURL = "jdbc:mysql://localhost:3306/learnung_assistent2";
                connection = DriverManager.getConnection(conPURL, "root", "");
                statement = connection.createStatement();

                String sql = "INSERT INTO student(SID,Sname,Age,Grade,Gmail,Address,Gender,Contact) VALUES ("
                        + "'" + UserID + "'," + "'" + Username + "'," + "'" + age + "'," + "'" + Grade + "'," + "'" + gmail + "',"
                        + "'" + address + "'," + "'" + Gender + "'," + "'" + contactNumber + "')";

                System.out.println(sql);
                int status = statement.executeUpdate(sql);
                if (status > 0) {
                    System.out.println("Person details successfully");
                }
            }
            catch (SQLException ex){
                System.out.println("Error"+ex);

            }
            finally {
                if (statement != null){
                    statement.close();
                }
                if (connection != null){
                    connection.close();
                }
            }
        }
        else if (getAge() > 18 && getGrade() < 12) {

            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                String conPURL = "jdbc:mysql://localhost:3306/learnung_assistent2";
                connection = DriverManager.getConnection(conPURL, "root", "");
                statement = connection.createStatement();

                String sql = "INSERT INTO teacher(TID,Tname,Age,Grade,Gmail,Address,Gender,Contact,password) VALUES ("
                        + "'" + UserID + "'," + "'" + Username + "'," + "'" + age + "'," + "'" + Grade + "'," + "'" + gmail + "',"
                        + "'" + address + "'," + "'" + Gender + "'," + "'" + contactNumber + "'," + "'" +pw+ "')";

                System.out.println(sql);
                int status = statement.executeUpdate(sql);
                if (status > 0) {
                    System.out.println("Person details successfully");
                }
            }
            catch (SQLException ex){
                System.out.println("Error"+ex);

            }
            finally {
                if (statement != null){
                    statement.close();
                }
                if (connection != null){
                    connection.close();
                }
            }

        }
    }

}


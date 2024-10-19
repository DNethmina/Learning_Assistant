package Techer;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Teachermodel {

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }


    public String getTeachertopic(String selectedItem) {
        return teachertopic;
    }

    public void setTeachertopic(String teachertopic) {
        this.teachertopic = teachertopic;
    }

    public String getTeacherQ() {
        return teacherQ;
    }

    public void setTeacherQ(String teacherQ) {
        this.teacherQ = teacherQ;
    }

    public String getTeachermark() {
        return teachermark;
    }

    public void setTeachermark(String teachermark) {
        this.teachermark = teachermark;
    }

    public String getTeacheranswer() {
        return teacheranswer;
    }

    public void setTeacheranswer(String teacheranswer) {
        this.teacheranswer = teacheranswer;
    }


    public String getTechergrade(String selectedItem) {
        return techergrade;
    }

    public void setTechergrade(String techergrade) {
        this.techergrade = techergrade;
    }

    protected String teacherID;
    protected String teachername;
    protected String techergrade;
    protected String teachertopic;
    protected String teacherQ;
    protected String teachermark;
    protected String teacheranswer;

    public void AddQuection() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String conURL = "jdbc:mysql://localhost:3306/learnung_assistent2";
            connection = DriverManager.getConnection(conURL, "root", "");
            statement = connection.createStatement();

            String sql = "INSERT INTO question(Question,Grade,Topic,RigtAnswer,Mark,TID) VALUES("
                    + "'" + teacherQ + "'," + "'" + techergrade  + "'," + "'" + teachertopic + "',"
                    + "'" + teacheranswer + "'," + "'" + teachermark + "'," + "'" + teacherID + "')";

            System.out.println(sql);
            int status = statement.executeUpdate(sql);
            if (status > 0) {
                System.out.println("Record inserted successfully");
            }

        }
        catch (SQLException ex){

            System.out.println("Error"+ ex);
        }
        finally {
            if(statement != null)
            {
                statement.close();
            }
            if(connection != null)
            {
                connection.close();
            }
        }
    }





}

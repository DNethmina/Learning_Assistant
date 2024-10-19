package Login;
import Techer.*;
import javax.swing.*;
import java.sql.*;
import java.util.Objects;

public class Loginmodel {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected String username ;
    protected String password ;

    public void log() throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String conPURL = "jdbc:mysql://localhost:3306/learnung_assistent2";
            connection = DriverManager.getConnection(conPURL, "root", "");
            statement = connection.createStatement();


            String sql = "SELECT * FROM teacher WHERE TID='" + getUsername() + "' AND password='" + getPassword() + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

               // System.out.println("Successfully login");

                Teacheviwe teacheviwe = new Teacheviwe();
                Teachermodel teachermodel = new Teachermodel();
                TeacherController teacherController = new TeacherController(teacheviwe, teachermodel);
                teacheviwe.setVisible(true);
                Loginviwe loginviwe = new Loginviwe();
                JOptionPane.showMessageDialog(loginviwe,"Successfully login");
                loginviwe.setVisible(false);
            } else {
                Loginviwe loginviwe = new Loginviwe();
                JOptionPane.showMessageDialog(loginviwe,"Wrong login");
                loginviwe.dispose();
//                System.out.println("Wrong login");
            }

        } catch (Exception e) {
            System.out.println("Error"+e);
        } finally {

            if (resultSet != null)
                try
                {
                    resultSet.close();
                }
                catch (SQLException e)
                {
                    System.out.println("Error"+e);
                }
            if (statement != null)
                try
                {
                    statement.close();
                }
                catch (SQLException e)
                {
                    System.out.println("Error"+e);
                }
            if (connection != null)
                try
                { connection.close();
                }
                catch (SQLException e)
                {
                    System.out.println("Error"+e);
                }
        }
    }



}

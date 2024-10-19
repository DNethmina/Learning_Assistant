package Student;

import java.sql.*;

public class Studentmodel {

    protected String SIDQ;
    protected String TIDQ;
    protected String GradeQ;
    protected String topicQ;
    protected int Question1;
    protected String Question2;
    protected String Question3;
    protected String Answer1;
    protected String Answer2;
    protected String Answer3;



    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String answer2) {
        Answer2 = answer2;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String answer1) {
        Answer1 = answer1;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(String answer3) {
        Answer3 = answer3;
    }



    public String getQuestion2() {
        return Question2;
    }

    public void setQuestion2(String question2) {
        Question2 = question2;
    }

    public String getSIDQ() {
        return SIDQ;
    }

    public void setSIDQ(String SIDQ) {
        this.SIDQ = SIDQ;
    }

    public String getTIDQ() {
        return TIDQ;
    }

    public void setTIDQ(String name) {
        TIDQ = name;
    }

    public String getGradeQ() {
        return GradeQ;
    }

    public void setGradeQ(String gradeQ) {
        GradeQ = gradeQ;
    }

    public String getTopicQ() {
        return topicQ;
    }

    public void setTopicQ(String topicQ) {
        this.topicQ = topicQ;
    }

    public int getQuestion1() {
        return Question1;
    }

    public void setQuestion1(int question1) {
        Question1 = question1;
    }

    public String getQuestion3() {
        return Question3;
    }

    public void setQuestion3(String question3) {
        Question3 = question3;
    }

    public void AnswerQuestion() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String conQURL ="jdbc:mysql://localhost:3306/learnung_assistent2";
            connection = DriverManager.getConnection(conQURL,"root","");
            statement = connection.createStatement();



            String sql ="INSERT INTO questionansewer(Ansewer,SID,QID) VALUES ("
                    + "'" + Answer1 + "'," + "'" + SIDQ + "'," + "'" + Question1 + "')";
            System.out.println(sql);


            int status = statement.executeUpdate(sql);
            if (status > 0){
                System.out.println("Record inserted successfully");
            }

        }
        catch (SQLException ex){
            System.out.println("Error"+ ex);
        }
        finally {
            if (statement != null)
            {
                statement.close();
            }
            if (connection != null)
            {
                connection.close();
            }
        }
    }
    public ResultSet showQuestion(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String conQURL = "jdbc:mysql://localhost:3306/learnung_assistent2";
            connection = DriverManager.getConnection(conQURL, "root", "");
            statement = connection.createStatement();


            String sql = "Select Question,Mark,QID,RigtAnswer from question where Topic='" + getTopicQ() + "' and Grade='" + getGradeQ() + "' and TID='"+getTIDQ()+"'";
            resultSet = statement.executeQuery(sql);

        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return resultSet;
    }




}

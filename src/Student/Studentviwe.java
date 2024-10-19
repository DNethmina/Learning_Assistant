package Student;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Studentviwe extends JFrame {

    private ResultSet resultSet;
    private JPanel stpannel = new JPanel();
    private JLabel sttitle = new JLabel();
    private JLabel sid = new JLabel();
    private JLabel TID = new JLabel();
    private JLabel stopic = new JLabel();
    private JTextField sidtxt = new JTextField();
    private JLabel stgrade = new JLabel();
    private JTextField snametxt = new JTextField();
    private JButton show = new JButton();
    private JButton nextButton = new JButton();
    private JComboBox<String> stCtopic = new JComboBox<>();
    private JComboBox<String> stgradeCombo = new JComboBox<>();

    private JPanel questionsPanel = new JPanel();

    private String[] answers;
    private String[] questions;
    private int[] questionIDs;
    private JTextField[] answerFields;

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public int[] getQuestionIDs() {
        return questionIDs;
    }

    public void setQuestionIDs(int[] questionIDs) {
        this.questionIDs = questionIDs;
    }

    public JComboBox<String> getStCtopic() {
        return stCtopic;
    }

    public JComboBox<String> getStgradeCombo() {
        return stgradeCombo;
    }

    public JTextField getSidtxt() {
        return sidtxt;
    }

    public JTextField getSnametxt() {
        return snametxt;
    }

    public JButton getShow() {
        return show;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
        updateQuestions();
    }

    private void updateQuestions() {
        questionsPanel.removeAll();
        int QPosition = 10;
        final int MAX_QUESTIONS = 3;
        JTextField[] answerFields = new JTextField[MAX_QUESTIONS];
        questions = new String[MAX_QUESTIONS];
        questionIDs = new int[MAX_QUESTIONS];

        try {
            if (resultSet != null) {
                boolean hasQuestions = false;
                int questionIndex = 0;

                while (resultSet.next() && questionIndex < MAX_QUESTIONS) {
                    hasQuestions = true;


                    int qID = resultSet.getInt("QID");
                    String questionText = resultSet.getString("Question");


                    questionIDs[questionIndex] = qID;
                    questions[questionIndex] = questionText;

                    JLabel questionLabel = new JLabel(questionText);
                    questionLabel.setBounds(10, QPosition, 500, 50);
                    questionLabel.setForeground(Color.BLUE);
                    questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
                    questionsPanel.add(questionLabel);

                    JTextField answerField = new JTextField();
                    answerField.setBounds(10, QPosition + 50, 100, 25);
                    questionsPanel.add(answerField);

                    answerFields[questionIndex] = answerField;

                    QPosition += 80;
                    questionIndex++;
                }

                if (!hasQuestions) {
                    JLabel noQuestions = new JLabel("No questions available.");
                    System.out.println("No questions available.");
                    noQuestions.setBounds(10, QPosition, 300, 25);
                    questionsPanel.add(noQuestions);
                }
            } else {
                JLabel noQuestions = new JLabel("Result set is null.");
                System.out.println("Result set is null.");
                noQuestions.setBounds(10, QPosition, 300, 25);
                questionsPanel.add(noQuestions);
            }


            this.answerFields = answerFields;

            questionsPanel.revalidate();
            questionsPanel.repaint();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JTextField[] getAnswerFields() {
        return answerFields;
    }


    public Studentviwe() throws SQLException {
        this.setSize(600, 700);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("StudentView");
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0x7E95EF));
        this.setVisible(true);
        initialized();
    }

    private void initialized() {
        stpannel.setLayout(null);
        stpannel.setBackground(new Color(0x7E95EF));

        sttitle.setText("LEARNING ASSISTANT");
        sttitle.setForeground(Color.BLUE);
        sttitle.setFont(new Font("Arial", Font.BOLD, 26));
        sttitle.setBounds(10, 20, 300, 25);
        stpannel.add(sttitle);

        sid.setText("Enter Your SID  :");
        sid.setBounds(10, 100, 150, 25);
        sid.setForeground(Color.BLUE);
        sid.setFont(new Font("Arial", Font.BOLD, 14));
        stpannel.add(sid);

        sidtxt.setBounds(150, 100, 300, 25);
        stpannel.add(sidtxt);

        TID.setText("Enter TID  :");
        TID.setBounds(10, 150, 150, 25);
        TID.setForeground(Color.BLUE);
        TID.setFont(new Font("Arial", Font.BOLD, 14));
        stpannel.add(TID);

        snametxt.setBounds(150, 150, 300, 25);
        stpannel.add(snametxt);

        stgrade.setText("Enter Grade  :");
        stgrade.setBounds(10, 200, 150, 25);
        stgrade.setForeground(Color.BLUE);
        stgrade.setFont(new Font("Arial", Font.BOLD, 14));
        stpannel.add(stgrade);

        String[] grade = {"Grade 6", "Grade 7", "Grade 8", "Grade 9", "Grade 10", "Grade 11"};
        stgradeCombo = new JComboBox<>(grade);
        stgradeCombo.setBackground(new Color(0x7E95EF));
        JPanel disStG = new JPanel();
        disStG.setBounds(140, 200, 100, 25);
        disStG.setBackground(new Color(0x7E95EF));
        disStG.add(stgradeCombo);
        stpannel.add(disStG);

        stopic.setText("Enter Topic  :");
        stopic.setBounds(10, 250, 150, 25);
        stopic.setForeground(Color.BLUE);
        stopic.setFont(new Font("Arial", Font.BOLD, 14));
        stpannel.add(stopic);

        String[] topic = {"Area", "Addition", "Multiplication", "Deviation"};
        stCtopic = new JComboBox<>(topic);
        stCtopic.setBackground(new Color(0x7E95EF));
        JPanel sttopic = new JPanel();
        sttopic.setBounds(140, 250, 100, 25);
        sttopic.setBackground(new Color(0x7E95EF));
        sttopic.add(stCtopic);
        stpannel.add(sttopic);

        show.setText("Show Me Question");
        show.setForeground(Color.BLUE);
        show.setBackground(new Color(0x7E95EF));
        show.setBounds(295, 290, 160, 40);
        stpannel.add(show);

        questionsPanel.setLayout(null);
        questionsPanel.setBounds(10, 340, 560, 250);
        questionsPanel.setBackground(new Color(0x7E95EF));
        stpannel.add(questionsPanel);

        nextButton.setText("Next");
        nextButton.setForeground(Color.BLUE);
        nextButton.setBackground(new Color(0x7E95EF));
        nextButton.setBounds(295, 600, 160, 40);
        stpannel.add(nextButton);

        this.add(stpannel);
    }
}

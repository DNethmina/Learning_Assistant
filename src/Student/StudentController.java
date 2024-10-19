package Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class StudentController {

    private  Studentviwe viwe;
    private  Studentmodel model;


    public StudentController(Studentviwe viwe,Studentmodel model) {

        this.viwe = viwe;
        this.model = model;

        this.viwe.getNextButton().addActionListener(new nextbuttonListener());
        this.viwe.getShow().addActionListener(new showbuttonListener ());
    }

    class nextbuttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setSIDQ(viwe.getSidtxt().getText());
            model.setTIDQ(viwe.getSnametxt().getText());
            model.setGradeQ((String) viwe.getStgradeCombo().getSelectedItem());
            model.setTopicQ((String) viwe.getStCtopic().getSelectedItem());


            JTextField[] answerFields = viwe.getAnswerFields();
            for (int i = 0; i < 3; i++) {
                if (answerFields[i] != null) {
                    String answer = answerFields[i].getText();
                    model.setAnswer1(answer);
                    model.setQuestion1(viwe.getQuestionIDs()[i]);
                    try {
                        System.out.println("Answer: " + answer);
                        System.out.println("QID: " + viwe.getQuestionIDs()[i]);
                        model.AnswerQuestion();


                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }


            JOptionPane.showMessageDialog(viwe, "Data submitted successfully!");
            try {
                new Resultview(viwe.getSidtxt().getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    private class showbuttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setSIDQ(viwe.getSidtxt().getText());
            model.setTIDQ(viwe.getSnametxt().getText());
            model.setGradeQ((String) viwe.getStgradeCombo().getSelectedItem());
            model.setTopicQ((String) viwe.getStCtopic().getSelectedItem());
            viwe.setResultSet(model.showQuestion());


        }
    }
}

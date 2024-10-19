package Techer;

import TableDetails.QAnswerTable;
import TableDetails.QTable;
import TableDetails.STTable;
import TableDetails.Tableview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableOperation extends JFrame {

    JButton teacherDetails = new JButton();
    JButton studentDetails = new JButton();
    JButton QuestionDetails = new JButton();
    JButton QanswerDetails = new JButton();
    JLabel titleLabel = new JLabel();
    JPanel pannelquestion = new JPanel();
    public TableOperation() {

        this.setTitle("Details");
        this.setSize(500,500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initialized();
    }

    public void initialized (){

        pannelquestion.setLayout(null);
        pannelquestion.setBackground(new Color(0x7E95EF));

        titleLabel.setText("LEARNING ASSISTANT");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(10, 20, 300, 25);
        pannelquestion.add(titleLabel);

        teacherDetails.setText("TEACHER DETAILS");
        teacherDetails.setForeground(Color.BLUE);
        teacherDetails.setBackground(new Color(0x7E95EF));
        teacherDetails.setBounds(170, 100, 160, 40);
        pannelquestion.add(teacherDetails);

        studentDetails.setText("STUDENT DETAILS");
        studentDetails.setForeground(Color.BLUE);
        studentDetails.setBackground(new Color(0x7E95EF));
        studentDetails.setBounds(170, 180, 160, 40);
        pannelquestion.add(studentDetails);

        QuestionDetails.setText("QUESTION DETAILS");
        QuestionDetails.setForeground(Color.BLUE);
        QuestionDetails.setBackground(new Color(0x7E95EF));
        QuestionDetails.setBounds(170, 260, 160, 40);
        pannelquestion.add(QuestionDetails);

        QanswerDetails.setText("ANSWER DETAILS");
        QanswerDetails.setForeground(Color.BLUE);
        QanswerDetails.setBackground(new Color(0x7E95EF));
        QanswerDetails.setBounds(170, 340, 160, 40);
        pannelquestion.add(QanswerDetails);

        teacherDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tableview tableview = new Tableview();
                tableview.setVisible(true);
            }
        });

        studentDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                STTable stTable = new STTable();
                stTable.setVisible(true);
            }
        });

        QuestionDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QTable qTable = new QTable();
                qTable.setVisible(true);
            }
        });

        QanswerDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QAnswerTable qAnswerTable = new QAnswerTable();
                qAnswerTable.setVisible(true);
            }
        });

        this.add(pannelquestion);

    }
}

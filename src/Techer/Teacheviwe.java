package Techer;

import javax.swing.*;
import java.awt.*;

public class Teacheviwe extends JFrame
{
    JPanel techerpannel = new JPanel();
    JLabel techtitle = new JLabel();
    JLabel techID = new JLabel();
    JLabel techName = new JLabel();
    JLabel techgrade = new JLabel();
    JLabel techtopic = new JLabel();
    JLabel techQ1 = new JLabel();
    JLabel techM = new JLabel();
    JLabel techA = new JLabel();
    JLabel techBottom = new JLabel();
    JTextField techIDtxt = new JTextField(1);
    JTextField technametxt = new JTextField(1);
    //JTextField techQ1txt = new JTextField(4);
    JTextArea textAreaQ = new JTextArea(3,1);
    JTextField techMtxt = new JTextField(1);
    JTextField techAtxt = new JTextField(1);
    JComboBox<String> techGreadeCombo = new JComboBox<>();
    JComboBox<String> techCombotopic = new JComboBox<>();
    JButton tableview = new JButton();

    public JTextArea getTextAreaQ() {
        return textAreaQ;
    }

    public JComboBox<String> getTechGreadeCombo() {
        return techGreadeCombo;
    }

    public JComboBox<String> getTechCombotopic() {
        return techCombotopic;
    }


    public JButton getTsubmit() {
        return Tsubmit;
    }

    public void setTsubmit(JButton tsubmit) {
        Tsubmit = tsubmit;
    }

    public JLabel getTechID() {
        return techID;
    }

    public void setTechID(JLabel techID) {
        this.techID = techID;
    }

    public JLabel getTechName() {
        return techName;
    }

    public void setTechName(JLabel techName) {
        this.techName = techName;
    }

    public JLabel getTechgrade() {
        return techgrade;
    }

    public void setTechgrade(JLabel techgrade) {
        this.techgrade = techgrade;
    }

    public JLabel getTechtopic() {
        return techtopic;
    }

    public void setTechtopic(JLabel techtopic) {
        this.techtopic = techtopic;
    }

    public JLabel getTechQ1() {
        return techQ1;
    }

    public void setTechQ1(JLabel techQ1) {
        this.techQ1 = techQ1;
    }

    public JLabel getTechM() {
        return techM;
    }

    public void setTechM(JLabel techM) {
        this.techM = techM;
    }

    public JLabel getTechA() {
        return techA;
    }

    public void setTechA(JLabel techA) {
        this.techA = techA;
    }

    public JLabel getTechBottom() {
        return techBottom;
    }

    public void setTechBottom(JLabel techBottom) {
        this.techBottom = techBottom;
    }

    public JTextField getTechIDtxt() {
        return techIDtxt;
    }

    public void setTechIDtxt(JTextField techIDtxt) {
        this.techIDtxt = techIDtxt;
    }

    public JTextField getTechnametxt() {
        return technametxt;
    }

    public void setTechnametxt(JTextField technametxt) {
        this.technametxt = technametxt;
    }


    public JTextField getTechMtxt() {
        return techMtxt;
    }

    public void setTechMtxt(JTextField techMtxt) {
        this.techMtxt = techMtxt;
    }

    public JTextField getTechAtxt() {
        return techAtxt;
    }

    public void setTechAtxt(JTextField techAtxt) {
        this.techAtxt = techAtxt;
    }

    public JButton getTableview() {
        return tableview;
    }

    public void setTableview(JButton tableview) {
        this.tableview = tableview;
    }

    JButton Tsubmit = new JButton();




    public Teacheviwe() {
        this.setSize(500,650);
        this.setTitle("Teacher_view");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);
        initialized();
    }

    public JPanel getTecherpannel() {
        return techerpannel;
    }

    public void setTecherpannel(JPanel techerpannel) {
        this.techerpannel = techerpannel;
    }

    public JLabel getTechtitle() {
        return techtitle;
    }

    public void setTechtitle(JLabel techtitle) {
        this.techtitle = techtitle;
    }

    private void initialized() {



        techerpannel.setLayout(null);
        techerpannel.setBackground(new Color(0x7E95EF));

        techtitle.setText("TEACHER");
        techtitle.setForeground(Color.BLUE);
        techtitle.setFont(new Font("Arial", Font.BOLD, 24));
        techtitle.setBounds(10, 10, 300, 25);
        techtitle.setHorizontalAlignment(SwingConstants.LEFT);
        techerpannel.add(techtitle);

        techID.setText("Your TeacherID :");
        techID.setBounds(10,150,150,25);
        techID.setForeground(Color.BLUE);
        techID.setFont(new Font("Arial",Font.BOLD,14));
        techerpannel.add(techID);

        techIDtxt.setBounds(150,150,300,25);
        techerpannel.add(techIDtxt);

//        techName.setText("Enter Name  :");
//        techName.setBounds(10,150,150,25);
//        techName.setForeground(Color.BLUE);
//        techName.setFont(new Font("Arial",Font.BOLD,14));
//        techerpannel.add(techName);
//
//        technametxt.setBounds(150,150,300,25);
//        techerpannel.add(technametxt);

        techgrade.setText("Enter Grade  :");
        techgrade.setBounds(10,200,150,25);
        techgrade.setForeground(Color.BLUE);
        techgrade.setFont(new Font("Arial",Font.BOLD,14));
        techerpannel.add(techgrade);


        String [] grade = {"Grade 6","Grade 7","Grade 8","Grade 9","Grade 10","Grade 11"};
        techGreadeCombo = new JComboBox<>(grade);
        techGreadeCombo.setBackground(new Color(0x7E95EF));
        JPanel disCG = new JPanel();
        disCG.setBounds(140,200,100,25);
        disCG.setBackground(new Color(0x7E95EF));
        disCG.add(techGreadeCombo);
        techerpannel.add(disCG);

        techtopic.setText("Enter Topic  :");
        techtopic.setBounds(10,250,150,25);
        techtopic.setForeground(Color.BLUE);
        techtopic.setFont(new Font("Arial",Font.BOLD,14));
        techerpannel.add(techtopic);

        String [] topic = {"Area","Addition","Multiplication","Deviation"};
        techCombotopic = new JComboBox<>(topic);
        techCombotopic.setBackground(new Color(0x7E95EF));
        JPanel Distopic = new JPanel();
        Distopic.setBounds(150,250,100,25);
        Distopic.setBackground(new Color(0x7E95EF));
        Distopic.add(techCombotopic);
        techerpannel.add(Distopic);

        techQ1.setText("01.Enter Your Question");
        techQ1.setBounds(10,300,300,25);
        techQ1.setForeground(Color.BLUE);
        techQ1.setFont(new Font("Arial",Font.BOLD,14));
        techerpannel.add(techQ1);

        textAreaQ.setBounds(10,330,400,70);
        techerpannel.add(textAreaQ);

        techM.setText("02.Enter Your Marks");
        techM.setBounds(10,400,300,25);
        techM.setForeground(Color.BLUE);
        techM.setFont(new Font("Arial",Font.BOLD,14));
        techerpannel.add(techM);

        techMtxt.setBounds(10,425,80,25);
        techerpannel.add(techMtxt);

        techA.setText("03.Enter Your Answer");
        techA.setBounds(10,450,300,25);
        techA.setForeground(Color.BLUE);
        techA.setFont(new Font("Arial",Font.BOLD,14));
        techerpannel.add(techA);

        techAtxt.setBounds(10,475,80,25);
        techerpannel.add(techAtxt);


        Tsubmit.setText("Submit");
        Tsubmit.setForeground(Color.BLUE);
        Tsubmit.setBackground(new Color(0x7E95EF));
        Tsubmit.setBounds(300,510,160,40);
        techerpannel.add(Tsubmit);

        tableview.setText("View");
        tableview.setForeground(Color.BLUE);
        tableview.setBackground(new Color(0x7E95EF));
        tableview.setBounds(130,510,160,40);
        techerpannel.add(tableview);

        techBottom.setText("Learning Assistant");
        techBottom.setFont(new Font("Arial",Font.BOLD,20));
        techBottom.setForeground(Color.BLUE);
        techBottom.setBounds(10,560,300,40);
        techerpannel.add(techBottom);



        this.add(techerpannel);

    }

}

package Signup;

import javax.swing.*;
import java.awt.*;

public class signupview extends JFrame {

    protected JLabel userID = new JLabel();
    protected JLabel username = new JLabel();
    protected JTextField userIDtext = new JTextField(1);
    protected JTextField usernametext = new JTextField(1);
    protected JLabel gmail = new JLabel();
    protected JTextField gmailtxt = new JTextField(2);
    protected JLabel address = new JLabel();
    protected JTextField addresstxt = new JTextField(4);
    protected JLabel gender = new JLabel();
    protected JLabel contact = new JLabel();
    protected JTextField cotacttxt = new JTextField();
//    protected JRadioButton male = new JRadioButton();
//    protected JRadioButton female = new JRadioButton();
//    protected JLabel check = new JLabel();
 //   protected JCheckBox checkBox = new JCheckBox();
    protected JButton submit = new JButton();
    protected JLabel bottemT = new JLabel();
    protected JPanel panelsignup =new JPanel();
    protected JPanel genderPanel = new JPanel();
    protected JLabel sgrade = new JLabel();
    protected JTextField sgradetext = new JTextField(1);
    protected JLabel age = new JLabel();
    protected JTextField agetext = new JTextField(1);
    protected JComboBox<String> GenderCombo = new JComboBox<>();

    public JLabel getPassword() {
        return password;
    }

    public void setPassword(JLabel password) {
        this.password = password;
    }

    public JTextField getPwtxt() {
        return pwtxt;
    }

    public void setPwtxt(JTextField pwtxt) {
        this.pwtxt = pwtxt;
    }

    protected JLabel password = new JLabel();
    protected  JTextField pwtxt = new JTextField();


    public JComboBox<String> getGenderCombo() {
        return GenderCombo;
    }

    public JPanel getGenderPanel() {
        return genderPanel;
    }

    public JTextField getUserIDtext() {
        return userIDtext;
    }

    public JTextField getUsernametext() {
        return usernametext;
    }


    public JTextField getGmailtxt() {
        return gmailtxt;
    }


    public JTextField getAddresstxt() {
        return addresstxt;
    }


    public JTextField getCotacttxt() {
        return cotacttxt;
    }
//
//    public JRadioButton getMale() {
//        return male;
//    }
//
//    public JRadioButton getFemale() {
//        return female;
//    }
//

//    public JCheckBox getCheckBox() {
//        return checkBox;
//    }

    public JButton getSubmit() {
        return submit;
    }


    public JTextField getSgradetext() {
        return sgradetext;
    }




    public JTextField getAgetext() {
        return agetext;
    }



    public signupview() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setBackground(new Color(0x7E95EF));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initialized();
    }

    public void initialized(){

        panelsignup.setLayout(null);
        panelsignup.setBackground(new Color(0x7E95EF));
        this.add(panelsignup);

        JLabel titleLabel = new JLabel("Signup");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(10, 10, 300, 25);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panelsignup.add(titleLabel);

        userID.setText("1.Your UserID         :");
        userID.setBounds(10,90,150,25);
        userID.setForeground(Color.BLUE);
        userID.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(userID);

        userIDtext.setBounds(150,90,300,25);
        panelsignup.add(userIDtext);

        username.setText("2.Enter Your Name:");
        username.setBounds(10,120,150,25);
        username.setForeground(Color.BLUE);
        username.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(username);

        usernametext.setBounds(150,120,300,25);
        panelsignup.add(usernametext);

        age.setText("3.Enter Your Age   :");
        age.setBounds(10,150,150,25);
        age.setForeground(Color.BLUE);
        age.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(age);

        agetext.setBounds(150,150,300,25);
        panelsignup.add(agetext);

        sgrade.setText("4.Enter Your Grade:");
        sgrade.setBounds(10,180,150,25);
        sgrade.setForeground(Color.BLUE);
        sgrade.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(sgrade);

        sgradetext.setBounds(150,180,300,25);
        panelsignup.add(sgradetext);

        gmail.setText("5.Gmail                   :");
        gmail.setBounds(10,210,150,25);
        gmail.setForeground(Color.BLUE);
        gmail.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(gmail);

        gmailtxt.setBounds(150,210,300,25);
        panelsignup.add(gmailtxt);

        address.setText("6.Address              :");
        address.setBounds(10,240,150,25);
        address.setForeground(Color.BLUE);
        address.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(address);

        addresstxt.setBounds(150,240,300,25);
        panelsignup.add(addresstxt);

        gender.setText("7.Gender           :");
        gender.setBounds(10,280,140,25);
        gender.setForeground(Color.BLUE);
        gender.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(gender);

//        male.setText("Male");
//        male.setForeground(Color.BLUE);
//        male.setBackground(new Color(0x7E95EF));
//        female.setText("Female");
//        female.setForeground(Color.BLUE);
//        female.setBackground(new Color(0x7E95EF));
//        genderPanel.setBackground(new Color(0x7E95EF));
//        genderPanel.add(male);
//        genderPanel.add(female);
//        genderPanel.setBounds(140,270,220,30);
//        panelsignup.add(genderPanel);

        String [] genderS = {"Select Gender","Male","Female"};
        GenderCombo = new JComboBox<>(genderS);
        GenderCombo.setBackground(new Color(0x7E95EF));
        GenderCombo.setForeground(Color.BLUE);
        JPanel Disgender = new JPanel();
        Disgender.setBounds(150,280,150,25);
        Disgender.setBackground(new Color(0x7E95EF));
        Disgender.add(GenderCombo);
        panelsignup.add(Disgender);

//        check.setText("8.Are You Teacher?:");
//        check.setBounds(10,310,150,25);
//        check.setForeground(Color.BLUE);
//        check.setFont(new Font("Arial",Font.BOLD,14));
//        panelsignup.add(check);
//
//        checkBox.setText("Yes");
//        checkBox.setBounds(160,310,60,35);
//        checkBox.setBackground(new Color(0x7E95EF));
//        checkBox.setForeground(Color.BLUE);
//        panelsignup.add(checkBox);

        contact.setText("8.Contact Number :");
        contact.setBounds(10,310,150,25);
        contact.setForeground(Color.BLUE);
        contact.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(contact);

        cotacttxt.setBounds(150,310,300,25);
        panelsignup.add(cotacttxt);

        password.setText("9.Enter Password :");
        password.setBounds(10,340,150,25);
        password.setForeground(Color.BLUE);
        password.setFont(new Font("Arial",Font.BOLD,14));
        panelsignup.add(password);

        pwtxt.setBounds(150,340,300,25);
        panelsignup.add(pwtxt);


        submit.setText("Submit");
        submit.setForeground(Color.BLUE);
        submit.setBackground(new Color(0x7E95EF));
        submit.setBounds(300,385,160,40);
        panelsignup.add(submit);


        bottemT.setText("Learning Assistant");
        bottemT.setFont(new Font("Arial",Font.BOLD,20));
        bottemT.setForeground(Color.BLUE);
        bottemT.setBounds(10,400,300,35);
        panelsignup.add(bottemT);


    }
}




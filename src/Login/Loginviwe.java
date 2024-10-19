package Login;

import javax.swing.*;
import java.awt.*;

public class Loginviwe extends JFrame {

    JPanel loginpannel = new JPanel();
    JLabel logintitle = new JLabel();
    JLabel usernamel = new JLabel();
    JLabel passwordl = new JLabel();
    JTextField usertxtl = new JTextField();
    JTextField passwaordtxtl = new JTextField();
    JButton submit = new JButton();
    JButton clear = new JButton();
    ImageIcon image = new ImageIcon("DD2.jpg");
    JLabel pic = new JLabel(image);
    JLabel botteml = new JLabel();
//    JButton register = new JButton();

    public JButton getClear() {
        return clear;
    }

    public JLabel getLogintitle() {
        return logintitle;
    }

    public JLabel getUsernamel() {
        return usernamel;
    }

    public JLabel getPasswordl() {
        return passwordl;
    }

    public JTextField getUsertxtl() {
        return usertxtl;
    }

    public JTextField getPasswaordtxtl() {
        return passwaordtxtl;
    }

    public JButton getSubmit() {
        return submit;
    }





    public Loginviwe() {

        initialized();
    }

    public void initialized(){

        this.setSize(500,500);
        this.setTitle("Login");
        this.setBackground(Color.CYAN);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        loginpannel.setLayout(null);

        loginpannel.setBackground(new Color(0x7E95EF));

        logintitle.setText("LOGIN");
        logintitle.setForeground(Color.BLUE);
        logintitle.setFont(new Font("Arial", Font.BOLD, 24));
        logintitle.setBounds(10, 10, 300, 25);
        logintitle.setHorizontalAlignment(SwingConstants.LEFT);
        loginpannel.add(logintitle);

        usernamel.setText("Enter Username:");
        usernamel.setForeground(Color.BLUE);
        usernamel.setBounds(10,250,150,25);
        usernamel.setFont(new Font("Arial",Font.BOLD,14));
        loginpannel.add(usernamel);

        usertxtl.setBounds(150,250,300,25);
        loginpannel.add(usertxtl);

        passwordl.setText("Enter Password:");
        passwordl.setForeground(Color.BLUE);
        passwordl.setBounds(10,280,150,25);
        passwordl.setFont(new Font("Arial",Font.BOLD,14));
        loginpannel.add(passwordl);

        passwaordtxtl.setBounds(150,280,300,25);
        loginpannel.add(passwaordtxtl);

        submit.setText("Submit");
        submit.setForeground(Color.BLUE);
        submit.setBackground(new Color(0x7E95EF));
        submit.setBounds(340,335,110,40);
        loginpannel.add(submit);

        clear.setText("Clear");
        clear.setForeground(Color.BLUE);
        clear.setBackground(new Color(0x7E95EF));
        clear.setBounds(225,335,110,40);
        loginpannel.add(clear);

//        register.setText("Register");
//        register.setForeground(Color.BLUE);
//        register.setBackground(new Color(0x7E95EF));
//        register.setBounds(110,335,110,40);
//        loginpannel.add(register);

        pic.setBounds(190,100,100,100);
        loginpannel.add(pic);

        botteml.setText("Learning Assistant");
        botteml.setFont(new Font("Arial",Font.BOLD,20));
        botteml.setForeground(Color.BLUE);
        botteml.setBounds(10,400,300,35);
        loginpannel.add(botteml);



        this.add(loginpannel);
    }
    public void clear(){
        usertxtl.setText("");
        passwaordtxtl.setText("");
    }
}

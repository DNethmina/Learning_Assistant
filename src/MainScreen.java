import Login.LoginController;
import Login.Loginmodel;
import Login.Loginviwe;
import Signup.*;
import Student.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainScreen extends JFrame {
    JPanel screenpannel = new JPanel();
    JLabel title = new JLabel();
    ImageIcon imageIcon = new ImageIcon("DC3.jpg");
    JLabel picmain = new JLabel(imageIcon);
    JPanel conerpanel = new JPanel();
    JLabel details1 = new JLabel();
    JLabel details2 = new JLabel();
    JLabel details3 = new JLabel();
    JLabel details4 = new JLabel();
    JButton loginbutton = new JButton();
    JButton signupbutton = new JButton();
    JButton quectionbutton = new JButton();
    JButton registernbutton = new JButton();
    ImageIcon imageIcon2 = new ImageIcon("DC1.jpg");
    JLabel picmain2 = new JLabel(imageIcon2);



    public MainScreen() {
        this.setSize(1024,700);
        this.setTitle("Main Screen");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0x7E95EF));
        this.setVisible(true);
        initialized();
    }

    private void initialized() {

        screenpannel.setLayout(null);
        screenpannel.setBackground(new Color(0x7E95EF));

        title.setText("LEARNING ASSISTANT");
        title.setForeground(new Color(0xF4F4F4));
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setBounds(10, 10, 500, 40);
        title.setHorizontalAlignment(SwingConstants.LEFT);
        screenpannel.add(title);

        details1.setText("Welcome all,");
        details1.setForeground(new Color(0xF4F4F4));
        details1.setFont(new Font("Arial", Font.BOLD, 16));
        details1.setBounds(10, 500, 500, 100);
        details1.setHorizontalAlignment(SwingConstants.LEFT);
        screenpannel.add(details1);

        details2.setText("This is LEARNING ASSISTANT Desktop Application.");
        details2.setForeground(new Color(0xF4F4F4));
        details2.setFont(new Font("Arial", Font.BOLD, 16));
        details2.setBounds(10, 520, 500, 100);
        details2.setHorizontalAlignment(SwingConstants.LEFT);
        screenpannel.add(details2);
//
        details3.setText("We  are gave for you a amazing new experience in");
        details3.setForeground(new Color(0xF4F4F4));
        details3.setFont(new Font("Arial", Font.BOLD, 16));
        details3.setBounds(10, 540, 500, 100);
        details3.setHorizontalAlignment(SwingConstants.LEFT);
        screenpannel.add(details3);
//
        details4.setText("how to use new digital learn and teaching.........!");
        details4.setForeground(new Color(0xF4F4F4));
        details4.setFont(new Font("Arial", Font.BOLD, 16));
        details4.setBounds(10, 560, 500, 100);
        details4.setHorizontalAlignment(SwingConstants.LEFT);
        screenpannel.add(details4);

        picmain.setBounds(5,300,100,600);
        conerpanel.add(picmain);
        conerpanel.setBounds(1,0,410,700);
        conerpanel.setBackground(new Color(0x4243E7));
        screenpannel.add(conerpanel);

        loginbutton.setText("LOGIN");
        loginbutton.setForeground(Color.BLUE);
        loginbutton.setBackground(new Color(0x7E95EF));
        loginbutton.setBounds(660,245,140,40);
        screenpannel.add(loginbutton);

        signupbutton.setText("SIGNUP");
        signupbutton.setForeground(Color.BLUE);
        signupbutton.setBackground(new Color(0x7E95EF));
        signupbutton.setBounds(660,335,140,40);
        screenpannel.add(signupbutton);

        quectionbutton.setText("QUESTION");
        quectionbutton.setForeground(Color.BLUE);
        quectionbutton.setBackground(new Color(0x7E95EF));
        quectionbutton.setBounds(660,425,140,40);
        screenpannel.add(quectionbutton);

//        registernbutton.setText("REGISTER");
//        registernbutton.setForeground(Color.BLUE);
//        registernbutton.setBackground(new Color(0x7E95EF));
//        registernbutton.setBounds(660,515,140,40);
//        screenpannel.add(registernbutton);

        picmain2.setBounds(480,60,500,600);
        screenpannel.add(picmain2);




        this.add(screenpannel);

        loginbutton.addActionListener(new LoginListener());
        signupbutton.addActionListener(new singupscreenListener());
        quectionbutton.addActionListener(new quectionListener ());

    }


    public static class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            Loginviwe loginviwe = new Loginviwe();
            Loginmodel loginmodel = new Loginmodel();
            LoginController loginController = new LoginController(loginviwe,loginmodel);
            loginviwe.setVisible(true);
        }
    }

    public static class singupscreenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            signupview signupview = new signupview();
            signupModel signupModel = new signupModel();
            signupController signupController = new signupController(signupview,signupModel);
            signupview.setVisible(true);
        }
    }

    private class quectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Studentviwe studentviwe = new Studentviwe();
                Studentmodel studentmodel = new Studentmodel();
                StudentController studentController = new StudentController(studentviwe,studentmodel);
                studentviwe.setVisible(true);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}

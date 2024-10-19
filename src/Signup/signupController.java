package Signup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class signupController {

    protected signupview view;
    protected signupModel model;

    public signupController(signupview view,signupModel model)
    {
        this.view= view;
        this.model = model;

        this.view.getSubmit().addActionListener(new submitListener());
    }

    class submitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            model.setUserID(view.getUserIDtext().getText());
            model.setUsername(view.getUsernametext().getText());
            model.setAge(Integer.parseInt(view.getAgetext().getText()));
            model.setGrade(Integer.parseInt((view.getSgradetext().getText())));
            model.setGmail(view.getGmailtxt().getText());
            model.setAddress(view.getAddresstxt().getText());
            model.setGender((String) view.getGenderCombo().getSelectedItem());
//            model.setGender(view.getMale().getText());
//            model.setGender(view.getFemale().getText());
           //model.setCheck(view.getCheckBox().isSelected());
            model.setContactNumber(Integer.parseInt(view.getCotacttxt().getText()));
            model.setPw(view.getPwtxt().getText());


            JOptionPane.showMessageDialog(view,"Submit successfully");

            String massage = String.format("01.UserID : %s\n02.UserName : %s\n03.Age : %s\n04.Grade : %s\n05.Gmail : %s\n06.Address : %s\n" +
                    "07.Gender : %s\n08.Contact_Number : %s",model.getUserID(),model.getUsername(),model.getAge(),model.getGender(),model.getGmail()
            ,model.getAddress(),model.getGrade(),model.getContactNumber());

            JOptionPane.showMessageDialog(view,massage);

//            System.out.println("SID :"+ model.getUserID());
//            System.out.println("Student_Name :"+ model.getUsername());
//            System.out.println("Age :"+ model.getAge());
//            System.out.println("Grade :"+ model.getGrade());
//            System.out.println("Gmail :"+ model.getGmail());
//            System.out.println("Address :"+ model.getAddress());
//            System.out.println("Gender :"+ model.getGender());
//            System.out.println("Contact_Number :"+ model.getContactNumber());

            try{
                model.Addperson();
                JOptionPane.showMessageDialog(view,"Data submit successfully");
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(view,"Error submit" + ex.getMessage());
            }


        }
    }
}

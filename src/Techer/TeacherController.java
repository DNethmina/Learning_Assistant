package Techer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;



public class TeacherController {
    private  Teacheviwe view;
    private  Teachermodel model;

    public TeacherController(Teacheviwe view, Teachermodel model) {
        this.view = view;
        this.model = model;


        this.view.getTsubmit().addActionListener(new SubmitButtonListener());
        this.view.getTableview().addActionListener(new ViewButtonListener());

    }

    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            model.setTeacherID(view.getTechIDtxt().getText());
            model.setTeachername(view.getTechnametxt().getText());
            model.setTechergrade((String) view.getTechGreadeCombo().getSelectedItem());
            model.setTeachertopic((String) view.getTechCombotopic().getSelectedItem());
            model.setTeacherQ(view.getTextAreaQ().getText());
            try {
                model.setTeachermark(String.valueOf(Integer.parseInt(view.getTechMtxt().getText())));
            } catch (NumberFormatException ex) {
                model.setTeachermark(String.valueOf(0));
            }
            model.setTeacheranswer(view.getTechAtxt().getText());


            try {
                model.AddQuection();
                JOptionPane.showMessageDialog(view, "Data submitted successfully!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Error submitting data" + ex.getMessage());
            }


            JOptionPane.showMessageDialog(view, "Data submitted successfully!");



        }
    }

    class ViewButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            TableOperation tableOperation = new TableOperation();
            tableOperation.setVisible(true);

        }
    }
}

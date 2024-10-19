package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController {

    private Loginviwe view;
    private Loginmodel model;

    public LoginController(Loginviwe view, Loginmodel model) {

        this.view = view;
        this.model = model;


        this.view.getSubmit().addActionListener(new SubmitbuttonListener());
        this.view.getClear().addActionListener(new ClearbuttonListener());

    }

    public class SubmitbuttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            model.setUsername(view.getUsertxtl().getText());
            model.setPassword(view.getPasswaordtxtl().getText());
            try {
                model.log();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    }

    private class ClearbuttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            view.clear();

        }
    }

}

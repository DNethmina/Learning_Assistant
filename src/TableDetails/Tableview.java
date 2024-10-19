package TableDetails;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Tableview extends JFrame {

    private JTable tableViewT = new JTable();
    private JPanel tablePanelT = new JPanel();
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTextField searchtxt = new JTextField(20);
    private JButton searchButton = new JButton("SEARCH");

    public Tableview() {
        initialize();
        this.setTitle("Table View");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1100, 700);
        this.setVisible(true);
    }

    private void initialize() {
        tablePanelT.setBackground(new Color(0x7E95EF));
        tablePanelT.setLayout(new BorderLayout());

        String[] columns = {"TID", "Tname", "Age", "Grade", "Gmail", "Address", "Gender", "Contact", "Password"};
        tableModel.setColumnIdentifiers(columns);
        tableViewT.setModel(tableModel);

        TableColumnModel columnModel = tableViewT.getColumnModel();
        for (int i = 0; i < columns.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(110);
        }
        tableViewT.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(tableViewT);
        tablePanelT.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBackground(new Color(0x7E95EF));


        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.setBackground(new Color(0x7E95EF));

        searchButton.setForeground(Color.BLUE);
        searchButton.setBackground(new Color(0x7E95EF));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByTID();
            }
        });

        searchPanel.add(new JLabel("Search TID:"));
        searchPanel.add(searchtxt);
        searchPanel.add(searchButton);

        tablePanelT.add(searchPanel, BorderLayout.NORTH);
//
//        JPanel buttonPannel = new JPanel();
//        buttonPannel.setLayout(new FlowLayout());
//        buttonPannel.setBackground(new Color(0x7E95EF));

        JButton deleteButtonT = new JButton("DELETE");
        deleteButtonT.setForeground(Color.BLUE);
        deleteButtonT.setBackground(new Color(0x7E95EF));
        deleteButtonT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });

        JButton updateButtonT = new JButton("UPDATE");
        updateButtonT.setForeground(Color.BLUE);
        updateButtonT.setBackground(new Color(0x7E95EF));
        updateButtonT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRow();
            }
        });

//        buttonPannel.add(deleteButtonT);
//        buttonPannel.add(updateButtonT);
//        tablePanel.add(buttonPannel, BorderLayout.SOUTH);
        searchPanel.add(deleteButtonT);
        searchPanel.add(updateButtonT);

        this.add(tablePanelT);

        loadDataT();
    }

    private void loadDataT() {
        tableModel.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM teacher";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getString("TID"),
                        resultSet.getString("Tname"),
                        resultSet.getString("Age"),
                        resultSet.getString("Grade"),
                        resultSet.getString("Gmail"),
                        resultSet.getString("Address"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Contact"),
                        resultSet.getString("password")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }

    private void searchByTID() {
        String searchText = searchtxt.getText().trim();
        if (searchText.isEmpty()) {
            loadDataT();
            return;
        }

        tableModel.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM teacher WHERE TID = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, searchText);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getString("TID"),
                        resultSet.getString("Tname"),
                        resultSet.getString("Age"),
                        resultSet.getString("Grade"),
                        resultSet.getString("Gmail"),
                        resultSet.getString("Address"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Contact"),
                        resultSet.getString("password")
                });
            }

            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found for TID: " + searchText);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }

    private void deleteRow() {
        int selectedRow = tableViewT.getSelectedRow();
        if (selectedRow != -1) {
            String tid = tableModel.getValueAt(selectedRow, 0).toString();

            String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
            String user = "root";
            String password = "";

            String query = "DELETE FROM teacher WHERE TID = ?";

            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, tid);
                preparedStatement.executeUpdate();

                tableModel.removeRow(selectedRow);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Database error", e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No row selected");
        }
    }

    private void updateRow() {
        int selectedRow = tableViewT.getSelectedRow();
        if (selectedRow != -1) {

            String currentTID = tableModel.getValueAt(selectedRow, 0).toString();


            String newTID = JOptionPane.showInputDialog("Enter new TID (current: " + currentTID + "):");
            String newTname = JOptionPane.showInputDialog("Enter new name for TID " + currentTID);
            String newAge = JOptionPane.showInputDialog("Enter new age for TID " + currentTID);
            String newGrade = JOptionPane.showInputDialog("Enter new grade for TID " + currentTID);
            String newGmail = JOptionPane.showInputDialog("Enter new Gmail for TID " + currentTID);
            String newAddress = JOptionPane.showInputDialog("Enter new address for TID " + currentTID);
            String newGender = JOptionPane.showInputDialog("Enter new gender for TID " + currentTID);
            String newContact = JOptionPane.showInputDialog("Enter new contact for TID " + currentTID);
            String newPassword = JOptionPane.showInputDialog("Enter new password for TID " + currentTID);


            if (newTID != null && !newTID.trim().isEmpty() &&
                    newTname != null && !newTname.trim().isEmpty() &&
                    newAge != null && !newAge.trim().isEmpty() &&
                    newGrade != null && !newGrade.trim().isEmpty() &&
                    newGmail != null && !newGmail.trim().isEmpty() &&
                    newAddress != null && !newAddress.trim().isEmpty() &&
                    newGender != null && !newGender.trim().isEmpty() &&
                    newContact != null && !newContact.trim().isEmpty() &&
                    newPassword != null && !newPassword.trim().isEmpty()) {

                String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
                String user = "root";
                String password = "";

                String query = "UPDATE teacher SET TID = ?, Tname = ?, Age = ?, Grade = ?, Gmail = ?, Address = ?, Gender = ?, Contact = ?, password = ? WHERE TID = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                    preparedStatement.setString(1, newTID);
                    preparedStatement.setString(2, newTname);
                    preparedStatement.setString(3, newAge);
                    preparedStatement.setString(4, newGrade);
                    preparedStatement.setString(5, newGmail);
                    preparedStatement.setString(6, newAddress);
                    preparedStatement.setString(7, newGender);
                    preparedStatement.setString(8, newContact);
                    preparedStatement.setString(9, newPassword);
                    preparedStatement.setString(10, currentTID);

                    preparedStatement.executeUpdate();
                    tableModel.setValueAt(newTID, selectedRow, 0);
                    tableModel.setValueAt(newTname, selectedRow, 1);
                    tableModel.setValueAt(newAge, selectedRow, 2);
                    tableModel.setValueAt(newGrade, selectedRow, 3);
                    tableModel.setValueAt(newGmail, selectedRow, 4);
                    tableModel.setValueAt(newAddress, selectedRow, 5);
                    tableModel.setValueAt(newGender, selectedRow, 6);
                    tableModel.setValueAt(newContact, selectedRow, 7);
                    tableModel.setValueAt(newPassword, selectedRow, 8);


                    tableViewT.setValueAt(newTID, selectedRow, 0);
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Database error", e);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input or no row selected");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No row selected");
        }
    }

}

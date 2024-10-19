package TableDetails;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class STTable extends JFrame {

    private JTable tableViewST = new JTable();
    private JPanel tablePanelST = new JPanel();
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTextField searchtxts = new JTextField(20);
    private JButton searchButons = new JButton("SEARCH");

    public STTable() {
        initialize();
        this.setTitle("Student Table View");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1100, 700);
        this.setVisible(true);
    }

    public void initialize() {
        tablePanelST.setBackground(new Color(0x7E95EF));
        tablePanelST.setLayout(new BorderLayout());

        String[] columns = {"SID", "Sname", "Age", "Grade", "Gmail", "Address", "Gender", "Contact"};
        tableModel.setColumnIdentifiers(columns);
        tableViewST.setModel(tableModel);

        TableColumnModel columnModel = tableViewST.getColumnModel();
        for (int i = 0; i < columns.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(110);
        }
        tableViewST.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(tableViewST);
        tablePanelST.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBackground(new Color(0x7E95EF));


        JPanel searchPanels = new JPanel();
        searchPanels.setLayout(new FlowLayout());
        searchPanels.setBackground(new Color(0x7E95EF));

        searchButons.setForeground(Color.BLUE);
        searchButons.setBackground(new Color(0x7E95EF));
        searchButons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBySID();
            }
        });

        searchPanels.add(new JLabel("Search SID:"));
        searchPanels.add(searchtxts);
        searchPanels.add(searchButons);
        tablePanelST.add(searchPanels, BorderLayout.NORTH);

        JPanel buttonPannel = new JPanel();
        buttonPannel.setLayout(new FlowLayout());
        buttonPannel.setBackground(new Color(0x7E95EF));

        JButton deleteButtons = new JButton("DELETE");
        deleteButtons.setForeground(Color.BLUE);
        deleteButtons.setBackground(new Color(0x7E95EF));
        deleteButtons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });

        JButton updateButtons = new JButton("UPDATE");
        updateButtons.setForeground(Color.BLUE);
        updateButtons.setBackground(new Color(0x7E95EF));
        updateButtons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRow();
            }
        });
//
//        buttonPannel.add(deleteButtonT);
//        buttonPannel.add(updateButtonT);
//        tablePanel.add(buttonPannel, BorderLayout.SOUTH);

        searchPanels.add(deleteButtons);
        searchPanels.add(updateButtons);

        this.add(tablePanelST);

        loadDataT();
    }

    private void loadDataT() {
        tableModel.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM student";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getString("SID"),
                        resultSet.getString("Sname"),
                        resultSet.getString("Age"),
                        resultSet.getString("Grade"),
                        resultSet.getString("Gmail"),
                        resultSet.getString("Address"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Contact"),
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }

    private void searchBySID() {
        String searchText = searchtxts.getText().trim();
        if (searchText.isEmpty()) {
            loadDataT();
            return;
        }

        tableModel.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM student WHERE SID = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, searchText);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getString("SID"),
                        resultSet.getString("Sname"),
                        resultSet.getString("Age"),
                        resultSet.getString("Grade"),
                        resultSet.getString("Gmail"),
                        resultSet.getString("Address"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Contact"),
                });
            }

            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found for SID: " + searchText);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }

    private void deleteRow() {
        int selectedRow = tableViewST.getSelectedRow();
        if (selectedRow != -1) {
            String sid = tableModel.getValueAt(selectedRow, 0).toString();

            String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
            String user = "root";
            String password = "";

            String query = "DELETE FROM student WHERE SID = ?";

            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, sid);
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
        int selectedRow = tableViewST.getSelectedRow();
        if (selectedRow != -1) {

            String currentSID = tableModel.getValueAt(selectedRow, 0).toString();
            String newSID = JOptionPane.showInputDialog("Enter new SID (current: " + currentSID + "):");
            String newSname = JOptionPane.showInputDialog("Enter new name for SID " + currentSID);
            String newAge = JOptionPane.showInputDialog("Enter new age for SID " + currentSID);
            String newGrade = JOptionPane.showInputDialog("Enter new grade for SID " + currentSID);
            String newGmail = JOptionPane.showInputDialog("Enter new Gmail for SID " + currentSID);
            String newAddress = JOptionPane.showInputDialog("Enter new address for SID " + currentSID);
            String newGender = JOptionPane.showInputDialog("Enter new gender for SID " + currentSID);
            String newContact = JOptionPane.showInputDialog("Enter new contact for SID " + currentSID);


            if (newSID != null && !newSID.trim().isEmpty() &&
                    newSname != null && !newSname.trim().isEmpty() &&
                    newAge != null && !newAge.trim().isEmpty() &&
                    newGrade != null && !newGrade.trim().isEmpty() &&
                    newGmail != null && !newGmail.trim().isEmpty() &&
                    newAddress != null && !newAddress.trim().isEmpty() &&
                    newGender != null && !newGender.trim().isEmpty() &&
                    newContact != null && !newContact.trim().isEmpty()) {

                String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
                String user = "root";
                String password = "";

                String query = "UPDATE student SET SID = ?, Sname = ?, Age = ?, Grade = ?, Gmail = ?, Address = ?, Gender = ?, Contact = ? WHERE SID = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                    preparedStatement.setString(1, newSID);
                    preparedStatement.setString(2, newSname);
                    preparedStatement.setString(3, newAge);
                    preparedStatement.setString(4, newGrade);
                    preparedStatement.setString(5, newGmail);
                    preparedStatement.setString(6, newAddress);
                    preparedStatement.setString(7, newGender);
                    preparedStatement.setString(8, newContact);
                    preparedStatement.setString(9, currentSID);

                    preparedStatement.executeUpdate();


                    tableModel.setValueAt(newSID, selectedRow, 0);
                    tableModel.setValueAt(newSname, selectedRow, 1);
                    tableModel.setValueAt(newAge, selectedRow, 2);
                    tableModel.setValueAt(newGrade, selectedRow, 3);
                    tableModel.setValueAt(newGmail, selectedRow, 4);
                    tableModel.setValueAt(newAddress, selectedRow, 5);
                    tableModel.setValueAt(newGender, selectedRow, 6);
                    tableModel.setValueAt(newContact, selectedRow, 7);

                    tableViewST.setValueAt(newSID, selectedRow, 0);
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

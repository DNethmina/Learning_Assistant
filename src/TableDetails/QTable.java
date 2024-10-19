package TableDetails;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class QTable extends JFrame {
    private JTable tableViewQ = new JTable();
    private JPanel tablePanelQ = new JPanel();
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTextField searchFieldQ = new JTextField(20);
    private JButton searchButtonQ = new JButton("SEARCH");

    public QTable() {
        initialize();
        this.setTitle("Table View");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1100, 700);
        this.setVisible(true);
    }

    public void initialize() {
        tablePanelQ.setBackground(new Color(0x7E95EF));
        tablePanelQ.setLayout(new BorderLayout());

        String[] columns = {"QID", "Question", "Grade", "Topic", "RigtAnswer", "Mark", "TID"};
        tableModel.setColumnIdentifiers(columns);
        tableViewQ.setModel(tableModel);

        TableColumnModel columnModel = tableViewQ.getColumnModel();
        for (int i = 0; i < columns.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(110);
        }
        tableViewQ.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(tableViewQ);
        tablePanelQ.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBackground(new Color(0x7E95EF));


        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.setBackground(new Color(0x7E95EF));

        searchButtonQ.setForeground(Color.BLUE);
        searchButtonQ.setBackground(new Color(0x7E95EF));
        searchButtonQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByQID();
            }
        });

        searchPanel.add(new JLabel("Search QID:"));
        searchPanel.add(searchFieldQ);
        searchPanel.add(searchButtonQ);
        tablePanelQ.add(searchPanel, BorderLayout.NORTH);

        JPanel buttonPannel = new JPanel();
        buttonPannel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPannel.setBackground(new Color(0x7E95EF));

        JButton deleteButtonT = new JButton("DELETE");
        deleteButtonT.setForeground(Color.BLUE);
        deleteButtonT.setBackground(new Color(0x7E95EF));

        deleteButtonT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });

        buttonPannel.add(deleteButtonT);
        tablePanelQ.add(buttonPannel, BorderLayout.SOUTH);

        this.add(tablePanelQ);

        loadDataT();
    }

    private void loadDataT() {
        tableModel.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM question";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getString("QID"),
                        resultSet.getString("Question"),
                        resultSet.getString("Grade"),
                        resultSet.getString("Topic"),
                        resultSet.getString("RigtAnswer"),
                        resultSet.getString("Mark"),
                        resultSet.getString("TID"),
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }

    private void searchByQID() {
        String searchText = searchFieldQ.getText().trim();
        if (searchText.isEmpty()) {
            loadDataT();
            return;
        }

        tableModel.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM question WHERE QID = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, searchText);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getString("QID"),
                        resultSet.getString("Question"),
                        resultSet.getString("Grade"),
                        resultSet.getString("Topic"),
                        resultSet.getString("RigtAnswer"),
                        resultSet.getString("Mark"),
                        resultSet.getString("TID"),
                });
            }

            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found for QID: " + searchText);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }

    private void deleteRow() {
        int selectedRow = tableViewQ.getSelectedRow();
        if (selectedRow != -1) {
            String qid = tableModel.getValueAt(selectedRow, 0).toString();

            String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
            String user = "root";
            String password = "";

            String query = "DELETE FROM question WHERE QID = ?";

            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, qid);
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

}
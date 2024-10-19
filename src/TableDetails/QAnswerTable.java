package TableDetails;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class QAnswerTable extends JFrame {
    private JTable tableViewQA = new JTable();
    private JPanel tablePanelQA = new JPanel();
    private DefaultTableModel tableModel = new DefaultTableModel();

    public QAnswerTable() {
        initialize();
        this.setTitle("Question table View");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1100, 700);
        this.setVisible(true);
    }
    public void  initialize (){
        tablePanelQA.setBackground(new Color(0x7E95EF));
        tablePanelQA.setLayout(new BorderLayout());

        String[] columns = {"AID", "Ansewer", "SID", "QID"};
        tableModel.setColumnIdentifiers(columns);
        tableViewQA.setModel(tableModel);

        TableColumnModel columnModel = tableViewQA.getColumnModel();
        for (int i = 0; i < columns.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(110);
        }
        tableViewQA.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(tableViewQA);
        tablePanelQA.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBackground(new Color(0x7E95EF));

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
        tablePanelQA.add(buttonPannel, BorderLayout.SOUTH);

        this.add(tablePanelQA);

        loadDataT();
    }

    private void loadDataT() {
        tableModel.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM questionansewer";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getString("AID"),
                        resultSet.getString("Ansewer"),
                        resultSet.getString("SID"),
                        resultSet.getString("QID")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error", e);
        }
    }

    private void deleteRow() {
        int selectedRow = tableViewQA.getSelectedRow();
        if (selectedRow != -1) {
            String qid = tableModel.getValueAt(selectedRow, 0).toString();

            String url = "jdbc:mysql://localhost:3306/learnung_assistent2";
            String user = "root";
            String password = "";

            String query = "DELETE FROM questionansewer WHERE QID = ?";

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

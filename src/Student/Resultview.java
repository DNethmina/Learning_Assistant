package Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Resultview extends JFrame {

    JPanel resultPanel = new JPanel();
    JLabel Rtitle = new JLabel();
    JTable ResultTable = new JTable();
    JLabel mark = new JLabel();
    JLabel Rmark = new JLabel();
    JLabel bottum = new JLabel();
    JButton back = new JButton();
    String SId;


    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public Resultview(String sId) throws SQLException {
        this.SId = sId;
        this.setSize(600, 600);
        this.setTitle("Results");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0x7E95EF));
        this.setVisible(true);
        initialized();
    }

    private void initialized() throws SQLException {
        resultPanel.setLayout(null);
        resultPanel.setBackground(new Color(0x7E95EF));

        Rtitle.setText("YOUR RESULTS");
        Rtitle.setForeground(Color.BLUE);
        Rtitle.setFont(new Font("Arial", Font.BOLD, 26));
        Rtitle.setBounds(10, 10, 400, 40);
        resultPanel.add(Rtitle);

        DefaultTableModel tbl = new DefaultTableModel();
        Object[] columns = new Object[]{"Student Id", "Your Answer", "Correct Answer", "Mark"};
        tbl.setColumnIdentifiers(columns);
        tbl = viewResultTable(tbl);

        ResultTable.setModel(tbl);
        TableColumnModel columnModel = ResultTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(10);

        ResultTable.setRowHeight(30);


        JScrollPane jScrollPane = new JScrollPane(ResultTable);
        jScrollPane.setBounds(20, 90, 550, 200);

        resultPanel.add(jScrollPane);

//        back.setText("Back");
//        back.setForeground(Color.BLUE);
//        back.setBackground(new Color(0x7E95EF));
//        back.setBounds(410, 430, 160, 40);
//        resultPanel.add(back);

        bottum.setText("Learning Assistant");
        bottum.setFont(new Font("Arial", Font.BOLD, 24));
        bottum.setForeground(Color.BLUE);
        bottum.setBounds(10, 480, 300, 35);
        resultPanel.add(bottum);

        this.add(resultPanel);
    }

    public DefaultTableModel viewResultTable(DefaultTableModel table) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("SID: " + SId);
            String conURL = "jdbc:mysql://localhost:3306/learnung_assistent2";
            connection = DriverManager.getConnection(conURL, "root", "");
            statement = connection.createStatement();

            String sql = "SELECT qa.SID, qa.Ansewer, q.RigtAnswer, q.Mark " +
                    "FROM questionansewer qa " +
                    "INNER JOIN question q ON qa.QID = q.QID WHERE qa.SID='" + SId + "';";
            System.out.println(sql);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                table.addRow(new Object[]{
                        result.getString("SID"),
                        result.getString("Ansewer"),
                        result.getString("RigtAnswer"),
                        result.getString("Mark")
                });
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return table;
    }
}

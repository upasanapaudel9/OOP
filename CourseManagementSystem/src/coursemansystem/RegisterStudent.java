package coursemansystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RegisterStudent extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JLabel l1, l2, l3, l4;
    JTable t1;
    JButton b1, b2, b3;
    JTextField t2, t3, t4, t5;
    static String modName;
    static String module1, module2, module3;
    String x[] = { "Student Name", "Student username", "Course", "Level" };
    String y[][] = new String[20][4];
    int i = 0, j = 0;

    RegisterStudent(String username, String course) {
        super("Register Student");
        System.out.println("Setting background color...");
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
        getRootPane().setOpaque(true); // Ensure the root pane is opaque

        setSize(1260, 650);
        setLocation(200, 200);
        setLayout(null);

        l1 = new JLabel("Username:");
        l1.setBounds(50, 360, 400, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        add(l1);

        t2 = new JTextField();
        t2.setBounds(180, 360, 200, 30);
        add(t2);

        l3 = new JLabel("Level:");
        l3.setBounds(50, 400, 400, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        add(l3);

        t4 = new JTextField();
        t4.setBounds(180, 400, 200, 30);
        add(t4);

        l2 = new JLabel("Course Name:");
        l2.setBounds(50, 440, 400, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        add(l2);

        t3 = new JTextField();
        t3.setBounds(180, 440, 200, 30);
        add(t3);

        b1 = new JButton("Register");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(590, 500, 100, 30);
        add(b1);

        b1.addActionListener(this);

        try {
            Connect c1 = new Connect();
            String s1 = "select * from studentlogin";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("username");
                y[i][j++] = rs.getString("course");
                y[i][j++] = rs.getString("level");

                i++;
                j = 0;
            }
            t1 = new JTable(y, x);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20, 20, 1200, 330);
        add(sp);
    }

    public void actionPerformed(ActionEvent ae) {
        Connect c1;
        try {
            c1 = new Connect();
            if (ae.getSource() == b1) {
                try {

                    String username = t2.getText();
                    String courseName = t3.getText();
                    String level = t4.getText();

                    String s1 = "select * from module where courseName = '" + courseName + "' AND level = '" + level
                            + "' AND Type = 'Mandatory' ORDER BY moduleName ASC";

                    ResultSet rs = c1.s.executeQuery(s1);
                    int i = 0;
                    while (rs.next()) {
                        if (i == 0) {
                            module1 = rs.getString("moduleName");
                        } else if (i == 1) {
                            module2 = rs.getString("moduleName");
                        }
                        i++;
                    }

                    String q = "UPDATE `studentlogin` SET `level`='" + level + "' WHERE username = '" + username
                            + "'";

                    String sq = "INSERT INTO `marks`(`username`, `moduleName`, `level`, `course`) VALUES ('"
                            + username + "','" + module1 + "','" + level + "', '" + courseName + "')";
                    String sq1 = "INSERT INTO `marks`(`username`, `moduleName`,`level`, `course`) VALUES ('"
                            + username + "','" + module2 + "', '" + level + "','" + courseName + "')";
                    c1.s.executeUpdate(q);
                    c1.s.executeUpdate(sq);
                    c1.s.executeUpdate(sq1);
                    this.setVisible(false);
                    new RegisterStudent(username, courseName).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new RegisterStudent(modName, modName).setVisible(true);
    }
}

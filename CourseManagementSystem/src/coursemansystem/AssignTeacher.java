package coursemansystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignTeacher extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	// Private Variables which is used only in this class
    JLabel l1, l2, l3;
    JTable t1;
    JButton b1, b2, b3;
    JTextField t2, t3, t4;
    static String modName;
    // Array for Table
    String x[] = {"No", "Teacher Name", "Teacher Username", "Course", "Level"};
    String y[][] = new String[20][5];
    int i = 0, j = 0;

    // Constructor
    AssignTeacher() {
        // initializes GUI components
        super("Assign Teacher");
        // Panel Size and Layout
        setSize(1260, 650);
        setLocation(200, 200);
        setLayout(null);
        // Label
        l1 = new JLabel("Enter No:");
        l1.setBounds(50, 360, 400, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        add(l1);
        // Text field to enter the number
        t2 = new JTextField();
        t2.setBounds(180, 360, 200, 30);
        add(t2);
        // Label
        l3 = new JLabel("Add Level:");
        l3.setBounds(50, 400, 400, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        add(l3);
        // Text field to enter level to assign
        t4 = new JTextField();
        t4.setBounds(180, 400, 200, 30);
        add(t4);
        // Button to assign the teacher
        b1 = new JButton("Assign");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(590, 450, 100, 30);
        add(b1);

        b1.addActionListener(this);
        // Table
        try {
            Connect c1 = new Connect();
            String s1 = "select * from teacherlogin";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("No");
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("username");
                y[i][j++] = rs.getString("course");
                y[i][j++] = rs.getString("Level");
                i++;
                j = 0;
            }
            t1 = new JTable(y, x);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Scroll panel for table
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20, 20, 1200, 330);
        add(sp);

        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple

        b1.addActionListener(this);
    }

    // Perform Action for b1 button
    public void actionPerformed(ActionEvent ae) {
        // Assign Teacher Functionality
        Connect c1;
        try {
            c1 = new Connect();
            if (ae.getSource() == b1) {
                try {
                    String no = t2.getText();
                    String level = t4.getText();
                    String que = "UPDATE `teacherlogin` SET `level` = '" + level + "' WHERE `No`= '" + no + "'";
                    c1.s.executeUpdate(que);
                    this.setVisible(false);
                    new AssignTeacher().setVisible(true);
                } catch (Exception e) {
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AssignTeacher().setVisible(true);
    }
}

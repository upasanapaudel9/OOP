package coursemansystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class StudentDetails extends JFrame implements ActionListener {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1, l2, l3;
    JTable t1;
    JButton b1, b2, b3;
    JTextField t2;
    String x[] = {"Name", "Email", "Username", "Date of Birth", "Course", "Level"};
    String y[][] = new String[20][6];
    int i = 0, j = 0;

    StudentDetails() {
        super("Student Details");
        setSize(1260, 650);
        setLocation(200, 200);
        setLayout(null);
        
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple

        l1 = new JLabel("Enter username to delete Student : ");
        l1.setBounds(50, 360, 400, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        add(l1);

        t2 = new JTextField();
        t2.setBounds(400, 360, 200, 30);
        add(t2);

        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100, 30);
        add(b1);

        b1.addActionListener(this);

        try {
            Connect c1 = new Connect();
            String s1 = "select * from studentlogin";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("username");
                y[i][j++] = rs.getString("dob");
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

        // Don't set background color again here
    }

    public void actionPerformed(ActionEvent ae) {
        Connect c1;
        try {
            c1 = new Connect();
            if (ae.getSource() == b1) {
                try {
                    String a = t2.getText();
                    String q = "delete from studentlogin where username = '" + a + "'";
                    c1.s.executeUpdate(q);
                    this.setVisible(false);
                    new StudentDetails().setVisible(true);
                } catch (Exception e) {
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
//    public static void main(String[] args){
//        new StudentDetails().setVisible(true);
//    }
}

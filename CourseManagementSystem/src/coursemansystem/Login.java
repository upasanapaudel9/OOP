package coursemansystem;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1, l2, l3;
    private JTextField t1;
    private JPasswordField t2;
    private JComboBox<?> cb;
    private JButton b1, b2, b3;
    public static String username;

    String role[] = {"Please Choose a Role", "Admin", "Faculty", "Student"};

    Login() {

        super("Login");

        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        l3 = new JLabel("User Role");
        l3.setBounds(40, 120, 100, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        add(t2);

        cb = new JComboBox<Object>(role);
        cb.setBounds(150, 120, 150, 30);
        add(cb);


        b1 = new JButton("Login");
        b1.setBounds(40, 200, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);


        b2 = new JButton("Signup");
        b2.setBounds(180, 200, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        b3 = new JButton("Cancel");
        b3.setBounds(320, 200, 120, 30);
        b3.setFont(new Font("serif", Font.BOLD, 15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);


        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple

        setVisible(true);
        setSize(600, 300);
        setLocation(500, 300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                Connect c1 = new Connect();
                String u = t1.getText();
                @SuppressWarnings("deprecation")
				String v = t2.getText();
                username = u;

                String q = "select * from admin where Uname='" + u + "' and pass='" + v + "'and Role = '" + cb.getSelectedItem() + "'";
                String s = "select * from teacherlogin where username='" + u + "' and pass= '" + v + "' and Role='" + cb.getSelectedItem() + "'";

                String t = "select * from studentlogin where username='" + u + "' and pass= '" + v + "' and Role='" + cb.getSelectedItem() + "'";


                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {

                    if (rs.getString("Role").equals("Admin")) {
                        this.dispose();
                        new AdminPanel().setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login");
                        setVisible(false);
                    }
                }

                ResultSet res = c1.s.executeQuery(s);
                if (res.next()) {
                    if (res.getString("Role").equals("Faculty")) {
                        c1.s.execute("INSERT INTO `logincheck`(`username`, `role`) VALUES ('" + u + "','" + cb.getSelectedItem() + "')");
                        this.dispose();
                        new TeacherPanel().setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login");
                        setVisible(false);
                    }
                }
                ResultSet r = c1.s.executeQuery(t);
                if (r.next()) {

                    if (r.getString("Role").equals("Student")) {
                        c1.s.execute("INSERT INTO `logincheck`(`username`, `role`) VALUES ('" + u + "','" + cb.getSelectedItem() + "')");
                        this.dispose();
                        new StudentPanel().setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login");
                        setVisible(false);
                        this.dispose();
                    }
                }
//                    else {
//                        JOptionPane.showMessageDialog(null, "Invalid login");
//                        setVisible(false);
//                        new Login().setVisible(true);
//                    }  

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
            this.dispose();
            try {
                new Signup().setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ae.getSource() == b3) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

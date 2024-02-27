package coursemansystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1, l2, l3, l4, l5, l6, l7;
    private JTextField t1, t2, t3, t4;
    private JPasswordField t5;
    private JComboBox<?> cb, combo;
    private JButton b1;
    private String x;
    String role[] = {"Please Choose a Role", "Faculty", "Student"};

    Signup() throws SQLException {
        super("Signup");
        setBackground(Color.white);
        setLayout(null);
        new GetArrayValues();

        l1 = new JLabel("Name");
        l1.setBounds(40, 20, 100, 30);
        add(l1);
        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        l2 = new JLabel("Email");
        l2.setBounds(430, 20, 100, 30);
        add(l2);
        t2 = new JTextField();
        t2.setBounds(520, 20, 150, 30);
        add(t2);

        l3 = new JLabel("Username");
        l3.setBounds(40, 70, 100, 30);
        add(l3);
        t3 = new JTextField();
        t3.setBounds(150, 70, 150, 30);
        add(t3);

        l4 = new JLabel("Date of Birth");
        l4.setBounds(430, 120, 100, 30);
        add(l4);
        t4 = new JTextField();
        t4.setBounds(520, 120, 150, 30);
        add(t4);

        l5 = new JLabel("Password");
        l5.setBounds(430, 70, 100, 30);
        add(l5);
        t5 = new JPasswordField();
        t5.setBounds(520, 70, 150, 30);
        add(t5);

        l6 = new JLabel("User Role");
        l6.setBounds(40, 120, 150, 30);
        add(l6);
        cb = new JComboBox<Object>(role);
        cb.setBounds(150, 120, 150, 30);
        add(cb);

        l7 = new JLabel("Course");
        l7.setBounds(40, 170, 150, 30);
        add(l7);
        combo = new JComboBox<Object>(GetArrayValues.courses);
        combo.setBounds(150, 170, 150, 30);
        add(combo);


        b1 = new JButton("Submit");
        b1.setBounds(350, 250, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);


        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple

        setVisible(true);
        setSize(800, 450);
        setLocation(400, 200);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String role = (String) cb.getSelectedItem();
        x = (String) cb.getSelectedItem();
        if (e.getSource() == b1) {
            try {
                Connect c1 = new Connect();
                String name = t1.getText();
                String email = t2.getText();
                String uname = t3.getText();
                @SuppressWarnings("deprecation")
				String pass = t5.getText();
                String dob = t4.getText();
                String course = (String) combo.getSelectedItem();

                if (x == "Faculty") {
                    String a = "Insert into teacherlogin(name,email,username,pass,role,dob,course)  values('" + name + "','" + email + "','" + uname + "','" + pass + "','" + role + "','" + dob + "','" + course + "')";
                    c1.s.executeUpdate(a);
                }

                if (x == "Student") {
                    String b = "Insert into studentlogin(name,email,username,pass,role,dob,course) values('" + name + "','" + email + "','" + uname + "','" + pass + "','" + role + "','" + dob + "','" + course + "' )";
                    c1.s.executeUpdate(b);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "User Created Successfully");
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) throws SQLException {
        new Signup();
    }
}

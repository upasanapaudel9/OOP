package coursemansystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class NewCourse extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	private JLabel l1;
    private JTextField t1;
    private JButton b1;

    NewCourse() {
        super("New Course");
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
        setLayout(null);

        l1 = new JLabel("Course Name");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        b1 = new JButton("Submit");
        b1.setBounds(350, 250, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        setVisible(true);
        setSize(800, 450);
        setLocation(400, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Connect c1 = new Connect();
                String name = t1.getText();
                String a = "Insert into courses(CourseName)  values('" + name + "')";
                c1.s.executeUpdate(a);
                JOptionPane.showMessageDialog(null, "Course Added Successfully");
                setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        new NewCourse();
    }
}

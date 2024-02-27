package coursemansystem;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AdminPanel extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1, l2; 
    private JButton b1;

    AdminPanel() { //constructor
        super("Course Management System");
        setSize(745, 445); // panel size
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple

        l1 = new JLabel("Welcome to the CMS");
        l1.setBounds(150, 50, 400, 80);
        l1.setFont(new Font("Senserif", Font.BOLD, 40));
        l1.setForeground(Color.BLACK);
        add(l1);
        
        l2 = new JLabel("Admin");
        l2.setBounds(250, 170, 200, 40);
        l2.setFont(new Font("Senserif", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l2.setHorizontalAlignment(JLabel.CENTER);
        add(l2);

        b1 = new JButton("Logout Admin");
        b1.setBackground(new Color(150, 0, 0));
        b1.setForeground(Color.WHITE); 
        b1.setBounds(265, 280, 170, 40); 
        b1.setFocusable(false);
        add(b1);
        b1.addActionListener(this);

        JMenuBar mb = new JMenuBar();
        JMenu New = new JMenu("New");
        JMenuItem m1 = new JMenuItem("New Course");
        JMenuItem m2 = new JMenuItem("Assign Teacher");
        JMenuItem m3 = new JMenuItem("Register Student");
        New.setForeground(Color.BLACK);
        New.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

        m1.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        m1.setBackground(Color.WHITE);

        m2.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        m2.setBackground(Color.WHITE);

        m3.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        m3.setBackground(Color.WHITE);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        JMenu user = new JMenu("Details");
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        user.setForeground(Color.BLACK);
        user.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

        u1.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        u1.setBackground(Color.WHITE);

        u2.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        u2.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);

        JMenu exam = new JMenu("Report");
        JMenuItem c1 = new JMenuItem("Result Slip");
        exam.setForeground(Color.BLACK);
        exam.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

        c1.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        c1.setBackground(Color.WHITE);
        exam.add(c1);

        c1.addActionListener(this);

        JMenu report = new JMenu("Edit/Delete");
        JMenuItem r1 = new JMenuItem("Edit Course");
        JMenuItem r2 = new JMenuItem("Delete Course");
        report.setForeground(Color.BLACK);
        report.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

        r1.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        r1.setBackground(Color.WHITE);

        r2.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        r2.setBackground(Color.WHITE);

        r1.addActionListener(this);
        r2.addActionListener(this);

        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(new Color(150, 0, 0));
        exit.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

        ex.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);

        New.add(m1);
        New.add(m2);
        New.add(m3);

        user.add(u1);
        user.add(u2);

        report.add(r1);
        report.add(r2);

        exit.add(ex);

        mb.add(New);
        mb.add(user);
        mb.add(exam);
        mb.add(report);
        mb.add(exit);

        setJMenuBar(mb);
        setFont(new Font("Senserif", Font.BOLD, 25));
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Course")){
            new AddCourse().setVisible(true);
        }else if(msg.equals("Assign Teacher")){
            new AssignTeacher().setVisible(true);
        }else if (msg.equals("Register Student")) {
            new RegisterStudent(msg, msg).setVisible(true);
        } else if(msg.equals("Student Details")){
            new StudentDetails().setVisible(true);
        }else if(msg.equals("Teacher Details")){
            new TeacherDetails().setVisible(true);
        }
        else if(msg.equals("Result Slip")){
            new StudentResult().setVisible(true);
        }
        else if(msg.equals("Edit Course")){
            try {
                new SelectCourse().setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(msg.equals("Delete Course")){
            try {
                new SelectCourse("del").setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == b1){
            new Login().setVisible(true);
            this.dispose();
        }
        else if(msg.equals("Exit")){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new AdminPanel().setVisible(true);
    }
}

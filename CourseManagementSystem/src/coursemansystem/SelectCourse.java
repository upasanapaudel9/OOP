package coursemansystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SelectCourse extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1,l2,l3;
    private JButton b1, b2;
    private JComboBox<String> cb;
    
    SelectCourse() throws SQLException {  
        super("Select Course");
        
        new GetArrayValues();
        setSize(560,350);
        setLocation(200,200);
        setLayout(null);
      
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
      
        l1 = new JLabel("Edit Courses");
        l1.setBounds(20,20,400,30);
        l1.setFont(new Font("serif",Font.BOLD,40));
        add(l1);
      
        l2 = new JLabel("Select Course: ");
        l2.setBounds(20,80,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
      
        cb = new JComboBox<String>(GetArrayValues.courses);
        cb.setBounds(160,80,150,30);
        add(cb);
      
        b1 = new JButton("Select");
        b1.setBounds(200,150,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
    }
    
    SelectCourse(String del) throws SQLException {  
        super("Select Course");
        
        new GetArrayValues();
        setSize(560,350);
        setLocation(200,200);
        setLayout(null);
      
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
      
        l1 = new JLabel("Edit Courses");
        l1.setBounds(20,20,400,30);
        l1.setFont(new Font("serif",Font.BOLD,40));
        add(l1);
      
        l2 = new JLabel("Select Course: ");
        l2.setBounds(20,80,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
      
        cb = new JComboBox<String>(GetArrayValues.courses);
        cb.setBounds(160,80,150,30);
        add(cb);
      
        b2 = new JButton("Delete Course");
        b2.setBounds(200,150,140,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        l3 = new JLabel("If you delete course then, student and teacher will be deleted from that course");
        l3.setBounds(20,260,400,30);
        l3.setFont(new Font("serif",Font.BOLD,11));
        add(l3);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String course = (String) cb.getSelectedItem();
        if(e.getSource() == b1){
            System.out.println(course);
            new EdittCourse(course).setVisible(true);  
            this.dispose();
        }
        else if (e.getSource() == b2) {
            try {
                    Connect c1 = new Connect();
                    String s1 = "DELETE FROM `courses` WHERE courseName = '"+course+"'";
                    String s2 = "DELETE FROM `marks` WHERE course = '"+course+"'";
                    String s3 = "DELETE FROM `module` WHERE courseName = '"+course+"'";
                    String s4 = "UPDATE `studentlogin` SET `course`= NULL, `level` = NULL, `module1` = NULL, `module2` = NULL WHERE `course` = '"+course+"'";
                    String s5 = "UPDATE `teacherlogin` SET `course`= NULL, `level` = NULL WHERE `course` = '"+course+"'";
                    c1.s.executeUpdate(s1);
                    c1.s.executeUpdate(s2);
                    c1.s.executeUpdate(s3);
                    c1.s.executeUpdate(s4);
                    c1.s.executeUpdate(s5);
                    JOptionPane.showMessageDialog(null, "Course Deleted Sucessfully");
                    this.dispose();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }       
        }
    }
    
    public static void main(String[] args) throws SQLException {

        new SelectCourse().setVisible(true);
    }
}

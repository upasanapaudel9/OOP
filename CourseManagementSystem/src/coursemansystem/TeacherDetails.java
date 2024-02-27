package coursemansystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TeacherDetails extends JFrame implements ActionListener{
 
    private static final long serialVersionUID = 1L;
	private JLabel l1;
    private JTable t1;
    private JButton b1;
    private JTextField t2;
    private String x[] = {"Name","Email","Username","Date of Birth","Course"};
    private String y[][] = new String[20][5];
    private int i=0, j=0;

    TeacherDetails(){
        super("Teacher Details");
        setSize(1260,650);
        setLocation(200,200);
        setLayout(null);
        
        l1 = new JLabel("Enter username to delete Teacher:");
        l1.setBounds(50,360,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(400,360,200,30);
        add(t2);
        
        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100 ,30);
        add(b1);
            
        b1.addActionListener(this);
        
        try{
            Connect c1 = new Connect();
            String s1 = "select * from teacherlogin";
            ResultSet rs = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("dob");
                y[i][j++]=rs.getString("course");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
        
        b1.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){   
        Connect c1;
        try {
            c1 = new Connect();
            if(ae.getSource() == b1){
                try{
                    String a = t2.getText();
                    String q = "delete from teacherlogin where username = '"+a+"'";
                    c1.s.executeUpdate(q);
                    this.setVisible(false);
                    new StudentDetails().setVisible(true);
                }catch(Exception e){}
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException{
        new TeacherDetails().setVisible(true);
    }   
}

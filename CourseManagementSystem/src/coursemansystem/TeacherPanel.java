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

public class TeacherPanel extends JFrame implements ActionListener{
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3;
    JTable t1;
    JButton b1,b2,b3,b4,b5;
    JTextField t2, t3, t4;
    static String level, teacherUsername, course, module1, module2, teacherEmail, teacherName, teacherDOB;
    String x[] = {"Student Username", "Module Name", "Level","Marks"};
    String y[][] = new String[20][4];
    int i=0, j=0;
    String xx[] = {"Student Name","Student username","Course","Level"};
    String yy[][] = new String[20][4];
    int ii=0, jj=0;
    
    TeacherPanel() {
        super("Teacher Panel");

        try {
            Connect c3 = new Connect();
            String s2 = "SELECT * FROM logincheck ORDER BY No DESC LIMIT 1";
            ResultSet rs1  = c3.s.executeQuery(s2);
            while(rs1.next()){
                teacherUsername = rs1.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connect c2  = new Connect();
            String s1 = "select * from teacherlogin where username = '"+teacherUsername+"'";
            ResultSet rs  = c2.s.executeQuery(s1);
            while(rs.next()){
                teacherName=rs.getString("name");
                teacherEmail = rs.getString("email"); 
                teacherDOB = rs.getString("dob");
                course = rs.getString("course");
                level = rs.getString("level");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        if (level == null) {
            setSize(700,250);
            setLocation(200,200);
            setLayout(null);
            
            l1 = new JLabel("You haven't been Assigned to Module Yet");
            l1.setBounds(100,100,400,20);
            l1.setFont(new Font("serif",Font.BOLD,20));
            add(l1);
        } else {
            notNull();
        }
        
        getContentPane().setBackground(new Color(168, 98, 137)); // Set background color
    }
    
    TeacherPanel(String teacherUsername) {
        setSize(1260,650);
        setLocation(200,200);
        setLayout(null);
        
        l1 = new JLabel("Student's username:");
        l1.setBounds(50,360,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
    
        t2 = new JTextField();
        t2.setBounds(250,360,200,30);
        add(t2);
        
        l1 = new JLabel("Add student's marks:");
        l1.setBounds(50,400,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        t3 = new JTextField();
        t3.setBounds(250,400,200,30);
        add(t3);
        
        l1 = new JLabel("Enter Module Name:");
        l1.setBounds(50,440,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        t4 = new JTextField();
        t4.setBounds(250,440,200,30);
        add(t4);
        
        b1 = new JButton("Add Mark");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(590, 460, 100 ,30);
        add(b1);
            
        
        b1.addActionListener(this);
        
        try{
            Connect c1  = new Connect();
            String s1 = "select * from `marks` WHERE level = '"+level+"' AND course = '"+course+"'";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("moduleName");
                y[i][j++]=rs.getString("level");
                y[i][j++]=rs.getString("mark");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
    }
    
    TeacherPanel(String teacherUsername, String course) {
         setSize(650,250);
         setLocation(200,200);
         setLayout(null);
         l1 = new JLabel("Name: "+ teacherName.substring(0, 1).toUpperCase() + teacherName.substring(1));
         l1.setBounds(20,5,400,40);
         l1.setFont(new Font("serif",Font.BOLD,35));
         add(l1);
         
         l1 = new JLabel("Username: "+ teacherUsername);
         l1.setBounds(20,60,400,40);
         l1.setFont(new Font("serif",Font.BOLD,25));
         add(l1);
         
         l1 = new JLabel("Email: "+ teacherEmail);
         l1.setBounds(20,100,400,40);
         l1.setFont(new Font("serif",Font.BOLD,25));
         add(l1);
         
         l1 = new JLabel("Date of Birth: "+ teacherDOB);
         l1.setBounds(20,140,400,40);
         l1.setFont(new Font("serif",Font.BOLD,25));
         add(l1);
         
          b5 = new JButton("View Students");
          b5.setBackground(Color.BLACK);
          b5.setForeground(Color.WHITE);
          b5.setBounds(400, 135, 130 ,30);
          add(b5);
              
          
          b5.addActionListener(this);
          
          getContentPane().setBackground(new Color(168, 98, 137)); // Set background color
    }
    
    TeacherPanel(String teacherUsername, String course, String level){
        setSize(860,350);
        setLocation(200,200);
        setLayout(null);
        try {
            Connect c6 = new Connect();
            String s1 = "select * from studentlogin where course = '"+course+"' AND level = '"+level+"'";
            ResultSet rs  = c6.s.executeQuery(s1);
            while(rs.next()){
                yy[ii][jj++]=rs.getString("name");
                yy[ii][jj++]=rs.getString("username");
                yy[ii][jj++]=rs.getString("course");
                yy[ii][jj++]=rs.getString("level");

                ii++;
                jj=0;
            }
            t1 = new JTable(yy,xx);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,800,200);
        add(sp);
        getContentPane().setBackground(Color.WHITE);
        
        l1 = new JLabel("These students are only from Level "+level);
        l1.setBounds(20,220,400,40);
        l1.setFont(new Font("serif",Font.BOLD,15));
        add(l1);
        
    }
    
    public void notNull() {
        setSize(460,350);
        setLocation(200,200);
        setLayout(null);
        
        l1 = new JLabel("Welcome "+teacherName.substring(0, 1).toUpperCase() + teacherName.substring(1));
        l1.setBounds(20,20,400,40);
        l1.setFont(new Font("serif",Font.BOLD,35));
        add(l1);
        
        b3 = new JButton("Profile");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(180, 100, 120 ,30);
        add(b3); 
        b3.addActionListener(this); 
        
        
        b2 = new JButton("Add Marks");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180, 140, 120 ,30);
        add(b2);
           
        b2.addActionListener(this); 
       
        
        b4 = new JButton("Logout");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(180, 220, 120 ,30);
        add(b4);
        b4.addActionListener(this);
        
        b5 = new JButton("View Students");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(180, 180, 120 ,30);
        add(b5);
         
        b5.addActionListener(this);
        
        getContentPane().setBackground(new Color(168, 98, 137)); // Set background color
 }

  public void actionPerformed(ActionEvent ae){
        
        Connect c1;
        try {
            c1 = new Connect();
            if(ae.getSource() == b1){
                try{
                    String username = t2.getText();
                    String marks = t3.getText();
                    String moduleName = t4.getText();
                    String q = "UPDATE `marks` SET `moduleName`='"+moduleName+"',`mark`='"+marks+"' WHERE `username`= '"+username+"' AND moduleName = '"+moduleName+"'";
                    c1.s.executeUpdate(q);
                    this.setVisible(false);
                    new TeacherPanel(teacherUsername).setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
            } else if (ae.getSource() == b2) {
                new TeacherPanel(teacherUsername).setVisible(true);
            } else if (ae.getSource() == b3) {
                new TeacherPanel(teacherUsername, course).setVisible(true);
            } else if (ae.getSource() == b4) {
                new Login().setVisible(true);
                this.dispose();
            } else if (ae.getSource() == b5) {
                new TeacherPanel(teacherUsername, course, level).setVisible(true);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    
    }
        
    
    public static void main(String[] args){
        new TeacherPanel().setVisible(true);
    }
}

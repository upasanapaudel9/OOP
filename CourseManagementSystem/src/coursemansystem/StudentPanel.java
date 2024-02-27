package coursemansystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentPanel extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3;
    JTable jt;
    JButton b1,b2;
    JTextField t2, t3;
    JComboBox<?> cb, cb1;

    String level, username, course, module1, module2, mark1, mark2, Optmodule1, Optmodule2, Optmodule3, Optmodule4, StudentMod1, StudentMod2;
    String module3, module4, mark3, mark4, teacherName;
    String x[] = {"Student Name","Student Username","Course","Level","Marks"};
    String y[][] = new String[20][5];
    int i=0, j=0;
    
    StudentPanel(){
        super("Student Panel");
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
        try {
            Connect c3 = new Connect();
            String s2 = "SELECT * FROM logincheck ORDER BY No DESC LIMIT 1";
            ResultSet rs1  = c3.s.executeQuery(s2);
            while(rs1.next()){
                username = rs1.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try{
            Connect c2  = new Connect();
            String s1 = "select * from studentlogin where username = '"+username+"'";
            ResultSet rs  = c2.s.executeQuery(s1);
            while(rs.next()){
                course = rs.getString("course");
                level = rs.getString("level");
                StudentMod1 = rs.getString("module1");
                StudentMod2 = rs.getString("module2");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Connect c4  = new Connect();
            String s3 = "select * from marks where username = '"+username+"' ORDER BY moduleName DESC";
            ResultSet rs2  = c4.s.executeQuery(s3);
            int i = 0;
            while(rs2.next()){
                if (i == 0) {
                    module1 = rs2.getString("moduleName");
                    mark1 = rs2.getString("mark");
                } else if (i == 1) {
                    module2 = rs2.getString("moduleName");
                    mark2 = rs2.getString("mark");
                } else if (i == 2) {
                    module3 = rs2.getString("moduleName");
                    mark3 = rs2.getString("mark");
                } else if (i == 3) {
                    module4 = rs2.getString("moduleName");
                    mark4 = rs2.getString("mark");
                }
                i++;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        try {
            Connect c5 = new Connect();
            String s3 = "SELECT name FROM `teacherlogin` WHERE course = '"+course+"' AND LEVEL = '"+level+"'";
            ResultSet rs2  = c5.s.executeQuery(s3);
            while(rs2.next()){
                teacherName = rs2.getString("name");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Connect c4  = new Connect();
            String s3 = "SELECT `moduleName`FROM `module` WHERE Type = 'Optional' AND level = 6 AND courseName = '"+course+"'";
            ResultSet rs2  = c4.s.executeQuery(s3);
            int i = 0;
            while(rs2.next()){
                if (i == 0) {
                    Optmodule1 = rs2.getString("moduleName");
                } else if (i == 1) {
                    Optmodule2 = rs2.getString("moduleName");
                } else if (i == 2) {
                    Optmodule3 = rs2.getString("moduleName");
                } else if (i == 3) {
                    Optmodule4 = rs2.getString("moduleName");
                }
                i++;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        if (level == null) {
            setSize(700,250);
            setLocation(200,200);
            setLayout(null);
            
            l1 = new JLabel("You haven't been Resistered to Module Yet");
            l1.setBounds(100,100,400,20);
            l1.setFont(new Font("serif",Font.BOLD,20));
            add(l1);
        } else {
            if (level.equals("6")) {
                if (StudentMod1 == null && StudentMod2 == null) {
                    FirststuPanelLevel6();
                } else {
                    StudentPanelLevel6();
                }
            } else {
                notNull();
            }
        }
    }
    
    public void FirststuPanelLevel6() {
        setSize(1260,650);
        setLocation(200,200);
        setLayout(null);
        
        l1 = new JLabel("Your Username:"+username);
        l1.setBounds(30,10,800,60);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        
        l1 = new JLabel("Select the module to enroll from below:");
        l1.setBounds(30,50,800,60);
        l1.setFont(new Font("serif",Font.BOLD,15));
        add(l1);
        
        l1 = new JLabel("Module 1:");
        l1.setBounds(30,100,800,60);
        l1.setFont(new Font("serif",Font.BOLD,15));
        add(l1);
        
        String selectModule[]={Optmodule1,Optmodule2, Optmodule3, Optmodule4};        
        JComboBox <String> cb=new JComboBox <String> (selectModule);    
        cb.setBounds(120, 119,200,25);    
        add(cb);   
        
        l1 = new JLabel("Module 2:");
        l1.setBounds(30,169,800,60);
        l1.setFont(new Font("serif",Font.BOLD,15));
        add(l1);
        
        JComboBox <String> cb1=new JComboBox <String> (selectModule);    
        cb1.setBounds(120, 188,200,25);    
        add(cb1);   
        setLayout(null);    
        setSize(400,500);    
        setVisible(true);    
        
        b1 = new JButton("Add Modules");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150, 250, 120 ,30);
        add(b1);
        // b1.addActionListener(this);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                Connect c6;
                try {
                    c6 = new Connect();
                    String opMod1 = cb.getItemAt(cb.getSelectedIndex());
                    String opMod2 = cb1.getItemAt(cb1.getSelectedIndex());
                    String q = "UPDATE `studentlogin` SET `module1`='"+opMod1+"',`module2`='"+opMod2+"' WHERE username = '"+username+"'";
                    String sq= "INSERT INTO `marks`(`username`, `moduleName`, `level`, `course`) VALUES ('"+username+"','"+opMod1+"','"+level+"', '"+course+"')";
                    String sq1= "INSERT INTO `marks`(`username`, `moduleName`,`level`, `course`) VALUES ('"+username+"','"+opMod2+"', '"+level+"','"+course+"')";
                    c6.s.executeUpdate(q);
                    c6.s.executeUpdate(sq);
                    c6.s.executeUpdate(sq1);
                    setVisible(false); 
                    dispose(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }  
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void StudentPanelLevel6() {
        setSize(860,450);
        setLocation(200,200);
        setLayout(null);
        
        l1 = new JLabel("Your Username:"+username);
        l1.setBounds(50,40,800,60);
        l1.setFont(new Font("serif",Font.BOLD,30));
        add(l1);
        
        l1 = new JLabel("Your Level:"+level);
        l1.setBounds(50,80,800,60);
        l1.setFont(new Font("serif",Font.BOLD,30));
        add(l1);
        
        String data[][] = {{module1, mark1, teacherName},{module2, mark2, teacherName}, {module3, mark3, teacherName}, {module4, mark4, teacherName}};
        String column[] = {"Modules", "Marks", "Instructor"};
        JTable jt=new JTable(data,column);    
        jt.setBounds(400,400,800,900);          
        JScrollPane sp=new JScrollPane(jt); 
        sp.setBounds(40,200,800,100);
        add(sp); 
        
        l1 = new JLabel("Table with Marks:");
        l1.setBounds(60,141,300,60);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        
        l1 = new JLabel("If marks is empty, then instructor haven't marked your module.");
        l1.setBounds(20,141,400,400);
        l1.setFont(new Font("serif",Font.BOLD,13));
        add(l1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void notNull() {
        setSize(860,450);
        setLocation(200,200);
        setLayout(null);
        
        l1 = new JLabel("Your Username:"+username);
        l1.setBounds(50,40,800,60);
        l1.setFont(new Font("serif",Font.BOLD,30));
        add(l1);
        
        l1 = new JLabel("Your Level:"+level);
        l1.setBounds(50,80,800,60);
        l1.setFont(new Font("serif",Font.BOLD,30));
        add(l1);
        
        
        String data[][] = {{module1, mark1, teacherName},{module2, mark2, teacherName}};
        String column[] = {"Modules", "Marks", "Instructor"};
        JTable jt=new JTable(data,column);    
        jt.setBounds(400,400,800,900);          
        JScrollPane sp=new JScrollPane(jt); 
        sp.setBounds(40,200,800,60);
        add(sp); 
        
        l1 = new JLabel("Table with Marks:");
        l1.setBounds(60,141,300,60);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        
        l1 = new JLabel("If marks is empty, then instructor haven't marked your module.");
        l1.setBounds(20,141,400,400);
        l1.setFont(new Font("serif",Font.BOLD,13));
        add(l1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
        new StudentPanel().setVisible(true);
    }
}

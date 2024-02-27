package coursemansystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResultPrint extends JFrame implements ActionListener{
    
    private static final long serialVersionUID = 1L;
	private JLabel l1;
    private JTable t1;
    private JButton b1,b2;
    private String x[] = {"Module Name","Marks","Level"};
    private String y[][] = new String[20][3];
    private int i=0, j=0;
    private String name;
    public String username, course;
    
    ResultPrint(String username) {
        super("Student Result");
        this.username = username;
        try {
            Connect c1 = new Connect();
            String sq = "SELECT * FROM `studentlogin` where username = '"+username+"'";
            ResultSet rs  = c1.s.executeQuery(sq);
             while(rs.next()){
                 name = rs.getString("name");
             }
        }catch (SQLException e) {
            e.printStackTrace();
        }  
        
        if (name == null) {
            JOptionPane.showMessageDialog(null, "Enter registered username");
            setVisible(false);
            this.dispose();
        }
        else {
            setSize(1060,400);
            setLocation(200,200);
            setLayout(null);
            getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
            
            l1 = new JLabel("Student's name : "+name);
            l1.setBounds(20,40,400,30);
            l1.setFont(new Font("serif",Font.BOLD,25));
            add(l1);
            
            l1 = new JLabel("Student's Username : "+username);
            l1.setBounds(20,80,400,30);
            l1.setFont(new Font("serif",Font.BOLD,25));
            add(l1);
            
            try{
                Connect c2  = new Connect();
                String s1 = "select * from marks where username = '"+username+"'";
                ResultSet rs  = c2.s.executeQuery(s1);
                while(rs.next()){
                    y[i][j++]=rs.getString("moduleName");
                    y[i][j++]=rs.getString("mark");
                    y[i][j++]=rs.getString("level");
                    course =rs.getString("course"); 
                    i++;
                    j=0;
                }
                t1 = new JTable(y,x);
            }catch(Exception e){
                e.printStackTrace();
            }
            JScrollPane sp = new JScrollPane(t1);
            sp.setBounds(20,120,1000,100);
            add(sp);
            
            b2 = new JButton("Level Up Student");
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.setBounds(400, 250, 170 ,30);
            add(b2);
            b2.addActionListener(this);
            
            b1 = new JButton("Print Result");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(420, 290, 110 ,30);
            add(b1);
            b1.addActionListener(this);
        }
        
    }
    
    public static void main(String[] args) {
        new ResultPrint("a").setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
        MessageFormat header = new MessageFormat("Name: "+ name);
        
        try {
            t1.print(JTable.PrintMode.FIT_WIDTH, header, null);
        }catch (Exception er) {
            JOptionPane.showMessageDialog(null, er);
        }
        }
        else if (e.getSource() == b2) {
            new RegisterStudent(username, course).setVisible(true);
            this.dispose();
        }
        
    }

}

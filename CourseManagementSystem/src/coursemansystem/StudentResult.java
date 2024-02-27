package coursemansystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentResult extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
	private JLabel l1,l2,l3;
    private JTable t1;
    private JButton b1;
    private JTextField t2;
    private String x[] = {"Name","Username","Course","Level"};
    private String y[][] = new String[20][4];
    private int i=0, j=0;
    
    StudentResult() {
        super("Student Result");
        setSize(1060,550);
        setLocation(200,200);
        setLayout(null);
        l1 = new JLabel("Students List");
        l1.setBounds(20,20,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        try{
            Connect c1  = new Connect();
            String s1 = "select * from studentlogin";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("course");
                y[i][j++]=rs.getString("level");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,60,1000,200);
        add(sp);
        
        l2 = new JLabel("Enter Student's username for result");
        l2.setBounds(20,260,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        l3 = new JLabel("Username: ");
        l3.setBounds(20,300,400,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);
        
        t2 = new JTextField();
        t2.setBounds(155,303,200,30);
        add(t2);
        
        b1 = new JButton("Get Result");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450, 390, 100 ,30);
        add(b1);
        b1.addActionListener(this);
        
        getContentPane().setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            String username = t2.getText();
            System.out.println(username);
            if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Username from list above");
                setVisible(false);
                new StudentResult().setVisible(true);
            }
            else {
                new ResultPrint(username).setVisible(true);    
                this.dispose();
            }
        }
    }
    
    public static void main(String[] args) {
        new StudentResult().setVisible(true);
    }
}

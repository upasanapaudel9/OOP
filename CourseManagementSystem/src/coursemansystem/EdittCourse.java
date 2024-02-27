package coursemansystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;


public class EdittCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblModuleName_2;
	private JTextField textField_3;
	private JLabel lblModuleName_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_3;
	private JLabel lblModuleName_4;
	private JLabel lblNewLabel_4;
	private JLabel lblModuleName_5;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblModuleName_6;
	private JLabel lblModuleName_7;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblNewLabel_5;
	private JLabel lblModuleName_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblModuleName_9;
	private JLabel lblModuleName_10;
	private JLabel lblModuleName_11;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel lblNewLabel_6;
	private JLabel lblModuleName_12;
	private JLabel lblModuleName_13;
	private JTextField textField_13;
	private JTextField textField_14;
	private JLabel lblModuleName_14;
	private JLabel lblModuleName_15;
	private JTextField textField_15;
	private JTextField textField_16;
	private JLabel lblModuleName_16;
	private JLabel lblModuleName_17;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private String L4mn1, L4mc1, L4mn2, L4mc2, L5mn1, L5mc1, L5mn2, L5mc2, L6mn1, L6mc1, L6mn2, L6mc2, L6mn3, L6mc3, L6mn4, L6mc4, L6mn5, L6mc5, L6mn6, L6mc6;

	/**
	 * Create the frame.
	 */
	public EdittCourse(String course) {
		setTitle("Add Course");
		setBounds(100, 100, 548, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Set background color here
        contentPane.setBackground(new Color(168, 98, 137)); // Mixture of pink and dark purple
		setContentPane(contentPane);
		
		try {
			Connect c2= new Connect();
			String s1 = "select * from module where courseName = '"+course+"' AND level = '"+4+"' ORDER BY moduleName ASC";
            ResultSet rs  = c2.s.executeQuery(s1);
            int i = 0;
            while(rs.next()){
            	if (i == 0) {
            		L4mn1 = rs.getString("moduleName");
            		L4mc1 = rs.getString("moduleCode");
            	}
            	else if (i == 1) {
            		L4mn2 = rs.getString("moduleName");
            		L4mc2 = rs.getString("moduleCode");
            	}
            	i++;
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
            
    		try {
    			Connect c3= new Connect();
    			String s3 = "select * from module where courseName = '"+course+"' AND level = '"+5+"' ORDER BY moduleName ASC";
                ResultSet rs1  = c3.s.executeQuery(s3);
                int i1 = 0;
                while(rs1.next()){
                	if (i1 == 0) {
                		L5mn1 = rs1.getString("moduleName");
                		L5mc1 = rs1.getString("moduleCode");
                	}
                	else if (i1 == 1) {
                		L5mn2 = rs1.getString("moduleName");
                		L5mc2 = rs1.getString("moduleCode");
                	}
                	i1++;
                }
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
                
        		try {
        			Connect c4= new Connect();
        			String s4 = "select * from module where courseName = '"+course+"' AND level = '"+6+"' AND Type = 'Mandatory' ORDER BY moduleName ASC";
                    ResultSet rs2  = c4.s.executeQuery(s4);
                    int i2 = 0;
                    while(rs2.next()){
                    	if (i2 == 0) {
                    		L6mn1 = rs2.getString("moduleName");
                    		L6mc1 = rs2.getString("moduleCode");
                    	}
                    	else if (i2 == 1) {
                    		L6mn2 = rs2.getString("moduleName");
                    		L6mc2 = rs2.getString("moduleCode");
                    	}
                    	i2++;
                    }
        		}catch(Exception e) {
        			e.printStackTrace();
        		}
                    
            		try {
            			Connect c5= new Connect();
            			String s5 = "select * from module where courseName = '"+course+"' AND level = '"+6+"' AND Type = 'Optional' ORDER BY moduleName ASC";
                        ResultSet rs3  = c5.s.executeQuery(s5);
                        int i3 = 0;
                        while(rs3.next()){
                        	if (i3 == 0) {
                        		L6mn3 = rs3.getString("moduleName");
                        		L6mc3 = rs3.getString("moduleCode");
                        	}
                        	else if (i3 == 1) {
                        		L6mn4 = rs3.getString("moduleName");
                        		L6mc4 = rs3.getString("moduleCode");
                        	}
                        	else if (i3 == 2) {
                        		L6mn5 = rs3.getString("moduleName");
                        		L6mc5 = rs3.getString("moduleCode");
                        	}
                        	else if (i3 == 3) {
                        		L6mn6 = rs3.getString("moduleName");
                        		L6mc6 = rs3.getString("moduleCode");
                        	}
                        	i3++;
                        }
            		}catch(Exception e) {
			e.printStackTrace();
		}
		
		lblNewLabel = new JLabel("Course Name");
		
		textField = new JTextField(course);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modules");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_1 = new JTextField(L4mn1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("For Level 4");
		
		JLabel lblModuleName = new JLabel("Module Name");
		
		JLabel lblModuleName_1 = new JLabel("Module Code");
		
		textField_2 = new JTextField(L4mc1);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Edit Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
                     Connect c1 = new Connect();
                     String name = textField.getText();
                     String l4Mod1 = textField_1.getText();
                     String l4ModCode1 = textField_2.getText();
                     String l4Mod2 = textField_3.getText();
                     String l4ModCode2 = textField_4.getText();
                     
                   String l5Mod1 = textField_5.getText();
                   String l5ModCode1 = textField_7.getText();
                   String l5Mod2 = textField_6.getText();
                   String l5ModCode2 = textField_8.getText();
                     
                   String l6Mod1Man = textField_9.getText();
                   String l6ModCode1Man = textField_11.getText();
                   String l6Mod2Man = textField_10.getText();
                   String l6ModCode2Man = textField_12.getText();
                     
                   String l6Mod1Opt = textField_13.getText();
                   String l6ModCode1Opt = textField_15.getText();
                   String l6Mod2Opt = textField_14.getText();
                   String l6ModCode2Opt = textField_16.getText();
                   
                   String l6Mod1Opt1 = textField_17.getText();
                   String l6ModCode1Opt1 = textField_19.getText();
                   String l6Mod2Opt1 = textField_18.getText();
                   String l6ModCode2Opt1 = textField_20.getText();
                   
                   String mk1 = "UPDATE `marks` SET `moduleName`='"+l4Mod1+"',`course`='"+name+"' WHERE `moduleName` = '"+L4mn1+"'";
                   String mk2 = "UPDATE `marks` SET `moduleName`='"+l4Mod2+"',`course`='"+name+"' WHERE `moduleName` = '"+L4mn2+"'";
                   String mk3 = "UPDATE `marks` SET `moduleName`='"+l5Mod1+"',`course`='"+name+"' WHERE `moduleName` = '"+L5mn1+"'";
                   String mk4 = "UPDATE `marks` SET `moduleName`='"+l5Mod2+"',`course`='"+name+"' WHERE `moduleName` = '"+L5mn2+"'";
                   String mk5 = "UPDATE `marks` SET `moduleName`='"+l6Mod1Man+"',`course`='"+name+"' WHERE `moduleName` = '"+L6mn1+"'";
                   String mk6 = "UPDATE `marks` SET `moduleName`='"+l6Mod2Man+"',`course`='"+name+"' WHERE `moduleName` = '"+L6mn2+"'";
                   String mk7 = "UPDATE `marks` SET `moduleName`='"+l6Mod1Opt+"',`course`='"+name+"' WHERE `moduleName` = '"+L6mn3+"'";
                   String mk8 = "UPDATE `marks` SET `moduleName`='"+l6Mod2Opt+"',`course`='"+name+"' WHERE `moduleName` = '"+L6mn4+"'";
                   String mk9 = "UPDATE `marks` SET `moduleName`='"+l6Mod1Opt1+"',`course`='"+name+"' WHERE `moduleName` = '"+L6mn5+"'";
                   String mk10 = "UPDATE `marks` SET `moduleName`='"+l6Mod2Opt1+"',`course`='"+name+"' WHERE `moduleName` = '"+L6mn6+"'";
                     
                   String a = "UPDATE `courses` SET `courseName`='"+name+"' WHERE courseName = '"+course+"'";
//                   
                   String l4a1 = "UPDATE `module` SET `moduleCode`='"+l4ModCode1+"',`moduleName`='"+l4Mod1+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L4mn1+"'";
                   String l4a2 = "UPDATE `module` SET `moduleCode`='"+l4ModCode2+"',`moduleName`='"+l4Mod2+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L4mn2+"'";
                   
                  String l5a1 = "UPDATE `module` SET `moduleCode`='"+l5ModCode1+"',`moduleName`='"+l5Mod1+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L5mn1+"'";
                  String l5a2 = "UPDATE `module` SET `moduleCode`='"+l5ModCode2+"',`moduleName`='"+l5Mod2+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L5mn2+"'";
                   
                   String l6a1M = "UPDATE `module` SET `moduleCode`='"+l6ModCode1Man+"',`moduleName`='"+l6Mod1Man+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L6mn1+"'";
                   String l6a2M = "UPDATE `module` SET `moduleCode`='"+l6ModCode2Man+"',`moduleName`='"+l6Mod2Man+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L6mn2+"'";
                   
                   String l6a1O = "UPDATE `module` SET `moduleCode`='"+l6ModCode1Opt+"',`moduleName`='"+l6Mod1Opt+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L6mn3+"'";
                   String l6a2O = "UPDATE `module` SET `moduleCode`='"+l6ModCode2Opt+"',`moduleName`='"+l6Mod2Opt+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L6mn4+"'";
                   
                   String l6a1O1 = "UPDATE `module` SET `moduleCode`='"+l6ModCode1Opt1+"',`moduleName`='"+l6Mod1Opt1+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L6mn5+"'";
                   String l6a2O1 = "UPDATE `module` SET `moduleCode`='"+l6ModCode2Opt1+"',`moduleName`='"+l6Mod2Opt1+"',`courseName`='"+name+"' WHERE `moduleName` = '"+L6mn6+"'";
                   
                   String sq= "UPDATE `studentlogin` SET `course`='"+name+"' WHERE `course`= '"+course+"'";
                   String sqq = "UPDATE `teacherlogin` SET `course`='"+name+"' WHERE `course`= '"+course+"'"; 
                   
                   
                   System.out.println(l4Mod1);

                   c1.s.executeUpdate(mk1);
                   c1.s.executeUpdate(mk2);
                   c1.s.executeUpdate(mk3);
                   c1.s.executeUpdate(mk4);
                   c1.s.executeUpdate(mk5);
                   c1.s.executeUpdate(mk6);
                   c1.s.executeUpdate(mk7);
                   c1.s.executeUpdate(mk8);
                   c1.s.executeUpdate(mk9);
                   c1.s.executeUpdate(mk10);
                   c1.s.executeUpdate(a);
                   c1.s.executeUpdate(l4a1);
                   c1.s.executeUpdate(l4a2);
                   c1.s.executeUpdate(l5a1);
                   c1.s.executeUpdate(l5a2);
                   c1.s.executeUpdate(l6a1M);
                   c1.s.executeUpdate(l6a2M);
                   c1.s.executeUpdate(l6a1O);
                   c1.s.executeUpdate(l6a2O);
                   c1.s.executeUpdate(l6a1O1);
                   c1.s.executeUpdate(l6a2O1);
                   c1.s.executeUpdate(sq);
                   c1.s.executeUpdate(sqq);

                 } catch (SQLException ex) {
                     ex.printStackTrace();
                 }
				 JOptionPane.showMessageDialog(null, "Course Edited Successfully");
	             setVisible(false);
			}
		});
		
		lblModuleName_2 = new JLabel("Module Name");
		
		textField_3 = new JTextField(L4mn2);
		textField_3.setColumns(10);
		
		lblModuleName_3 = new JLabel("Module Code");
		
		textField_4 = new JTextField(L4mc2);
		textField_4.setColumns(10);
		
		lblNewLabel_3 = new JLabel("For Level 5");
		
		lblModuleName_4 = new JLabel("Module Name");
		
		lblNewLabel_4 = new JLabel("For Level 6");
		
		lblModuleName_5 = new JLabel("Module Name");
		
		textField_5 = new JTextField(L5mn1);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField(L5mn2);
		textField_6.setColumns(10);
		
		lblModuleName_6 = new JLabel("Module Code");
		
		lblModuleName_7 = new JLabel("Module Code");
		
		textField_7 = new JTextField(L5mc1);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField(L5mc2);
		textField_8.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Mandatory Modules");
		
		lblModuleName_8 = new JLabel("Module Name");
		
		textField_9 = new JTextField(L6mn1);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField(L6mn2);
		textField_10.setColumns(10);
		
		lblModuleName_9 = new JLabel("Module Code");
		
		lblModuleName_10 = new JLabel("Module Code");
		
		lblModuleName_11 = new JLabel("Module Name");
		
		textField_11 = new JTextField(L6mc1);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField(L6mc2);
		textField_12.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Optional Modules");
		
		lblModuleName_12 = new JLabel("Module Name");
		
		lblModuleName_13 = new JLabel("Module Name");
		
		textField_13 = new JTextField(L6mn3);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField(L6mn4);
		textField_14.setColumns(10);
		
		lblModuleName_14 = new JLabel("Module Code");
		
		lblModuleName_15 = new JLabel("Module Code");
		
		textField_15 = new JTextField(L6mc3);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField(L6mc4);
		textField_16.setColumns(10);
		
		lblModuleName_16 = new JLabel("Module Name");
		
		lblModuleName_17 = new JLabel("Module Name");
		
		textField_17 = new JTextField(L6mn5);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField(L6mn6);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField(L6mc5);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField(L6mc6);
		textField_20.setColumns(10);
		
		JLabel lblModuleName_15_1 = new JLabel("Module Code");
		
		JLabel lblModuleName_15_2 = new JLabel("Module Code");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(2)
													.addComponent(lblModuleName, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblModuleName_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
											.addGap(16)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_3, Alignment.TRAILING)
												.addComponent(textField_1, Alignment.TRAILING))
											.addGap(44)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblModuleName_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblModuleName_3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
											.addGap(39)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblModuleName_4, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModuleName_5, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModuleName_8, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModuleName_11, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
									.addGap(22))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblModuleName_15_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModuleName_15_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModuleName_15, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModuleName_14, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_11, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_12, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_16, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_19, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_20, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModuleName_6, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_7, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addGap(171))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(216))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblModuleName_17, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblModuleName_16, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblModuleName_13, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblModuleName_12, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(130)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModuleName_10, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_9, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addGap(146))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModuleName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModuleName_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblModuleName_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblModuleName_7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_9, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblModuleName_11, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblModuleName_10, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModuleName_12, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModuleName_14, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModuleName_13, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModuleName_15, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModuleName_16, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModuleName_17, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModuleName_15_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModuleName_15_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(46))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}


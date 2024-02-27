package coursemansystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddCourse extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JButton btnNewButton;

    public AddCourse() { //constructor (encapsulates GUI components)
        setTitle("Add Course");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 590);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(168, 98, 137));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Course Name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(52, 46, 89, 17);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(196, 43, 231, 23);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Modules");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(52, 90, 74, 22);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(52, 123, 192, 23);
        contentPane.add(textField_1);

        JLabel lblModuleName = new JLabel("Module Name");
        lblModuleName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblModuleName.setBounds(52, 153, 99, 17);
        contentPane.add(lblModuleName);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(299, 123, 128, 23);
        contentPane.add(textField_2);

        JLabel lblModuleName_1 = new JLabel("Module Code");
        lblModuleName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblModuleName_1.setBounds(299, 153, 89, 17);
        contentPane.add(lblModuleName_1);

        btnNewButton = new JButton("Add Course");
        btnNewButton.addActionListener(this);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(196, 362, 120, 30);
        contentPane.add(btnNewButton);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnNewButton) {
            try {
                Connect c1 = new Connect();
                String name = textField.getText();
                String module = textField_1.getText();
                String moduleCode = textField_2.getText();

                if (name.isEmpty() || module.isEmpty() || moduleCode.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String insertCourseQuery = "INSERT INTO courses (CourseName) VALUES ('" + name + "')";
                String insertModuleQuery = "INSERT INTO module (moduleName, moduleCode, courseName) VALUES ('" + module + "', '" + moduleCode + "', '" + name + "')";

                c1.s.executeUpdate(insertCourseQuery);
                c1.s.executeUpdate(insertModuleQuery);

                JOptionPane.showMessageDialog(this, "Course and module added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while adding the course", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

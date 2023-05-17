package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AddStudentListener;
import model.StudentManager;

public class AddStudent extends JFrame{
	
	private JTextField txtStudentId;
	private JTextField txtStudentName;
	private JButton stdSubmit;
	
	public AddStudent(StudentManager sm) {
		
		JLabel lblId = new JLabel("Student ID:");
		JLabel lblName = new JLabel("Name:  ");
		txtStudentId = new JTextField(20);
		txtStudentName = new JTextField(20);
		
		stdSubmit = new JButton("Submit student data");
		stdSubmit.addActionListener(new AddStudentListener(this, sm));

        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        add(lblId);
        add(txtStudentId);
        add(lblName);
        add(txtStudentName);
        add(stdSubmit);
		
	}
	
	public String getStudentId() {
		return this.txtStudentId.getText();
	}
	
	public String getStudentName() {
		return this.txtStudentName.getText();
	}

}

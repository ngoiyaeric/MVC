package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.DisplayStudentListener;
import model.StudentManager;

public class DisplayStudent extends JFrame{
	
	private JTextField txtStudentId;
	private JTextField txtStudentName;
	private JButton getStudent;
	private JButton okButton;
	
	public DisplayStudent(StudentManager sm) {
		JLabel lblId = new JLabel("Student ID:");
		JLabel lblName = new JLabel("Name:  ");
		txtStudentId = new JTextField(20);
		txtStudentName = new JTextField(20);
		
		DisplayStudentListener dsl = new DisplayStudentListener(this, sm);
		getStudent = new JButton("Search");
		getStudent.addActionListener(dsl);
	
		okButton = new JButton("Click OK");
		okButton.addActionListener(dsl);
		
	    FlowLayout layout = new FlowLayout();
	    setLayout(layout);
	    add(lblId);
	    add(txtStudentId);
	    add(getStudent);
	    add(lblName);
	    add(txtStudentName);
	    add(okButton);
	}
	
	public JButton getStudentButton() {
		return this.getStudent;
	}
	
	public JButton getOKButton() {
		return this.okButton;
	}
	
	public String getId() {
		return this.txtStudentId.getText();
	}
	
	public void setName(String name) {
		this.txtStudentName.setText(name);
	}

}

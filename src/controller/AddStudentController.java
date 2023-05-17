package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StudentManager;
import view.AddStudent;

public class AddStudentController implements ActionListener {
	private StudentManager studentManager;
	public AddStudentController(StudentManager sm) {
		this.studentManager = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AddStudent ge = new AddStudent(this.studentManager);
	    ge.setTitle("Add Student");
	    ge.setSize(350,150);
	    ge.setVisible(true);	
	}

}

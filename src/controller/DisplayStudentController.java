package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StudentManager;
import view.DisplayStudent;

public class DisplayStudentController implements ActionListener{
	private StudentManager studentManager;
	public DisplayStudentController(StudentManager sm) {
		this.studentManager = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DisplayStudent ge = new DisplayStudent(this.studentManager);
	    ge.setTitle("Display Student");
	    ge.setSize(400,150);
	    ge.setVisible(true);	
	}
}

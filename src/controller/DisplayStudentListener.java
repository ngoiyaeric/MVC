package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Student;
import model.StudentManager;
import view.DisplayStudent;

public class DisplayStudentListener implements ActionListener{

	private DisplayStudent displayStudent;
	private Student student;
	private StudentManager studentManager;
	
	
	public DisplayStudentListener(DisplayStudent displayStudent, StudentManager sm) {
		this.displayStudent = displayStudent;
		this.student = new Student();
		this.studentManager = sm;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource().equals(displayStudent.getStudentButton())) {
			
		    this.student = this.studentManager.getStudent(this.displayStudent.getId());
		    this.displayStudent.setName(this.student.getName());
		    //System.out.println(this.student.getName());
		    this.displayStudent.invalidate();
		    this.displayStudent.validate();
		    this.displayStudent.repaint();
		} else 
			this.displayStudent.setVisible(false);
	}

}


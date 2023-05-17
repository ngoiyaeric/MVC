package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Student;
import model.StudentManager;
import view.AddStudent;

public class AddStudentListener implements ActionListener{

	private AddStudent addStudent;
	private Student newStudent;
	private StudentManager studentManager;
	
	
	public AddStudentListener(AddStudent addStudent, StudentManager sm) {
		this.addStudent = addStudent;
		this.newStudent = new Student();
		this.studentManager = sm;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.newStudent.setId(addStudent.getStudentId());
		this.newStudent.setName(addStudent.getStudentName());
		this.studentManager.add(this.newStudent);
		//System.out.println(this.studentManager.students);
		//System.out.println(this.studentManager.getStudent(addStudent.getStudentId()).getName());
		addStudent.setVisible(false);
	}

}

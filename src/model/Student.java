package model;

import java.io.Serializable;

public class Student implements IDed, Serializable {
	
	private String studentId;
	private String name;
		
	public Student() {
	}
	
	public String getId() {
		return studentId;
	}

	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.studentId = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

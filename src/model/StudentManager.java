package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StudentManager implements Serializable {
	
	private final String DATA_PATH = "students.bin";
	private Map<String, Student> students;
	
	public StudentManager() throws ClassNotFoundException, IOException {
		loadFromFile(DATA_PATH);
	}
	
	public void add(Student student) {
		students.put(student.getId(), student);
	}
	
	public Student getStudent(String studentId) {
		return students.get(studentId);
	}
	
    public void saveToFile(String filePath) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(students);
        output.close();
    }
    
    public void loadFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        this.students = (Map<String, Student>) input.readObject();
        input.close();
    }

}

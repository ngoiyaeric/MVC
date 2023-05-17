package app;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import model.StudentManager;
import controller.AddStudentController;
import controller.DisplayStudentController;

public class App extends JFrame {
	private final String DATA_PATH = "students.bin";
	private StudentManager studentManager;
	
	public App() throws ClassNotFoundException, IOException {
		super("Student App");
		this.studentManager = new StudentManager();
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu fileMenu = new JMenu("Student");
		fileMenu.setMnemonic('S');
		
		Action addStudentAction = new AbstractAction("Add Student") {
			public void actionPerformed(ActionEvent e) {

			}
		};
		
		addStudentAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
		
		Action displayStudentAction = new AbstractAction("Display Student") {
			public void actionPerformed(ActionEvent e) {
			}
		};
		
		displayStudentAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_DOWN_MASK));
		
		
		JMenuItem addStudentItem = new JMenuItem("Add Student");
		addStudentItem.setMnemonic('A');
		addStudentItem.addActionListener(new AddStudentController(this.studentManager)); 
		addStudentItem.setAction(addStudentAction);
		fileMenu.add(addStudentItem);
		
		JMenuItem displayStudentItem = new JMenuItem("Display Student");
		displayStudentItem.setMnemonic('D');
		displayStudentItem.addActionListener(new DisplayStudentController(this.studentManager)); 
		displayStudentItem.setAction(displayStudentAction);
		fileMenu.add(displayStudentItem);
		
		JMenuItem exitItem = new JMenuItem("Save & Exit");
		exitItem.setMnemonic('x');
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					studentManager.saveToFile(DATA_PATH);
				} catch (IOException e) {
					System.out.println(e.getStackTrace());
				}
				System.exit(0);
			}
			
		});
		fileMenu.add(exitItem);
		bar.add(fileMenu);	
		setSize(500,200);
		setVisible(true);
		
	}
	
	

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		App app = new App();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}


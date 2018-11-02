/**
 * 
 */
package edu.sollers.javaprog.resumerbuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

/**
 * @author praka
 *
 */
public class ResumeBuilderController {

	private static ResumeBuilderController instance;
	private static Connection conn;
	private ResumeModel resume;



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Create and set up the main window or frame
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Resume Builder");
		mainFrame.setSize(600, 600);

		//Create and set up the view
		ResumeBuilderView rb = new ResumeBuilderView();
		rb.addComponents(mainFrame);

		//Display the window.
		mainFrame.setVisible(true);
	}

	private ResumeBuilderController() {
		resume = new ResumeModel();
	}

	

	public static ResumeBuilderController getInstance() {
		if (instance == null)
			instance = new ResumeBuilderController();
		return instance;
	}
	
	public void setObjective(String objective) {
		getModel().setObjective(objective);
	}
	
	public void setEducation(String schoolName, String schoolCity, String schoolState, String degree, String major, String gradMonth, String gradYear, boolean isAnticipated) {
		getModel().setEducation(schoolName, schoolCity, schoolState, degree, major, gradMonth, gradYear, isAnticipated);
	}

	public ResumeModel getModel() {
		return resume;
	}

	public void save() throws Exception{
		resume.save();
	}

	public void clear() {
		resume.clear();
	}

	public Connection getConnection() {
		if (conn == null) {
			connect();
		}
		return conn;
	}
	
	public static void connect() {
		try {
			String url = "jdbc:sqlite:resume.db";
			conn = DriverManager.getConnection(url);

			System.out.println("\nConnection made\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

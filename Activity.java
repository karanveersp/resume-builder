/**
 * 
 */
package edu.sollers.javaprog.resumerbuilder;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Karanveer
 *
 */
public class Activity extends ResumeElement {
	private String actvity;

	/**
	 * Constructor with parameter
	 * @param membership String
	 */
	public Activity(String actvity) {
		this.actvity = actvity;
	}

	// Static methods cannot be overridden

	public static String getTableName() {
		return "actvity";
	}

	public static String getFieldOrder() {
		return "actvity";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	@Override
	public String getInsertStatement() {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + actvity +  "')";
	}

	@Override
	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			int row = stmt.executeUpdate(getInsertStatement());
			if (row == 1)
				System.out.println("Inserted actvity object into table");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the actvity
	 */
	public String getActivity() {
		return actvity;
	}

	@Override
	public String toString() {
		return "Actvity: " + actvity + "\n";
	}

}

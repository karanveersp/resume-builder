/**
 * 
 */
package edu.sollers.javaprog.resumerbuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Karanveer
 *
 */
public class Education extends ResumeElement {
	private String schoolName;
	private String schoolCity;
	private String schoolState;
	private String degree;
	private String major;
	private String gradMonth;
	private	int    gradYear;
	private boolean isAnticipated;
	
	/**
	 * @param schoolName
	 * @param schoolCity
	 * @param schoolState
	 * @param degree
	 * @param major
	 * @param graduationMonth
	 * @param gratuationYear
	 * @param isAnticipated
	 */
	public Education(String schoolName, String schoolCity, String schoolState, String degree, String major,
			String gradMonth, int gradYear, boolean isAnticipated) {
		super();
		this.schoolName = schoolName;
		this.schoolCity = schoolCity;
		this.schoolState = schoolState;
		this.degree = degree;
		this.major = major;
		this.gradMonth = gradMonth;
		this.gradYear = gradYear;
		this.isAnticipated = isAnticipated;
	}
	
	public static String getTableName() {
		return "education";
	}
	
	public static String getFieldOrder() {
		return "id, school_name, school_city, school_state, degree, major, grad_month, grad_year, is_anticipated";
	}
	
	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	public String getInsertStatement(int id) {
		
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values (" 
				+ id			+ ", '"
				+ schoolName 	+ "', '"
				+ schoolCity 	+ "', '"
				+ schoolState 	+ "', '"
				+ degree 		+ "', '"
				+ major			+ "', '"
				+ gradMonth		+ "', "
				+ gradYear		+ ", "
				+ isAnticipated
				+ ")";
	}

	public String getUpdateStatement() {
		return "update " + getTableName() + " set "
				+ "school_name = '" + schoolName  + "', ";
	}

	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(getSelectClause());
			while (rs.next()) {
				if (schoolName.equals(rs.getString(2)) && schoolCity.equals(rs.getString(3))) {
					
					// school exists in table so perform an update
					
				}
			}
				System.out.println("Inserted Education object into table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//----------------------------
	// Getters/Setters
	//----------------------------

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the schoolCity
	 */
	public String getSchoolCity() {
		return schoolCity;
	}

	/**
	 * @param schoolCity the schoolCity to set
	 */
	public void setSchoolCity(String schoolCity) {
		this.schoolCity = schoolCity;
	}

	/**
	 * @return the schoolState
	 */
	public String getSchoolState() {
		return schoolState;
	}

	/**
	 * @param schoolState the schoolState to set
	 */
	public void setSchoolState(String schoolState) {
		this.schoolState = schoolState;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @return the gradMonth
	 */
	public String getGradMonth() {
		return gradMonth;
	}

	/**
	 * @param gradMonth the gradMonth to set
	 */
	public void setGradMonth(String gradMonth) {
		this.gradMonth = gradMonth;
	}

	/**
	 * @return the gradYear
	 */
	public int getGradYear() {
		return gradYear;
	}

	/**
	 * @param gradYear the gradYear to set
	 */
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}

	/**
	 * @return the isAnticipated
	 */
	public boolean isAnticipated() {
		return isAnticipated;
	}

	/**
	 * @param isAnticipated the isAnticipated to set
	 */
	public void setAnticipated(boolean isAnticipated) {
		this.isAnticipated = isAnticipated;
	}
	
	@Override
	public String toString() {
		return "School Name: " + schoolName + "\n"
				+ "School City: " + schoolCity + "\n"
				+ "School State: " + schoolState + "\n"
				+ "Degree: " + degree + "\n"
				+ "Major: " + major + "\n"
				+ "Grad Month: " + gradMonth + "\n"
				+ "Grad Year: " + gradYear + "\n"
				+ "IsAnticipated: " + isAnticipated + "\n";
	}

	
	
	
	
	
	
}

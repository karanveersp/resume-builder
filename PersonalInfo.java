package edu.sollers.javaprog.resumerbuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonalInfo extends ResumeElement {
	
	private String firstName;
	private String lastName;
	private String email;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private int zip;
	
	
	
	
	/**
	 * Constructor with parameters
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param street1
	 * @param street2
	 * @param city
	 * @param state
	 * @param zip
	 */
	public PersonalInfo(String firstName, String lastName, String email, String street1, String street2, String city, String state,
			int zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the street1
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * @param street the street1 to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * @return the street2
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * @param street2 the street2 to set
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
    public static String getFieldOrder() {
    	return "first_name, last_name, email, street1, street2, city, state, zip";
    }
    
    public static String getTableName() {
    	return "personal_info";
    }
    
    public static String getSelectClause() {
    	return "select " + getFieldOrder() + " from " + getTableName();
    }
    
    public String getInsertStatement() {
    	return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('"  
    		+	firstName	    + "', '"
    		+	lastName	    + "', '" 
    		+	email			+ "', '"			    		
    		+	street1			+ "', '"
    		+	street2			+ "', '"
    		+	city			+ "', '"
    		+	state			+ "', '"	
    		+	zip				+ "')";
    }
    
    public String getUpdateStatement() {
    	return "update " + getTableName() + " set "
    			+ "first_name = '" + firstName + "', "
    			+ "last_name = '" + lastName + "', "
    			+ "email = '" + email + "', "
    			+ "street1 = '" + street1 + "', "
    			+ "street2 = '" + street2 + "', "
    			+ "city = '" + city + "', "
    			+ "state = '" + state + "', "
    			+ "zip = '" + zip + "'";
    }
    
    public void save() {
    	try {
    		Statement stmt = getConnection().createStatement();
    		ResultSet rs = stmt.executeQuery(getSelectClause());
    		if (rs.next()) {
    			// update
    			stmt.executeUpdate(getUpdateStatement());
    		}
    		else {
    			// insert
    			stmt.executeUpdate(getInsertStatement());
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * Return string representation of object
     */
    @Override
    public String toString() {
		String val;
		val = 		"firstName: " + firstName + "\n"
				+ 	"lastName:  " + lastName  + "\n"
				+	"email: "	  + email	  + "\n"
				+   "street1: "   + street1	  + "\n"
				+   "street2: "   + street2   + "\n"
				+   "city: "      + city      + "\n"
				+   "state: "     + state     + "\n"
				+   "zip: "       + zip       + "\n";
		return val;
    }

}

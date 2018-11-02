package edu.sollers.javaprog.resumerbuilder;

public class PersonalInfo extends ResumeElement {
	
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private String state;
	private int zip;
	
	/**
	 * 
	 */
	public PersonalInfo() {
		super();
		
		// TODO Auto-generated constructor stub
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
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
    	return "first_name, last_name, email, street, city, state, zip";
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
    		+	street			+ "', '"
    		+	city			+ "', '"
    		+	state			+ "', '"	
    		+	zip				+ "')";
    }
    
    public String getUpdateStatement() {
    	return "update " + getTableName() + "";
    }

}

package edu.sollers.javaprog.resumerbuilder;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rutpatel
 */

public class Publication extends ResumeElement{

	private String authName;
	private String title;
	private int year;
	private String summary;
	
	public Publication(String authName, String title, int year, String summary) {
		this.authName = authName;
		this.title = title;
		this.year = year;
		this.summary = summary;
	}
	
	public String getAuthName() {
		return authName;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getSummary() {
		return summary;
	}

	public static String getFieldOrder() {
    	return "auth_name, title, year, summary";
    }
    
	public static String getTableName() {
    	return "publication";
    }
    
    public static String getSelectClause() {
    	return "select " + getFieldOrder() + " from " + getTableName();
    }
    
    public String getInsertStatement() {
    	return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + authName + "', '" + title + "', " + year + ", '" + summary + "')";
    }
    
    public String getUpdateStatement() {
    	return "update " + getTableName() + "";
    }
    
    public void save() {
    	try {
			Statement stmt = ResumeBuilderController.getInstance().getConnection().createStatement();
	    	stmt.executeQuery(getInsertStatement());
	    	System.out.print("Publication Info inserted into database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}

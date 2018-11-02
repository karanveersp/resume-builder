package edu.sollers.javaprog.resumerbuilder;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rutpatel
 */

public class Publication extends ResumeElement{

	private String auth_name;
	private String title;
	private int year;
	private String summary;
	
	public Publication(String auth_name, String title, int year, String summary) {
		this.auth_name = auth_name;
		this.title = title;
		this.year = year;
		this.summary = summary;
	}
	
	public String getAuth_name() {
		return auth_name;
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
    	return "pub_info";
    }
    
    public static String getSelectClause() {
    	return "select " + getFieldOrder() + " from " + getTableName();
    }
    
    public String getInsertStatement() {
    	return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + auth_name + "', '" + title + "', " + year + ", '" + summary + "')";
    }
    
    public String getUpdateStatement() {
    	return "update " + getTableName() + "";
    }
    
    public void save() {
    	try {
			Statement stmt = getConnection().createStatement();
			stmt.executeQuery(getInsertStatement());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	System.out.print("Publication Info inserted into database");
    }
}

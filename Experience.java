package edu.sollers.javaprog.resumerbuilder;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rutpatel
 */

public class Experience extends ResumeElement {
	
	private String cmpName;
	private String pos;
	private String cmpLoc;
	private String startDate;
	private String endDate;
	private String cmpSumm;
	
	public Experience(String cmpName, String pos, String cmpLoc, String startDate, String endDate, String cmpSumm) {
		this.cmpName = cmpName;
		this.pos = pos;
		this.cmpLoc = cmpLoc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cmpSumm = cmpSumm;
	}
	
	public String getCmpName() {
		return cmpName;
	}

	public String getPos() {
		return pos;
	}

	public String getCmpLoc() {
		return cmpLoc;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getCmpSumm() {
		return cmpSumm;
	}

	public static String getFieldOrder() {
    	return "cmp_name, pos, cmp_loc, start_date, end_date, cmp_summ";
    }
    
	public static String getTableName() {
    	return "experience";
    }
    
    public static String getSelectClause() {
    	return "select " + getFieldOrder() + " from " + getTableName();
    }
    
    public String getInsertStatement() {
    	return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + cmpName + "', '" + pos + "', '" + cmpLoc + "', '" + startDate + "', '" + endDate + "', '" + cmpSumm +"')";
    }
    
    public String getUpdateStatement() {
    	return "update " + getTableName() + "";
    }
    
    public void save() {
		try {
			Statement stmt = ResumeBuilderController.getInstance().getConnection().createStatement();
	    	stmt.executeQuery(getInsertStatement());
	    	System.out.print("Experience Info inserted into database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}

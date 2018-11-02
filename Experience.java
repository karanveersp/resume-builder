package edu.sollers.javaprog.resumerbuilder;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rutpatel
 */

public class Experience extends ResumeElement {
	
	private String cmp_name;
	private String pos;
	private String cmp_loc;
	private String start_date;
	private String end_date;
	private String cmp_summ;
	
	public Experience(String cmp_name, String pos, String cmp_loc, String start_date, String end_date, String cmp_summ) {
		this.cmp_name = cmp_name;
		this.pos = pos;
		this.cmp_loc = cmp_loc;
		this.start_date = start_date;
		this.end_date = end_date;
		this.cmp_summ = cmp_summ;
	}
	
	public String getCmp_name() {
		return cmp_name;
	}

	public String getPos() {
		return pos;
	}

	public String getCmp_loc() {
		return cmp_loc;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getCmp_summ() {
		return cmp_summ;
	}

	public static String getFieldOrder() {
    	return "cmp_name, pos, cmp_loc, start_date, end_date, cmp_summ";
    }
    
	public static String getTableName() {
    	return "exp_info";
    }
    
    public static String getSelectClause() {
    	return "select " + getFieldOrder() + " from " + getTableName();
    }
    
    public String getInsertStatement() {
    	return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + cmp_name + "', '" + pos + "', '" + cmp_loc + "', '" + start_date + "', '" + end_date + "', '" + cmp_summ +"')";
    }
    
    public String getUpdateStatement() {
    	return "update " + getTableName() + "";
    }
    
    public void save() {
    	try {
			Statement stmt = getConnection().createStatement();
			stmt.executeQuery(getInsertStatement());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.print("Experience Info inserted into database");
    }
}

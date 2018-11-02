package edu.sollers.javaprog.resumerbuilder;


// extends the ResumeElement class
public class Summary extends ResumeElement{
	private String summary;
	
	public static String getFieldOrder() {
    	return "";
    }
    
    public static String getTableName() {
    	return "";
    }
    
    public static String getSelectClause() {
    	return "select " + getFieldOrder() + " from " + getTableName();
    }
    
    public String getInsertStatement() {
    	return "insert into " + getTableName() + " (" + getFieldOrder() + ") values (" + ")";
    }
    
    public String getUpdateStatement() {
    	return "update " + getTableName() + "";
    }
}

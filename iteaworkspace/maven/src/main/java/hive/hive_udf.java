package hive;

import org.apache.hadoop.hive.ql.exec.UDF;

public class hive_udf extends UDF  {
	public String evaluate(String word) {		
		String upperCase = word.toUpperCase();		
		return upperCase;	
	} 
	
	
	
}

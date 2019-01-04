package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class hive_jdbc {
	public static void main(String[] args) throws Exception {
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection con = DriverManager.getConnection("jdbc:hive2://master:10000/shangdan");
		Statement cs = con.createStatement();
		//查询sql，query
		ResultSet rs = cs.executeQuery("select * from shangdan.air_id");
		//通常用于ddl操作
		//cs.execute("create table testxx");
		while(rs.next()) {
			String word = rs.getString(1);
			String count = rs.getString(2);
			System.out.println(word + ", " + count);
		}
		rs.close();
		cs.close();
		con.close();
	}
}

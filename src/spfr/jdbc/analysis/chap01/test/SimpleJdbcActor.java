package spfr.jdbc.analysis.chap01.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//JDBC操作
public class SimpleJdbcActor {

	public static void main(String[] args) {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbct?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "anan1215");
			PreparedStatement p = con.prepareStatement("insert into dor(id,name,title) values ('3','125','125')");
			p.execute();
			if (con!=null) {
				p.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

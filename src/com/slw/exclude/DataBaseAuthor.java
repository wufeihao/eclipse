package com.slw.exclude;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.slw.entertity.Author;
public class DataBaseAuthor {
	public Author author ;
	public String Name;
	List<Author> authorlist = new ArrayList<Author>();
	public List<Author> visitBase(String name){
		Connection conn =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_wfhsoft","wl11z4jnzm","m5ymw3xyh0liiiki02jlw5zwzx30liw0zy134l02");
			if(!conn.isClosed())
			{
				System.out.println("数据库连接成功");
			}
			Statement statement =conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT* from author where Name="+"'"+Name+"'");
			while(rs.next()){
				author = new Author();
				author.AuthorId=rs.getInt("AuthorId");
				author.Name=rs.getString("Name");
				author.Age=rs.getInt("Age");
				author.Country = rs.getString("Country");
				authorlist.add(author);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if(conn!=null)
			{
				try{
					conn.close();
					conn=null;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return authorlist;
	}
}

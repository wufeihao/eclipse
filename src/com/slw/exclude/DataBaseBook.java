package com.slw.exclude;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.slw.entertity.Book;
public class DataBaseBook{
	public Book book ;
	List<Book> booklist = new ArrayList<Book>();
	public List<Book> visitBase(String name){
		Connection conn =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_wfhsoft","wl11z4jnzm","m5ymw3xyh0liiiki02jlw5zwzx30liw0zy134l02");
			if(!conn.isClosed())
			{
				System.out.println("数据库连接成功");
			}
			Statement statement =conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT* from author,book where author.AuthorId = book.AuthorID and  author.name ="+ "'"+ name + "'");
			while(rs.next()){
				book = new Book();
				book.ISBN=rs.getInt("ISBN");
				book.Title=rs.getString("Title");
				book.AuthorID=rs.getInt("AuthorID");
				book.Publisher = rs.getString("Publisher");
				book.Price=rs.getInt("price");
				booklist.add(book);
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
		return booklist;
	}
	
}

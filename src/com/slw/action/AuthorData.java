package com.slw.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;
import com.slw.entertity.Author;
import com.slw.entertity.Book;

public class AuthorData implements Action{
	private Author author;
	private Book book;
	private int ISBNtemp;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getISBNtemp() {
		return ISBNtemp;
	}
	public void setISBNtemp(int iSBNtemp) {
		ISBNtemp = iSBNtemp;
	}
	public String execute()
	{
		Connection conn =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_wfhsoft","wl11z4jnzm","m5ymw3xyh0liiiki02jlw5zwzx30liw0zy134l02");
			if(!conn.isClosed())
			{
				System.out.println("数据库连接成功");
			}
			Statement statement =conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT* from author,book where author.AuthorId = book.AuthorID and  book.ISBN="+ "'"+ ISBNtemp + "'");
			while(rs.next()){
				author = new Author();
				author.AuthorId=rs.getInt("AuthorId");
				author.Name=rs.getString("Name");
				author.Age=rs.getInt("Age");
				author.Country = rs.getString("Country");
			}
			ResultSet rs1 = statement.executeQuery("SELECT* from book where ISBN="+"'"+ISBNtemp+"'");
			while(rs1.next()){
				book = new Book();
				book.ISBN = rs1.getInt("ISBN");
				book.Title = rs1.getString("AuthorID");
				book.Publisher = rs1.getString("Publisher");
				book.PublisherData = rs1.getDate("PublisherData");
				book.Price= rs1.getDouble("Price");
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
		return SUCCESS;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}

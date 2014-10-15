package com.slw.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;
public class InsertBook implements Action{
	private String Title;
	private int AuthorID;
	private String Publisher;
	private Date PublisherData;
	private double Price;
	public String execute(){
		int rs =0;
		Connection conn =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_wfhsoft","wl11z4jnzm","m5ymw3xyh0liiiki02jlw5zwzx30liw0zy134l02");
			if(conn.isClosed())
			{
				return ERROR;
			}
			Statement statement =conn.createStatement();
			ResultSet rsnew = statement.executeQuery("SELECT* from author where AuthorId="+"'"+AuthorID+"'");
			if(!rsnew.next())
			{
				return NONE;
			}
			rs = statement.executeUpdate("INSERT INTO book(Title,AuthorID,Publisher,PublisherData,Price) VALUES("+"'"+Title+"',"+"'"+AuthorID+"',"+"'"+Publisher+"',"+"'"+PublisherData+"',"+"'"+Price+"'"+")");
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
		if(rs==1)
			return SUCCESS;
		else
			return ERROR;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public Date getPublisherData() {
		return PublisherData;
	}
	public void setPublisherData(Date publisherData) {
		PublisherData = publisherData;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
}

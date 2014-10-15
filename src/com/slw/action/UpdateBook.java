package com.slw.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import com.opensymphony.xwork2.Action;

public class UpdateBook implements Action{
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
			if(!conn.isClosed())
			{
				System.out.println("数据库连接成功");
			}
			Statement statement =conn.createStatement();
			rs = statement.executeUpdate("UPDATE book SET AuthorID="+"'"+AuthorID+"'"+",Publisher="+"'"+Publisher+"'"+",Price="+"'"+Price+"'"+",PublisherData="+"'"+PublisherData+"'"+" where Title="+"'"+Title+"'");
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
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public Date getPublisherData() {
		return PublisherData;
	}
	public void setPublisherData(Date publisherData) {
		PublisherData = publisherData;
	}
}

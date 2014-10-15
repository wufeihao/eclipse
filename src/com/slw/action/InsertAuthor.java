package com.slw.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;

public class InsertAuthor implements Action {
	private int AuthorId;
	private String Name;
	private int Age;
	private String Country;
	public int getAuthorId() {
		return AuthorId;
	}
	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
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
			rs = statement.executeUpdate("INSERT INTO author(Name,Age,Country) VALUES("+"'"+Name+"',"+"'"+Age+"',"+"'"+Country+"'"+")");
			ResultSet rs1 = statement.executeQuery("SELECT AuthorId from author where Name="+"'"+Name+"'");
			if(rs1.next())
				setAuthorId(rs1.getInt("AuthorId"));
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
}

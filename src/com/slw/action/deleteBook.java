package com.slw.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;

public class deleteBook implements Action{
	private int ISBNtemp;
	public String execute()
	{
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
			rs = statement.executeUpdate("DELETE FROM book where ISBN ="+"'"+ISBNtemp+"'");
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
		{
			return SUCCESS;
		}
		else
			return ERROR;
	}

	public int getISBNtemp() {
		return ISBNtemp;
	}

	public void setISBNtemp(int ISBNtemp) {
		this.ISBNtemp = ISBNtemp;
	}
}

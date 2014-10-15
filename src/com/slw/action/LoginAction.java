package com.slw.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.slw.exclude.*;
import com.slw.entertity.*;
public class LoginAction implements Action{
	private String name;
	private List<Book> booklist = new ArrayList<Book>();
	private List<Author> authorlist = new ArrayList<Author>();
	//-------------------------------------------------
	public DataBaseAuthor dba= new DataBaseAuthor();
	public DataBaseBook dbb=new DataBaseBook();
	//--------------------------------------------------
	public String execute(){
		this.setAuthorlist(dba.visitBase(name));
		this.setBooklist(dbb.visitBase(name));
		return SUCCESS;
	}
	//------------------------------------------
	public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	public List<Author> getAuthorlist() {
		return authorlist;
	}
	public void setAuthorlist(List<Author> authorlist) {
		this.authorlist = authorlist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

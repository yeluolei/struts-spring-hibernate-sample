package com.yerurui.start.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yerurui.start.dao.MemberDao;
import com.yerurui.start.entity.Member;

public class Hello extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	public String name;
	public String email;
	public String nameemail;
	public MemberDao memberDao;
	
	public String hello(){
		memberDao.save(new Member(name, email));
		return "success";
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameemail() {
		return nameemail;
	}

	public void setNameemail(String nameemail) {
		this.nameemail = nameemail;
	}
	
}

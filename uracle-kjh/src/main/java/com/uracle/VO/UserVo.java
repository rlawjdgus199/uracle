package com.uracle.VO;

public class UserVo {
	
	private String userid;
	private String pw;
	private String name;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", pw=" + pw + ", name=" + name + "]";
	}

	

}

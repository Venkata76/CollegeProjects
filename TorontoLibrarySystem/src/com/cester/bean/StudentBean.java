package com.cester.bean;

public class StudentBean {

	String email,fname,lname,gender,college,mobileno,password;
	public StudentBean(String email, String fname, String lname, String gender, String college, String mobileno,
			String password) {
		this.email=email;
		this.fname=fname;
		this.lname=lname;
		this.gender=gender;
		this.college=college;
		this.mobileno=mobileno;
		this.password=password;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

package in.ashokit.request;

import java.time.LocalDate;

public class SignUpRequest {
   
    //private Integer userid;
	
	private String name;
	
	private String email;
	
	private String pwd;
	
	private String gender;
    
	private LocalDate dob;
	
	private Long phno;
	
	private Long ssn;
	
	private String userType;
	
	private boolean  pwdChanged;
	
//	public Integer getUserid() {
//		return userid;
//	}
//
//	public void setUserid(Integer userid) {
//		this.userid = userid;
//	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isPwdChanged() {
		return pwdChanged;
	}

	public void setPwdChanged(boolean pwdChanged) {
		this.pwdChanged = pwdChanged;
	}


}

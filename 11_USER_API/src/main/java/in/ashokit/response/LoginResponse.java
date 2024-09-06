package in.ashokit.response;

public class LoginResponse {
  
	private Integer userid;
	private String name;
	private String userType;
	private DashboardResponse dashboard;
	private boolean isValidLogin;
	private boolean pwdChanged;
	
	
	public boolean isValidLogin() {
		return isValidLogin;
	}
	public void setValidLogin(boolean isValidLogin) {
		this.isValidLogin = isValidLogin;
	}
	public boolean isPwdChanged() {
		return pwdChanged;
	}
	public void setPwdChanged(boolean pwdChanged) {
		this.pwdChanged = pwdChanged;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public DashboardResponse getDashboard() {
		return dashboard;
	}
	public void setDashboard(DashboardResponse dashboard) {
		this.dashboard = dashboard;
	}
	
}

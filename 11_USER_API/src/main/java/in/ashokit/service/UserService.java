package in.ashokit.service;

import in.ashokit.request.LoginRequest;
import in.ashokit.request.PwdChangeRequest;
import in.ashokit.request.SignUpRequest;
import in.ashokit.response.LoginResponse;

public interface UserService {

	public boolean saveUser(SignUpRequest request);
	public LoginResponse usserLogin(LoginRequest request);
	public LoginResponse updatePwd(PwdChangeRequest request);
	public boolean recoverPwd(String email);
}

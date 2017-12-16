package top.robotman.myblog.service;

import top.robotman.myblog.domain.User;

public interface UserService {
	public int  regist(String username,String password);
	
	public User login(String username,String password);

}

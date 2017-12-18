package top.robotman.myblog.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import top.robotman.myblog.domain.User;
import top.robotman.myblog.excepetion.BizExcepetion;
import top.robotman.myblog.mapper.UserMapper;
import top.robotman.myblog.service.UserService;
@Component
public class UserServiceimpl implements UserService{
	@Autowired
	private UserMapper usermp;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int  regist(String username,String password) {
		//业务逻辑判断下用户名存在问题吧
		if(StringUtils.isEmpty(username)) {
			throw new BizExcepetion("用户名不能为空");
		}
		
		if(StringUtils.isEmpty(password)) {
			throw new BizExcepetion("密码不能为空");
		}
		
		if(usermp.qureyUser(username) != null) {
			throw new BizExcepetion("用户名已存在");
		}
		
		int row = usermp.registUser(username, DigestUtils.md5Hex(password+username));	
		return row;
	}

	@Override
	public User login(String username,String password) {
		
		if(StringUtils.isEmpty(username)) {
			throw new BizExcepetion("用户名不能为空");
		}
		
		if(StringUtils.isEmpty(password)) {
			throw new BizExcepetion("密码不能为空");
		}

		
		User user = usermp.qureyUser(username);
		
		if(user == null) {
			throw new BizExcepetion("用户名或密码错误");
		}
		
		if(!DigestUtils.md5Hex(password+username).equals(user.getPassword())) {
			throw new BizExcepetion("用户名或密码错误");
		}			
		// TODO Auto-generated method stub		
		return user;
	}
}

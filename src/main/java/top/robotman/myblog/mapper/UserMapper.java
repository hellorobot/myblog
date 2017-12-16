package top.robotman.myblog.mapper;

import org.apache.ibatis.annotations.Param;

import top.robotman.myblog.domain.User;

public interface UserMapper {
	
	int registUser(@Param("username")String username,@Param("password")String password);
	
	User qureyUser(String username);

}

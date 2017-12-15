package top.robotman.myblog.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	int registUser(@Param("username")String username,@Param("password")String password);

}

package edu.global.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public UserVO getUser(String username);
	
	@Insert("INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES(#{username}, #{password}, #{enabled})")
	public int insertUser(UserVO userVO);
	
	@Insert("INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES(#{username}, 'ROLE_USER')")
	public void insertAuthorities(UserVO UserVO);
}

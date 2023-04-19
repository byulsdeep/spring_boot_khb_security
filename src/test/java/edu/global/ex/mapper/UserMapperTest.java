package edu.global.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	void testInsertUser() {
		
		UserVO user = new UserVO();
		user.setUsername("user");
		user.setPassword(new BCryptPasswordEncoder().encode("user"));
		user.setEnabled(1);
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}
	
	@Test
	void testInsertAdminUser() {
		
		UserVO user = new UserVO();
		user.setUsername("boss");
		user.setPassword(new BCryptPasswordEncoder().encode("boss"));
		user.setEnabled(1);
		
		userMapper.insertUser(user);
		userMapper.insertAdminAuthorities(user);
	}

}

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
		user.setUsername("byul");
		user.setPassword(new BCryptPasswordEncoder().encode("byul"));
		user.setEnabled(1);
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}

}

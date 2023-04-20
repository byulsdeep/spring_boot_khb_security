package edu.global.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.global.ex.mapper.UserMapper;
import edu.global.ex.vo.UserDetailsVO;
import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("-----------------------");
		System.out.println("Load User By UserVO number: " + username);
		UserVO vo = userMapper.getUser(username);
		
		System.out.println("queried by UserVO mapper: " + vo);
		System.out.println("-----------------------");
		return vo == null ? null : new UserDetailsVO(vo);
	}

}

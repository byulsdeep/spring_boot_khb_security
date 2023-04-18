package edu.global.ex.vo;

import java.util.List;

import lombok.Data;

@Data
public class UserVO {
	private String username;
	private String password;
	private int enabled;
	
	private List<AuthVO> authList;
}

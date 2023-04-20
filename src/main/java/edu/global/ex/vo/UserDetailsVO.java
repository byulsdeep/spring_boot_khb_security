package edu.global.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsVO implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> authorities;

	public UserDetailsVO(UserVO user) {
		this.setAuthorities(user);
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(UserVO userVO) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (AuthVO auth : userVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}

		this.authorities = authorities;
	}

	public String getCart() {
		return "cart";
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

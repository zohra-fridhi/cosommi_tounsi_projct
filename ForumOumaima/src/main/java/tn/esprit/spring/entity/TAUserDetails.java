package tn.esprit.spring.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import java.util.List;

@Data
public class TAUserDetails implements UserDetails {


	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	private Boolean active;

	public TAUserDetails() {
	}

	public TAUserDetails(User user) {
		this.username = user.getLogin();
		this.password = user.getPassword();
		this.authorities = Collections.singletonList(
				new SimpleGrantedAuthority("ROLE_"+user.getRole()));				
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
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

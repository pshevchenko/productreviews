package com.astound.presentation.productreviews.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements UserDetails
{
	private String name;
	private String login;
	private String password;
	private long binaryRoles;
	private boolean enable;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(Authority.values())
				.filter(authority -> (binaryRoles & (1 << authority.ordinal())) != 0)
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return enable;
	}

	@Override
	public boolean isAccountNonLocked() {
		return enable;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return enable;
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}
}

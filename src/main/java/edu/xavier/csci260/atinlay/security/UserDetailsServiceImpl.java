/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.xavier.csci260.atinlay.security;

import edu.xavier.csci260.atinlay.dal.UserRepository;
import edu.xavier.csci260.atinlay.domain.Privilege;
import edu.xavier.csci260.atinlay.domain.Role;
import edu.xavier.csci260.atinlay.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Rob Winch
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpServletRequest request;

	public UserDetailsServiceImpl() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

		final String ip = getClientIP();

		if (loginService.isBlocked(ip)) {

			throw new RuntimeException("blocked");
		}
		try {

			final User user = userRepository.findByEmail(email);

			if (user == null) {

					throw new UsernameNotFoundException("No user found with username: " + email);
			}

			return new CustomUserDetails(user, user.getRoles());

			} catch (final Exception e) {

			throw new RuntimeException(e);
		}
	}

	// UTIL

	private final String getClientIP() {

		final String xfHeader = request.getHeader("X-Forwarded-For");

		if (xfHeader == null)
			return request.getRemoteAddr();

		return xfHeader.split(",")[0];
	}

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	private final static class CustomUserDetails extends User implements UserDetails {

		private Collection<Role> roles;

		private CustomUserDetails(User user, Collection<Role> roles) {

			super(user);

			this.roles = roles;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {

			return getGrantedAuthorities(getPrivileges(roles));
		}

		@Override
		public String getUsername() {
			return getEmail();
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

		public Long getId() {
			return super.getId();
		}

		private static final long serialVersionUID = 5639683223516504866L;

		private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
			final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (final String privilege : privileges) {
				authorities.add(new SimpleGrantedAuthority(privilege));
			}
			return authorities;
		}

		private final List<String> getPrivileges(final Collection<Role> roles) {
			final List<String> privileges = new ArrayList<String>();
			final List<Privilege> collection = new ArrayList<Privilege>();
			for (final Role role : roles) {
				collection.addAll(role.getPrivileges());
			}
			for (final Privilege item : collection) {
				privileges.add(item.getName());
			}

			return privileges;
		}
	}

}

package com.mycompany.springbootldap.config;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LdapUserDetails implements UserDetailsService {

	@Autowired
	LoadProperties loadProperties;


	/*public LdapUserDetails() {
		users.add(new LdapUsers("erin", "123", "ADMIN"));
        users.add(new LdapUsers("mike", "234", "ADMIN"));

	}
*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	/*	Optional<LdapUsers> user = users.stream()
				.filter(u -> u.getName().equals(username)).findFirst();*/
	Optional<Entry<String, List<String>>> user = loadProperties.getUserProp().entrySet().stream().filter(u->u.getKey().equals(username)).findAny();
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found by name: " + username);
		}
		return toUserDetails(user.get());
	}

	private UserDetails toUserDetails(Entry<String, List<String>> userObject) {
		return User.withUsername(userObject.getKey())
                .password("{noop}"+userObject.getValue())
				.password(userObject.getKey())
                .roles(userObject.getKey()).build();
	}

}

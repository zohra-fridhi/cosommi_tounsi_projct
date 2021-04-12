package tn.esprit.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.TAUserDetails;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IUserRepository;


@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	/**
	 * The UserDetails service.
	 */
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByLogin(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username));
		return new TAUserDetails(user.get());
	}
}

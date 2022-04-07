package org.generation.lojadegames.seguranca;


import java.util.Optional;

import org.generation.lojadegames.model.Usuario;
import org.generation.lojadegames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailsServiceImpl {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() ->new  UsernameNotFoundException(userName + "not found. "));
		return user.map(UserDetailsImpl::new).get();
	}
}

package br.univille.geekreviews.services;

import br.univille.geekreviews.domain.Usuario;
import br.univille.geekreviews.repositories.UsuarioRepository;
import br.univille.geekreviews.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = repository.findByEmail(email);

        if (user == null)
            throw new UsernameNotFoundException(email);

        return new UserSS(user.getId(), user.getEmail(), user.getSenha(), user.getPermissao());
    }
}

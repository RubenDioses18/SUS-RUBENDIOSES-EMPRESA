package com.idat.empresa.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.empresa.model.Usuario;
import com.idat.empresa.repository.UsuarioRepository;

@Service
public class UsuarioDetailService implements UserDetailsService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<Usuario> usuario = repository.findByUsuario(username);
        if (usuario.isPresent()) {
            List<SimpleGrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ROLE_" + usuario.get().getRol()));
            return new User(usuario.get().getUsuario(),usuario.get().getPassword(),roles);
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
    
}

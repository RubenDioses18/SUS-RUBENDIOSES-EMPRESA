package com.idat.empresa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.empresa.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findByUsuario(String username);
}

package com.resttime.usuario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resttime.usuario.model.Usuario;
import com.resttime.usuario.util.Estado;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByCorreo(String correo);
	
	boolean existsByCorreo(String correo);
	
	List<Usuario> findByEstado(Estado estado);
}

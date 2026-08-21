package com.resttime.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.resttime.usuario.dto.LoginRequest;
import com.resttime.usuario.dto.UsuarioRequest;
import com.resttime.usuario.dto.UsuarioResponse;
import com.resttime.exception.cases.CredencialesException;
import com.resttime.exception.cases.NoEncontradoException;
import com.resttime.exception.cases.UsuarioExistenteException;
import com.resttime.usuario.mapper.UsuarioMapper;
import com.resttime.usuario.model.Usuario;
import com.resttime.usuario.repository.IUsuarioRepository;
import com.resttime.usuario.util.Estado;

@Service
public class UsuarioService {
	
	private final IUsuarioRepository _repository;
	private final UsuarioMapper _mapper;
	
	public UsuarioService(IUsuarioRepository repository, UsuarioMapper mapper) {
		_repository = repository;
		_mapper = mapper;
	}
	
	public UsuarioResponse crearUsuario(UsuarioRequest request) {
		Optional<Usuario> u = _repository.findByCorreo(request.getCorreo());
		
		if (u.isPresent()) {
			throw new UsuarioExistenteException("El correo ya esta registrado");
		}
		Usuario nuevo = _mapper.toEntity(request);
		_repository.save(nuevo);
		UsuarioResponse resultado = _mapper.toResponse(nuevo);
		return resultado;
	}
	
	public UsuarioResponse login(LoginRequest u) {
		Usuario usuario = _repository.findByCorreo(u.getCorreo())
				.orElseThrow(() -> new CredencialesException("Correo inexistente"));
		if(!usuario.getContrasena().equals(u.getContrasena())) {
			throw new CredencialesException("Contraseña incorrecta");
		}
		if(usuario.getEstado() == Estado.INACTIVO) {
			throw new CredencialesException("Usuario inhabilitado");
		}
		
		return _mapper.toResponse(usuario);
	}
	
	public UsuarioResponse cambiarContrasena(Integer id, String nuevaContrasena) {

	    Usuario usuario = _repository.findById(id)
	            .orElseThrow(() ->new NoEncontradoException("Usuario no encontrado"));
	    usuario.setContrasena(nuevaContrasena);
	    Usuario actualizado = _repository.save(usuario);

	    return _mapper.toResponse(actualizado);
	}

	public UsuarioResponse actualizarUsuario(Integer id, UsuarioRequest request) {

	    Usuario usuario = _repository.findById(id)
	            .orElseThrow(() -> new NoEncontradoException("Usuario no encontrado"));

	    Optional<Usuario> existente = _repository.findByCorreo(request.getCorreo());

	    if (existente.isPresent() && !existente.get().getId().equals(id)) {
	        throw new UsuarioExistenteException("El correo ya está registrado");
	    }

	    _mapper.updateEntity(request, usuario);

	    Usuario actualizado = _repository.save(usuario);

	    return _mapper.toResponse(actualizado);
	}

	public UsuarioResponse cambiarEstado(Integer id) {
		Usuario u = _repository.findById(id)
				.orElseThrow(() -> new NoEncontradoException("Usuario no encontrado"));
		if (u.getEstado() == Estado.ACTIVO) {
			u.setEstado(Estado.INACTIVO);
		}
		else {
			u.setEstado(Estado.ACTIVO);
		}
		Usuario actual = _repository.save(u);
		return _mapper.toResponse(actual);
		
	}
	
	public List<Usuario> listarTodo(){
		return _repository.findAll();
	}
	public List<Usuario> listarPorEstado(Estado e){
		return _repository.findByEstado(e);
	}
	
	public UsuarioResponse buscarUsuario(Integer id) {
		Usuario u = _repository.findById(id)
				.orElseThrow(() -> new NoEncontradoException("Usuario no encontrado"));
		UsuarioResponse respuesta = _mapper.toResponse(u);
		return respuesta;
	}
}

package com.resttime.usuario.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resttime.usuario.dto.LoginRequest;
import com.resttime.usuario.dto.UsuarioRequest;
import com.resttime.usuario.dto.UsuarioResponse;
import com.resttime.usuario.model.Usuario;
import com.resttime.usuario.service.UsuarioService;
import com.resttime.usuario.util.Estado;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	private final UsuarioService _service;
	
	public UsuarioController(UsuarioService service) {
		_service = service;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioResponse> login(
	        @RequestBody LoginRequest request) {

	    return ResponseEntity.ok(_service.login(request));
	}

	@GetMapping("/listarTodo")
	public ResponseEntity<List<Usuario>> listarTodo(){
		List<Usuario> listado = _service.listarTodo();
		return ResponseEntity.status(HttpStatus.OK).body(listado);
	}

	@GetMapping("/listarTodo/{estado}")
	public ResponseEntity<List<Usuario>> listarPorEstado(@PathVariable Estado estado){
		List<Usuario> listado = _service.listarPorEstado(estado);
		return ResponseEntity.status(HttpStatus.OK).body(listado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable Integer id){
		UsuarioResponse u = _service.buscarUsuario(id);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}

	@PostMapping("/crearUsuario")
	public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody UsuarioRequest u){
		UsuarioResponse resultado = _service.crearUsuario(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
	}
	
	@PatchMapping("/{id}/contrasena")
	public ResponseEntity<UsuarioResponse> cambiarContrasena(
			@PathVariable Integer id, @RequestBody String nuevaContrasena) {
	    return ResponseEntity.ok(
	        _service.cambiarContrasena(id, nuevaContrasena)
	    );
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<UsuarioResponse> actualizarUsuario(
	        @PathVariable Integer id,@RequestBody UsuarioRequest request) {

	    UsuarioResponse resultado = _service.actualizarUsuario(id, request);

	    return ResponseEntity.ok(resultado);
	}

	@PutMapping("/cambiarEstado/{id}")
	public ResponseEntity<UsuarioResponse> cambiarEstado(@PathVariable Integer id){
		UsuarioResponse resultado = _service.cambiarEstado(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
	}
}

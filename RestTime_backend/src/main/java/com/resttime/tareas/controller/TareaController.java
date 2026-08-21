package com.resttime.tareas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resttime.tareas.dto.TareaRequest;
import com.resttime.tareas.dto.TareaResponse;
import com.resttime.tareas.service.TareaService;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {
	private final TareaService _service;
	
	public TareaController(TareaService service) {
		_service = service;
	}
	
	@GetMapping("/listarTodo")
	public ResponseEntity<List<TareaResponse>> listarTodo(){
		List<TareaResponse> listado = _service.listarTareas();
		return ResponseEntity.status(HttpStatus.OK).body(listado);
	}
	
	@GetMapping("/listarTodo/{id}")
	public ResponseEntity<List<TareaResponse>> listarPorUsuario(@PathVariable Integer id){
		List<TareaResponse> listado = _service.listarPorUsuario(id);
		return ResponseEntity.status(HttpStatus.OK).body(listado);
	}
	@PostMapping("/crear")
	public ResponseEntity<TareaResponse> crearTarea(@RequestBody TareaRequest request) {
	    return ResponseEntity.ok(_service.crearTarea(request));
	}
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<TareaResponse> actualizarTarea(@PathVariable Integer id,@RequestBody TareaRequest request) {
	    return ResponseEntity.ok(_service.actualizarTarea(id,request));
	}
	@PatchMapping("/{id}/completar")
	public ResponseEntity<TareaResponse> cambiarEstado(@PathVariable Integer id) {
	    return ResponseEntity.ok(_service.cambiarEstado(id));
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<Void> eliminarTarea(@PathVariable Integer id) {
	    _service.eliminarTarea(id);
	    return ResponseEntity.noContent().build();
	}

}

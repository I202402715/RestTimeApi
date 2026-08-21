package com.resttime.tareas.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.resttime.exception.cases.NoEncontradoException;
import com.resttime.tareas.dto.TareaRequest;
import com.resttime.tareas.dto.TareaResponse;
import com.resttime.tareas.mapper.TareaMapper;
import com.resttime.tareas.model.Tarea;
import com.resttime.tareas.repository.ITareaRepository;
import com.resttime.usuario.model.Usuario;
import com.resttime.usuario.repository.IUsuarioRepository;

@Service
public class TareaService {
	private final ITareaRepository _repository;
	private final TareaMapper _mapper;
	private final IUsuarioRepository _usuariorepository;
	
	public TareaService(ITareaRepository repository, TareaMapper mapper, IUsuarioRepository usuariorepository ) {
		_mapper = mapper;
		_repository = repository;
		_usuariorepository = usuariorepository;
	}
	
	public List<TareaResponse> listarTareas(){
		try {
			List<Tarea> lst = _repository.findAll();
			List<TareaResponse> lstResponse = _mapper.toResponseList(lst);
			return lstResponse;
		}catch(Exception e) {
			throw new NoEncontradoException(e.getMessage());
		}
		
	}
	public List<TareaResponse> listarPorUsuario(Integer idUsuario){
		try {
			List<Tarea> lst = _repository.findByUsuarioId(idUsuario);
			List<TareaResponse> lstResponse = _mapper.toResponseList(lst);
			return lstResponse;
		}catch(Exception e) {
			throw new NoEncontradoException(e.getMessage());
		}
		
	}
	
	public TareaResponse crearTarea(TareaRequest request) {
	    Usuario usuario = _usuariorepository.findById(request.getUsuarioId())
	            .orElseThrow(() ->
	                new NoEncontradoException("Usuario no encontrado con id: " + request.getUsuarioId())
	            );
	    Tarea nueva = _mapper.toEntity(request, usuario);
	    Tarea guardada = _repository.save(nueva);

	    return _mapper.toResponse(guardada);
	}

	
	public TareaResponse actualizarTarea(Integer id, TareaRequest request) {
	    Tarea tarea = _repository.findById(id)
	            .orElseThrow(() ->
	                new NoEncontradoException("Tarea no encontrada con id: " + id));
	    _mapper.updateEntity(request, tarea);
	    Tarea actualizada = _repository.save(tarea);
	    return _mapper.toResponse(actualizada);
	}
	
	public TareaResponse cambiarEstado(Integer id) {
	    Tarea tarea = _repository.findById(id)
	            .orElseThrow(() ->new NoEncontradoException("Tarea no encontrada con id: " + id));
	    tarea.setCompletada(!tarea.getCompletada());
	    Tarea actualizada = _repository.save(tarea);

	    return _mapper.toResponse(actualizada);
	}


	
	public void eliminarTarea(Integer id) {

	    if (!_repository.existsById(id)) {
	        throw new NoEncontradoException(
	            "Tarea no encontrada con id: " + id
	        );
	    }

	    _repository.deleteById(id);
	}

	
}

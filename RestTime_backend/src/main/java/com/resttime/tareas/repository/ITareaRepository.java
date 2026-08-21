package com.resttime.tareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resttime.tareas.model.Tarea;

public interface ITareaRepository extends JpaRepository<Tarea, Integer> {
	List<Tarea> findByUsuarioId(Integer usuarioId);
}

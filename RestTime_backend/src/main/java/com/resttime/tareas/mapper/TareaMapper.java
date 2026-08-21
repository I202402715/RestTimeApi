package com.resttime.tareas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.resttime.tareas.dto.TareaRequest;
import com.resttime.tareas.dto.TareaResponse;
import com.resttime.tareas.model.Tarea;
import com.resttime.usuario.model.Usuario;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TareaMapper {
	@Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "fechaCreacion", ignore = true)
    Tarea toEntity(TareaRequest t, Usuario usuario);
	
	@Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombreUsuario")
    TareaResponse toResponse(Tarea tarea);
	
	@Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombreUsuario")
	List<TareaResponse> toResponseList(List<Tarea> tareas);
	
	 @Mapping(target = "id", ignore = true)
	 @Mapping(target = "usuario", ignore = true)
	 @Mapping(target = "fechaCreacion", ignore = true)
	 void updateEntity(TareaRequest request, @MappingTarget Tarea tarea);

}

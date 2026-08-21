package com.resttime.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.resttime.usuario.dto.UsuarioRequest;
import com.resttime.usuario.dto.UsuarioResponse;
import com.resttime.usuario.model.Usuario;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {
	UsuarioResponse toResponse(Usuario u);
	@Mapping(target = "id", ignore = true)
	Usuario toEntity (UsuarioRequest u);
	
	 @Mapping(target = "id", ignore = true)
	 @Mapping(target = "estado", ignore = true)
	 void updateEntity(UsuarioRequest request, @MappingTarget Usuario usuario);
}

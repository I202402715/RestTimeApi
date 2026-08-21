package com.resttime.usuario.mapper;

import com.resttime.usuario.dto.UsuarioRequest;
import com.resttime.usuario.dto.UsuarioResponse;
import com.resttime.usuario.model.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-20T18:51:56-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponse toResponse(Usuario u) {
        if ( u == null ) {
            return null;
        }

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        usuarioResponse.setId( u.getId() );
        usuarioResponse.setNombres( u.getNombres() );
        usuarioResponse.setApellidos( u.getApellidos() );
        usuarioResponse.setCorreo( u.getCorreo() );
        usuarioResponse.setNombreUsuario( u.getNombreUsuario() );

        return usuarioResponse;
    }

    @Override
    public Usuario toEntity(UsuarioRequest u) {
        if ( u == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNombres( u.getNombres() );
        usuario.setApellidos( u.getApellidos() );
        usuario.setCorreo( u.getCorreo() );
        usuario.setFechaNacimiento( u.getFechaNacimiento() );
        usuario.setNombreUsuario( u.getNombreUsuario() );
        usuario.setContrasena( u.getContrasena() );
        usuario.setEstado( u.getEstado() );

        return usuario;
    }

    @Override
    public void updateEntity(UsuarioRequest request, Usuario usuario) {
        if ( request == null ) {
            return;
        }

        usuario.setNombres( request.getNombres() );
        usuario.setApellidos( request.getApellidos() );
        usuario.setCorreo( request.getCorreo() );
        usuario.setFechaNacimiento( request.getFechaNacimiento() );
        usuario.setNombreUsuario( request.getNombreUsuario() );
        usuario.setContrasena( request.getContrasena() );
    }
}

package com.resttime.tareas.mapper;

import com.resttime.tareas.dto.TareaRequest;
import com.resttime.tareas.dto.TareaResponse;
import com.resttime.tareas.model.Tarea;
import com.resttime.usuario.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-20T19:26:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class TareaMapperImpl implements TareaMapper {

    @Override
    public Tarea toEntity(TareaRequest t, Usuario usuario) {
        if ( t == null && usuario == null ) {
            return null;
        }

        Tarea tarea = new Tarea();

        if ( t != null ) {
            tarea.setTitulo( t.getTitulo() );
            tarea.setDescripcion( t.getDescripcion() );
            tarea.setCompletada( t.getCompletada() );
            tarea.setFechaVencimiento( t.getFechaVencimiento() );
        }
        tarea.setUsuario( usuario );

        return tarea;
    }

    @Override
    public TareaResponse toResponse(Tarea tarea) {
        if ( tarea == null ) {
            return null;
        }

        TareaResponse tareaResponse = new TareaResponse();

        tareaResponse.setIdUsuario( tareaUsuarioId( tarea ) );
        tareaResponse.setNombreUsuario( tareaUsuarioNombreUsuario( tarea ) );
        tareaResponse.setTitulo( tarea.getTitulo() );
        tareaResponse.setDescripcion( tarea.getDescripcion() );
        tareaResponse.setCompletada( tarea.getCompletada() );
        tareaResponse.setFechaCreacion( tarea.getFechaCreacion() );
        tareaResponse.setFechaVencimiento( tarea.getFechaVencimiento() );

        return tareaResponse;
    }

    @Override
    public List<TareaResponse> toResponseList(List<Tarea> tareas) {
        if ( tareas == null ) {
            return null;
        }

        List<TareaResponse> list = new ArrayList<TareaResponse>( tareas.size() );
        for ( Tarea tarea : tareas ) {
            list.add( toResponse( tarea ) );
        }

        return list;
    }

    @Override
    public void updateEntity(TareaRequest request, Tarea tarea) {
        if ( request == null ) {
            return;
        }

        tarea.setTitulo( request.getTitulo() );
        tarea.setDescripcion( request.getDescripcion() );
        tarea.setCompletada( request.getCompletada() );
        tarea.setFechaVencimiento( request.getFechaVencimiento() );
    }

    private Integer tareaUsuarioId(Tarea tarea) {
        Usuario usuario = tarea.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        return usuario.getId();
    }

    private String tareaUsuarioNombreUsuario(Tarea tarea) {
        Usuario usuario = tarea.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        return usuario.getNombreUsuario();
    }
}

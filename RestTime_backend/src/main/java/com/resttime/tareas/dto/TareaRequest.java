package com.resttime.tareas.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaRequest {
	private String titulo;
	private String descripcion;
	private Boolean completada;
	private LocalDateTime fechaVencimiento;
	private Integer usuarioId;
}

package com.resttime.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
	private Integer id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String nombreUsuario;
}

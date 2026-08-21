package com.resttime.usuario.dto;

import java.time.LocalDate;
import com.resttime.usuario.util.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
	private String nombres;
	private String apellidos;
	private String correo;
	private LocalDate fechaNacimiento;
	private String nombreUsuario;
	private String contrasena;
	private Estado estado;
}

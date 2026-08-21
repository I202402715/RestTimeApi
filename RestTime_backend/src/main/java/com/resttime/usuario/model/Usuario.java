package com.resttime.usuario.model;

import java.time.LocalDate;

import com.resttime.usuario.util.Estado;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombres;
	private String apellidos;
	private String correo;
	private LocalDate fechaNacimiento;
	private String nombreUsuario;
	private String contrasena;
	@Enumerated(EnumType.STRING)
	private Estado estado;
}

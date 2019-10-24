package com.ipartek.formacion.ejercicioSpring.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "usuarios")
public @Data @AllArgsConstructor @NoArgsConstructor class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre,passwd;
}

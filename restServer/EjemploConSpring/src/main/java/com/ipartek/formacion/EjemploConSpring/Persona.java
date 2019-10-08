package com.ipartek.formacion.EjemploConSpring;
import lombok.AllArgsConstructor;
import lombok.Data;


public @AllArgsConstructor @Data class Persona {
	private Long id;
	private String nombre, apellidos;
}
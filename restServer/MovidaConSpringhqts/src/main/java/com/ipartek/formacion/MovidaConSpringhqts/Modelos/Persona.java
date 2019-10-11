package com.ipartek.formacion.MovidaConSpringhqts.Modelos;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	public @AllArgsConstructor @NoArgsConstructor @Data class Persona {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String nombre, apellidos;
	}


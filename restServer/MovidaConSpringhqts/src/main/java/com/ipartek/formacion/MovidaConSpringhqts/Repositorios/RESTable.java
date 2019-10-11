package com.ipartek.formacion.MovidaConSpringhqts.Repositorios;
import java.util.List;

import com.ipartek.formacion.MovidaConSpringhqts.Modelos.Persona;
public interface RESTable<T> {
		public List<Persona> getAll();

		public Persona getById(Long id);

		
}

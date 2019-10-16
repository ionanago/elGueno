package com.ipartek.formacion.MovidaConSpringhqts.Repositorios;
import java.util.List;

import com.ipartek.formacion.MovidaConSpringhqts.Modelos.Persona;
public interface RESTable<T> {
	
		public List<Persona> getAll();

		public Persona getById(Long id);
		
		public void deleteById(Long id);

		public Persona insert(Persona persona);
		
		public Persona modify(Long id,Persona persona);
}

package com.ipartek.formacion.examen.IonAnder.servicios;

import com.ipartek.formacion.examen.IonAnder.accesodatos.PersonasDAO;
import com.ipartek.formacion.examen.IonAnder.accesodatos.PersonasDAOimpl;
import com.ipartek.formacion.examen.IonAnder.modelos.Persona;

public class PersonasServicioImpl implements PersonaServicio{

	
	PersonasDAO perdao = new PersonasDAOimpl();

	
	@Override
	public Persona addPersona(Persona Persona) {
		 
			return perdao.addPersona(Persona);
	}

	@Override
	public Persona getPersonaDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getPersonaEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getPersona(String Nombre, String Apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Persona> getLast50() {
		
		return perdao.getLast50() ;
	}

}

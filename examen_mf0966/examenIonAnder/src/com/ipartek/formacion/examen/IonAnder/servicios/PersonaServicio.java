package com.ipartek.formacion.examen.IonAnder.servicios;

import com.ipartek.formacion.examen.IonAnder.modelos.Persona;

public interface PersonaServicio {
	Persona addPersona(Persona Persona);
	Persona getPersonaDni(String dni);
	Persona getPersonaEmail(String email);
	Persona getPersona(String Nombre,String Apellido);
	Iterable<Persona> getLast50();
}

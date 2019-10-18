package com.ipartek.formacion.examen.IonAnder.modelos;

public class Persona {
   private Long id;
   private String nombre,apellido,email,dni;
   
   public Persona(Long id, String nombre, String apellido, String email, String dni) {
		
		setId(id);
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
		setDni(dni);
	}
   
public Persona(String nombre, String apellido, String email, String dni) {
	setNombre(nombre);
	setApellido(apellido);
	setEmail(email);
	setDni(dni);
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}

@Override
public String toString() {
	return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", dni=" + dni
			+ "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
	result = prime * result + ((dni == null) ? 0 : dni.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Persona other = (Persona) obj;
	if (apellido == null) {
		if (other.apellido != null)
			return false;
	} else if (!apellido.equals(other.apellido))
		return false;
	if (dni == null) {
		if (other.dni != null)
			return false;
	} else if (!dni.equals(other.dni))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}


}

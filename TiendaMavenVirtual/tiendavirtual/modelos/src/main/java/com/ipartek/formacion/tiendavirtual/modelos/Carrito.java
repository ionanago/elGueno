package com.ipartek.formacion.tiendavirtual.modelos;

public class Carrito {

	private Long id;
	private Iterable<Producto> productos;
	private Long id_usuario;
	
	
	public Carrito( Iterable<Producto> productos, Long id_usuario) {
		
		setProductos(productos);
		setId_usuario(id_usuario);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Iterable<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Iterable<Producto> productos) {
		this.productos = productos;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
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
		Carrito other = (Carrito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", productos=" + productos + ", id_usuario=" + id_usuario + "]";
	}
		
	
}

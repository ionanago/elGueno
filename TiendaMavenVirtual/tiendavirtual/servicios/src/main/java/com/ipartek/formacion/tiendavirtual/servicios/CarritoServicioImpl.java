package com.ipartek.formacion.tiendavirtual.servicios;

import com.ipartek.formacion.tiendavirtual.accesodatos.AccesoDatosException;
import com.ipartek.formacion.tiendavirtual.accesodatos.CarritoDaoMySql;
import com.ipartek.formacion.tiendavirtual.accesodatos.Dao;
import com.ipartek.formacion.tiendavirtual.accesodatos.FabricaDao;
import com.ipartek.formacion.tiendavirtual.modelos.Carrito;
import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public class CarritoServicioImpl implements CarritoServicio{
	private String configuracion;
	private FabricaDao fabrica;
	private Dao<Long, Carrito> dao;
	
	public String getConfiguracion() {
		return configuracion;
	}

	private static CarritoServicioImpl instancia = null;
	
	public static CarritoServicioImpl getInstancia() {
		if(instancia == null) {
			throw new AccesoDatosException("Debes crear una instancia con la configuración con el método crearInstancia");
		}
		return instancia;
	}
	
	public static CarritoServicioImpl crearInstancia(String configuracion) {
		return instancia = new CarritoServicioImpl(configuracion);
	}
	
	private CarritoServicioImpl(String configuracion) {
		try {
			this.configuracion = configuracion;
			this.fabrica = FabricaDao.crearInstancia(configuracion);
			this.dao = fabrica.getDaoCarrito();
		} catch (AccesoDatosException e) {
			throw new ServiciosException("Error al crear el dao", e);
		}
	}
	
	@Override
	public Carrito getCarrito(Long idu) {
		try {
			return dao.getCarrito(idu);
		} catch (AccesoDatosException e) {
			throw new ServiciosException("Ha habido un error al pedir el carro", e);}
			
		
	}

	@Override	
	public int getTotalCarrito(Long idu) {
		try {
			return CarritoDaoMySql.getInstancia().getTotalCarrito(idu);		
			} catch (AccesoDatosException e) {
			throw new ServiciosException("Ha habido un error al pedir el listado", e);}
			
	
		
		
	}

}

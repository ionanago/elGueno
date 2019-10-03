package com.ipartek.formacion.tiendavirtual.accesodatos;

import com.ipartek.formacion.tiendavirtual.modelos.Carrito;
import com.ipartek.formacion.tiendavirtual.modelos.Producto;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarritoDaoMySql implements Dao<Long, Carrito> {
	
	private static final String CARRITO_GETBY_USUARIO = "{ call tiendavirtual.carrito_getBy_user(1) }";
	private static final String CARRITO_INSERT = "{ call carrito_insert(?,?,?,?) }";
	private static final String CARRITO_TOTAL = "{ call carrito_total_usuario(?, ?) }";
	private static final String CARRITO_BORRAR_U_P="{call carrito_borrar_usuario_producto(?, ?)}";
	public String url, user, password, driver;

	private static CarritoDaoMySql instancia;

	public static CarritoDaoMySql crearInstancia(String driver, String url, String user, String password) {
		return instancia = new CarritoDaoMySql(driver, url, user, password);
	}

	public static CarritoDaoMySql getInstancia() {
		if (instancia == null) {
			throw new AccesoDatosException(
					"Se debe crear la instancia con crearInstancia y los datos de configuración");
		}
		return instancia;
	}

	private CarritoDaoMySql(String driver, String url, String user, String password) {

		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;
	}

	private Connection getConnection() {

		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al conectar a la base de datos", e);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de JDBC de MySQL", e);
		}
	}
	
	public Carrito getCarrito(Long idu) {
		try (Connection con = getConnection()) {
			try (CallableStatement cs = con.prepareCall(CARRITO_GETBY_USUARIO)) {
				//cs.setLong(1, idu);
				
				ResultSet rs = cs.executeQuery();

				ArrayList<Producto> productos = new ArrayList<>();

				

				while (rs.next()) {
 				String producto_nombre = rs.getString("producto");
				Long producto_id = rs.getLong("producto_id");
				BigDecimal producto_precio = rs.getBigDecimal("precio");
				int producto_cantidad = rs.getInt("cantidad");
				Producto producto = new Producto (producto_id,producto_nombre,producto_precio,producto_cantidad);
					
				productos.add(producto);		
					
				}
				Carrito carrito = new Carrito(productos, idu);
				return  carrito;

			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + CARRITO_GETBY_USUARIO,e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
	}

	public int getTotalCarrito(Long idu) {
		try (Connection con = getConnection()) {
			try (CallableStatement cs = con.prepareCall(CARRITO_TOTAL)) {
				cs.setLong(1, idu);
				ResultSet rs = cs.executeQuery();

				int total=0;
				if(rs.next()) {
					total = cs.getInt("total");
				}
					
				return total;


			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + CARRITO_TOTAL, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public Iterable<Carrito> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrito getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrito insert(Carrito objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrito update(Carrito objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrito update(Carrito objeto, Carrito objetoViejo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrito delete(Carrito objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	

	
	
}

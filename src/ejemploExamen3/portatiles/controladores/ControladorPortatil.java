package ejemploExamen3.portatiles.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejemploExamen3.portatiles.entidades.Portatil;



public class ControladorPortatil extends SuperControlador {

	private static String nombreTabla = "portatil";
	
	
	public static Portatil getPrimero() {
		try {
			return getEntidad(ConnectionManager.getConexion(), 					
					"select * from " +  nombreTabla 				
					+ " order by id asc limit 1");			
																	
		} catch (Exception ex) {							
			ex.printStackTrace();
		}
		return null;
	}

	
	
	/**
	 * 
	 * @param idActual
	 * @return
	 */
	public static Portatil getAnterior(int idActual) {
		try {
			String sql = "select * from " + nombreTabla + " where id < " + idActual
					+ " order by id desc limit 1";
			return getEntidad (ConnectionManager.getConexion(), sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	

	/**
	 * 
	 * @param idActual
	 * @return
	 */
	public static Portatil getSiguiente(int idActual) {
		try {
			return getEntidad(ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " where id > " + idActual 
					+ " order by id asc limit 1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	
	/**
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public static Portatil getUltimo() {
		try {
			return getEntidad(ConnectionManager.getConexion(), 							
					"select * from " +  nombreTabla 
					+ " order by id desc limit 1");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	

	
	/**
	 * 
	 * @param conn
	 * @param f
	 */
	public static int insercion (Portatil o) {
		//preparamos la consulta, en este caso una inserción
		try {
			Connection conn = ConnectionManager.getConexion();
			int nuevoId = nextIdEnTabla(nombreTabla);		// cosa de rafa para el problema
			PreparedStatement ps = conn.prepareStatement("" + 
					"insert into " + nombreTabla + " (id, modelo, sn, "
					+ "numProcesadores, vendido, fechaVenta, idMarca) "
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, o.getModelo());
			ps.setString(3, o.getSn());
			ps.setInt(4, o.getNumProcesadores());
			ps.setBoolean(5, o.isVendido());
			//Recuerda sacar el tiempo con getTIME 
			//Y CASTEARLLO A DATE DE SQL, ya que lo estás guardando en la base de datos
			ps.setDate(6, new java.sql.Date(o.getFechaVenta().getTime()));    
			
			ps.setInt(7, o.getIdMarca());
		
			
		//ejecutamos la inserción	
			ps.executeUpdate();
			
			return nuevoId;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Una bandera para el try-catch.
		return -1;
	}
	
	
	
	
	/**
	 * 
	 */
	public static void modificacion (Portatil o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(""
					+ "update " + nombreTabla + " set modelo = ? , sn = ? , numProcesadores = ?, "
					+ "vendido = ?, fechaVenta = ?, idMarca = ? "
					+ "where id = ?");
			
			ps.setString(1, o.getModelo());
			ps.setString(2, o.getSn());
			ps.setInt(3, o.getNumProcesadores());
			ps.setBoolean(4, o.isVendido());
			
			//Recuerda sacar el tiempo con getTIME 
			//Y CASTEARLLO A DATE DE SQL, ya que lo estás guardando en la base de datos
			ps.setDate(5, new java.sql.Date(o.getFechaVenta().getTime()));    
			
			ps.setInt(6, o.getIdMarca());
			ps.setInt(7, o.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	
	
	/**
	 * 
	 */
	public static void eliminacion (int id) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(""
					+ "delete from " + nombreTabla + "  where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	
	public static int contarPortatiles() {
	    try {
	        Connection conn = ConnectionManager.getConexion();
	        Statement statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS total FROM " + nombreTabla);               /// ES MUYYYYY IMPORTANTE
	        																											/// poner el  AS ... nombreColumna... 
	        if (resultSet.next()) {																						/// porque de ahí sacamos la info 
	            return resultSet.getInt("total");                              //        --------------------------->     justo ahí
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * La entidad en este caso es el portatil. Es un objeto tipo Portatil. por eso la O de objeto.
	 * Aquí SÍ usamos la conexión y el string sql que es la sentencia para seleccionar, modificar, etc 
	 * en la base de datos.
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private static Portatil getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		
		
		Portatil o = null; // empezamos a usar o de OBJETO
		int totalPortatiles = 0;
		if (rs.next()) {                  // el rs.next actua como un bucle, con lo que puedo contar los elementos con él. 
			o = new Portatil();
			o.setId(rs.getInt("id"));
			o.setModelo(rs.getString("modelo"));
			o.setSn(rs.getString("sn"));
			o.setNumProcesadores(rs.getInt("numProcesadores"));
			o.setVendido(rs.getBoolean("vendido"));
			o.setFechaVenta(rs.getDate("fechaVenta"));
			o.setIdMarca(rs.getInt("idMarca"));

			totalPortatiles++;
		}
		return o;
	}
	
}

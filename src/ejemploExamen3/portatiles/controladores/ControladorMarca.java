package ejemploExamen3.portatiles.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemploExamen3.portatiles.entidades.Marca;



public class ControladorMarca extends SuperControlador {

	
	private static String nombreTabla = "marca";
	
	public static List<Marca> getTodos(){
		List<Marca> lista = new ArrayList<Marca>();
		
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from " + nombreTabla );
			
			while (rs.next()) {
				Marca m = new Marca();
				m.setId(rs.getInt("id"));
				m.setDenominacion(rs.getString("denominacion"));
				m.setIdPais(rs.getInt("idPais"));
				lista.add(m);
			}
			
			
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return lista;
	}
	

	
	// SI PONGO DEBAJO DEL WHILE    Entonce suso el método de abajo. .. pero eso lo mismo.
	//  Marca m = getEntidadFromResultSet(rs);
	

//	private static Marca getEntidadFromResultSet (ResultSet rs) throws SQLException {
//		Marca o = new Marca();
//		o.setId(rs.getInt("id"));
//		o.setDenominacion(rs.getString("descripcion"));
//		m.setIdPais(rs.getInt("idPais"));
//		return o;
//	}
	
}

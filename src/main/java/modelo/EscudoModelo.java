package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EscudoModelo {
	
	private static Conector conector;
	
	public static Escudo getUnEscudo(int id) {
		
		Escudo escudo = new Escudo();
		String query = "SELECT * FROM ESCUDOS WHERE id = ?";
		try {
			PreparedStatement pst = conector.getCn().prepareStatement(query);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			escudo.setId(rs.getInt("id"));
			escudo.setNombre(rs.getString("nombre"));
			escudo.setCapacidad_defensa(rs.getInt("capacidad_defensa"));
			
			pst.execute();
			} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return escudo;
	}

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
	
}

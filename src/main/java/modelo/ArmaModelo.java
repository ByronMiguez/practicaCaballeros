package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ArmaModelo {

	private Conector conector;
	
	public Arma getUnArma(int id) {
		Arma arma = new Arma();
		String query = "SELECT * FROM ARMAS WHERE id = ?";
		try {
		
			PreparedStatement pst = conector.getCn().prepareStatement(query);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			arma.setId(rs.getInt("id"));
			arma.setNombre(rs.getString("nombre"));
			arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
			arma.setFoto(rs.getString("foto"));
			
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		return arma;
	}

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}
	
}

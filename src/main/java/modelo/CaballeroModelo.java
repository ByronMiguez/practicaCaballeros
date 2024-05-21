package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CaballeroModelo {

	private Conector conector;
	
	public ArrayList<Caballero> getTodos() {
		ArrayList<Caballero> caballeros = new ArrayList<>();

		try {
            Statement st = conector.getCn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM caballeros");
            while(rs.next()) {
            	Caballero caballero = new Caballero();
            	caballero.setId(rs.getInt("id"));
            	caballero.setNombre(rs.getString("nombre"));
            	caballero.setFuerza(rs.getInt("fuerza"));
            	caballero.setExperiencia(rs.getInt("experiencia"));
            	caballero.setFoto(rs.getString("foto"));
            	
            	EscudoModelo em = new EscudoModelo();
            	em.setConector(conector);
            	Escudo escudo = em.getUnEscudo(rs.getInt("escudo_id"));
            	caballero.setEscudo(escudo);
            	
            	ArmaModelo am = new ArmaModelo(); 
            	am.setConector(conector);
            	Arma arma = am.getUnArma(rs.getInt("arma_id"));
            	caballero.setArma(arma);
            	
            	caballeros.add(caballero);
            }
		} catch (Exception e) {
			return null;
		}
		return caballeros;
	}

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}


}

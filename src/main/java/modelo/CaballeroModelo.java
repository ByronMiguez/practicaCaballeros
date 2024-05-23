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


	public void insert (Caballero caballero) {
		
		String sql = "INSERT INTO caballeros(nombre, fuerza, experiencia, foto, arma_id, escudo_id) VALUES(?,?,?,?,?,?)";
		try {
		PreparedStatement pst = conector.getCn().prepareStatement(sql);
		pst.setString(1, caballero.getNombre());
		pst.setInt(2, caballero.getFuerza());
		pst.setInt(3, caballero.getExperiencia());
		pst.setString(4, caballero.getFoto());
		pst.setInt(5, caballero.getArma().getId());
		pst.setInt(6, caballero.getEscudo().getId());
		
		pst.execute();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static boolean validador (Caballero caballero) {
		boolean resultado= false;
		CaballeroModelo cm = new CaballeroModelo();
		
		if(caballero.getNombre().isBlank()||caballero.getArma()==null||caballero.getEscudo()==null) {
			resultado= false;
			return resultado;
		}else {
			resultado= true;
		}
		
		if(!(0<caballero.getFuerza()&&caballero.getFuerza()<100)) {
			resultado= false;
			return resultado;
		}else {
			resultado= true;
		}
		 if (cm.nombreRepe(caballero.getNombre())) {
	            resultado = false;
	        }
		 else {
			 resultado = true;
		 }
		
		
		return resultado;
	}
	
	public boolean nombreRepe(String nombre) {
        boolean repetido = false;
        String sql = "SELECT nombre FROM caballeros WHERE nombre = ?";

        try (PreparedStatement pst = conector.getCn().prepareStatement(sql)) {
            pst.setString(1, nombre);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    repetido = true;
                }
                else {
					repetido = false;
				}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return repetido;
    }
	
}

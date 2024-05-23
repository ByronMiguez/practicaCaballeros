package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import modelo.ArmaModelo;
import modelo.Caballero;
import modelo.CaballeroModelo;
import modelo.Conector;
import modelo.EscudoModelo;

/**
 * Servlet implementation class CreateCaballero
 */
@WebServlet("/CreateCaballero")
public class CreateCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Nombre = request.getParameter("nombre");
		int Fuerza = Integer.parseInt(request.getParameter("fuerza"));
		int Experiencia = Integer.parseInt(request.getParameter("experiencia"));
		String Foto = request.getParameter("foto");
		int Arma = Integer.parseInt(request.getParameter("arma_id"));
		int Escudo = Integer.parseInt(request.getParameter("escudo_id"));
		
		Caballero caballero = new Caballero();
		caballero.setNombre(Nombre);
		caballero.setFuerza(Fuerza);
		caballero.setExperiencia(Experiencia);
		caballero.setFoto(Foto);
		
		ArmaModelo am = new ArmaModelo();
		am.setConector(new Conector());
		caballero.setArma(am.getUnArma(Arma));
		
		EscudoModelo em = new EscudoModelo();
		em.setConector(new Conector());
		caballero.setEscudo(em.getUnEscudo(Escudo));
	
		CaballeroModelo cm = new CaballeroModelo();
		cm.setConector(new Conector());
		Boolean resultado = false;
		if(resultado = cm.validador(caballero))  {
			cm.insert(caballero);
			response.sendRedirect("PanelCaballero?msg=ok");
			
		}else {
			response.sendRedirect("PanelCaballero?msg=no");
		}
		
	}

}

package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Arma;
import modelo.ArmaModelo;
import modelo.Caballero;
import modelo.CaballeroModelo;
import modelo.Conector;

/**
 * Servlet implementation class PanelCaballero
 */
@WebServlet("/PanelCaballero")
public class PanelCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CaballeroModelo cm = new CaballeroModelo();
		cm.setConector(new Conector());
		
		ArrayList<Caballero> caballeros = cm.getTodos();
	
		request.setAttribute("caballeros",caballeros);
		
		request.setAttribute("msg", request.getParameter("msg"));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda").toLowerCase();
		
		CaballeroModelo cm = new CaballeroModelo();
		cm.setConector(new Conector());
		ArrayList<Caballero> caballeros = cm.getTodos();
		
		Iterator<Caballero> it = caballeros.iterator();
		
		while (it.hasNext()) {
			if (!it.next().getNombre().toLowerCase().contains(busqueda)){
				it.remove();
			}
			
		}
		
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

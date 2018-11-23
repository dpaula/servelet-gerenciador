package br.com.lima.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lima.model.Empresa;
import br.com.lima.util.JPAUtil;

/**
 * Servlet implementation class ListaEmpresaServlet
 */
@WebServlet("/listaEmpresa")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		//TRAZENDO TODAS AS EMPRESAS DO BANCO
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		String jpql = "select e from Empresa e";
		
		//usando TypedQuery para trazer a lista já com a tipagem correga
		TypedQuery<Empresa> query = em.createQuery(jpql, Empresa.class);
		List<Empresa> empresas = query.getResultList();
		
		out.println("<html><body>");
		out.println("<ul>");
		
		//imprimindo as empresas em uma lista
		for (Empresa empresa : empresas) {
			out.println("<li>"+empresa.getNome()+"</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
	}

}

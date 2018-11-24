package br.com.lima.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
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

		
		//TRAZENDO TODAS AS EMPRESAS DO BANCO
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		String jpql = "select e from Empresa e";
		
		//usando TypedQuery para trazer a lista j� com a tipagem correga
		TypedQuery<Empresa> query = em.createQuery(jpql, Empresa.class);
		List<Empresa> empresas = query.getResultList();
		
		//setando as empresas no request para ser usado na pagina jsp que ser� redirecionada
		request.setAttribute("empresas", empresas);
		
		//fazendo redirecionamento para pagina jsp
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
		
	}

}

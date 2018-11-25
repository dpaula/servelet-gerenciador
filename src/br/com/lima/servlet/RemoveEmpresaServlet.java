package br.com.lima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lima.dao.EmpresaDao;

/**
 * Servlet implementation class RemoveEmpresaServlet
 */
@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idEmpresa = request.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);
		
		//removendo a empresa pelo dao
		new EmpresaDao().removeEmpresa(id);
		
		//fazendo um redirecionamento, finalizando o request atual e iniciando uma nova requisição
		response.sendRedirect("listaEmpresa");
		System.out.println("foi..");
		
	}

}

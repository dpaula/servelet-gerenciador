package br.com.lima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lima.dao.EmpresaDao;
import br.com.lima.model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Cadastrando empresa!!");
		
		//metodo usado por padrão GET, passagens de parametros pela uri
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Nova empresa "+nomeEmpresa+", cadastrada com sucesso!</body></html>");

		if(nomeEmpresa != null && !nomeEmpresa.equals("")) {
			
			EmpresaDao dao = new EmpresaDao();
			dao.insereEmpresa(new Empresa().setNome(nomeEmpresa));
		}
	}

}

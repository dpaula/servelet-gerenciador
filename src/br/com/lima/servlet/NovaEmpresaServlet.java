package br.com.lima.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando empresa!!");

		// metodo usado por padrão GET, passagens de parametros pela uri
		String nomeEmpresa = request.getParameter("nomeEmpresa");

		EmpresaDao dao = new EmpresaDao();
		Empresa empresa = new Empresa().setNome(nomeEmpresa);
		if(dao.insereEmpresa(empresa)) {
			request.setAttribute("nomeEmpresa", nomeEmpresa);
		}else {
			request.setAttribute("nomeEmpresa", null);
		}
		
		
		//criando um redirecionamento para a pagina jsp
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresa.jsp");
		rd.forward(request, response);
	}

}

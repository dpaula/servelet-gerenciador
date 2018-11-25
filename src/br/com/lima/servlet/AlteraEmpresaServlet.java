package br.com.lima.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Alterando empresa!!");

		// metodo usado por padrão GET, passagens de parametros pela uri
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		//todo atributo de parametro vem como string
		String data = request.getParameter("data");
		String idEmpresa = request.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);
		
		Date dataP = null;
		
		try {
			//fazendo o parse da data string para java.util.Date
			dataP = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		} catch (ParseException e) {
			//relançando a exceção para não perder
			throw new ServletException(e);
		}

		EmpresaDao dao = new EmpresaDao();
		Empresa empresa = new Empresa()
				.setNome(nomeEmpresa)
				.setData(dataP)
				.setId(id);
		dao.alteraEmpresa(empresa);
		
		//finalizando a ultima requisição e iniciando uma nova, atraves de um redirecionamento para o novo servlet
		//302 -> 200
		//todos os atributos pendurados no request foram perdidos, pois será iniciado um novo request
		response.sendRedirect("listaEmpresa");
		System.out.println("foi para listagem");
//		//criando um redirecionamento para a pagina jsp
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresa");
//		rd.forward(request, response);
	}

}

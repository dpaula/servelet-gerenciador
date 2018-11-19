package br.com.lima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//definindo url que será buscada ex.: http://localhost:8080/servlet-gerenciador/primeiro
@WebServlet(urlPatterns = "/primeiro")
public class OlaServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Testando primeiro servlet novamente!!");
		out.println("</body>");
		out.println("</html>");

	}
}

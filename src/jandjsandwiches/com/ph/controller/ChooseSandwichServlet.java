package jandjsandwiches.com.ph.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jandjsandwiches.com.ph.model.Sandwich;
import jandjsandwiches.com.ph.utility.Factory;

@WebServlet("/choosesandwich.action")
public class ChooseSandwichServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sandwichType = request.getParameter("sandwichType");
		
		Sandwich newSandwich = Factory.createSandwich(sandwichType);
		
		request.setAttribute("newSandwich", newSandwich);
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}

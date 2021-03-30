package com.arvind.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arvind.model.Model;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		String samt = request.getParameter("amt");
		
		int amt = Integer.parseInt(samt);

		String sraccno = request.getParameter("raccno");
		
		int raccno = Integer.parseInt(sraccno);
		
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			m.setRaccno(raccno);
			m.setBal(amt);
			boolean b = m.transfer();
			if(b==true) {
				response.sendRedirect("TransferSucces.html");
			}
			else {
				response.sendRedirect("TransferFail.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
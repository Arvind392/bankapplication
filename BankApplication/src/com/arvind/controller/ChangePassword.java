package com.arvind.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arvind.model.Model;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("npwd");
		
		HttpSession session = request.getSession();
		
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			m.setPwd(pwd);
			boolean b = m.changePwd();
			if(b==true) {
				response.sendRedirect("ChangePwdSuccess.html");
			}
			else {
				response.sendRedirect("ChangepwdFail.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
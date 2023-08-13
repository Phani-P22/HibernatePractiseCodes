package com.digit.javaTraining.aadharEnrollmentCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.aadharEnrollmentCenter.model.AadharData;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long aadharNumber = Long.parseLong(req.getParameter("aadharNumber"));
		
		AadharData ad = new AadharData();
		HttpSession session = req.getSession();
		
		boolean isUserExists = ad.getUser(aadharNumber);
		if (!isUserExists) {
			session.setAttribute("title", "Delete");
			session.setAttribute("message", "Deleted Failed!");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Success.jsp");
			return;
		}
		
		ad.deleteUser(ad);
		session.setAttribute("title", "Delete");
		session.setAttribute("message", "Deleted Successfully!");
		session.setAttribute("redirectLink", "index.html");
		resp.sendRedirect("Success.jsp");
	}
}

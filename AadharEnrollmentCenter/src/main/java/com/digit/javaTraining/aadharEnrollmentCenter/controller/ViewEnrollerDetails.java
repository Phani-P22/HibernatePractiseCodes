package com.digit.javaTraining.aadharEnrollmentCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.aadharEnrollmentCenter.model.AadharData;

@WebServlet("/viewEnrollerDetails")
public class ViewEnrollerDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long curAadharNumber = Long.parseLong(req.getParameter("aadharNumber"));

		AadharData ad = new AadharData();
		HttpSession session = req.getSession();

		boolean isUserExists = ad.getUser(curAadharNumber);
		if (isUserExists) {
			session.setAttribute("curUser", ad);
			resp.sendRedirect("ViewEnrollerDetails.jsp");
			return;
		} else {
			session.setAttribute("title", "View Details");
			session.setAttribute("message", "Aadhar Invalid!");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Success.jsp");
			return;
		}
	}
}

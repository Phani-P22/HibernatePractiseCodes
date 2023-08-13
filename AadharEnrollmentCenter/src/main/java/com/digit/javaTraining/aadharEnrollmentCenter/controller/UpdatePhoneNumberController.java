package com.digit.javaTraining.aadharEnrollmentCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.aadharEnrollmentCenter.model.AadharData;

@WebServlet("/updatePhoneNumber")
public class UpdatePhoneNumberController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long aadharNumber = Long.parseLong(req.getParameter("aadharNumber"));
		Long newPhone = Long.parseLong(req.getParameter("newPhoneNumber"));
		HttpSession session = req.getSession();

		AadharData ad = new AadharData();

		boolean isUserExists = ad.getUser(aadharNumber);
		if (!isUserExists) {
			session.setAttribute("title", "Update PhoneNumber");
			session.setAttribute("message", "PhoneNumber Update Failed!");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Success.jsp");
			return;
		}

		ad.updatePhoneNumber(aadharNumber, newPhone);
		session.setAttribute("title", "Update PhoneNumber");
		session.setAttribute("message", "PhoneNumber Updated Successfully!");
		session.setAttribute("redirectLink", "index.html");
		resp.sendRedirect("Success.jsp");
		return;
	}
}

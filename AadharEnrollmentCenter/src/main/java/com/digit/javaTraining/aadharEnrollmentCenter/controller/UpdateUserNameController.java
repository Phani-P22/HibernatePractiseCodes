package com.digit.javaTraining.aadharEnrollmentCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.aadharEnrollmentCenter.model.AadharData;

@WebServlet("/updateUserName")
public class UpdateUserNameController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		HttpSession session = req.getSession();

		Long aadharNumber = Long.parseLong(req.getParameter("aadharNumber"));
		String newName = req.getParameter("newName");

		AadharData ad = new AadharData();

		boolean isUserExists = ad.getUser(aadharNumber);
		if (!isUserExists) {
			session.setAttribute("title", "Update Name");
			session.setAttribute("message", "Name Update Failed!");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Success.jsp");
			return;
		}

		ad.updateName(aadharNumber, newName);
		session.setAttribute("title", "Update Name");
		session.setAttribute("message", "Name Updated Success!");
		session.setAttribute("redirectLink", "index.html");
		resp.sendRedirect("Success.jsp");
		return;

	}
}

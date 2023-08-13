package com.digit.javaTraining.aadharEnrollmentCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.aadharEnrollmentCenter.model.AadharData;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AadharData curAadharData = new AadharData();

		curAadharData.setName(req.getParameter("name"));
		curAadharData.setEmail(req.getParameter("email"));
		curAadharData.setPhoneNumber(Long.parseLong(req.getParameter("phoneNumber")));
		curAadharData.setAddressLine(req.getParameter("addressLine"));
		curAadharData.setCity(req.getParameter("city"));
		curAadharData.setState(req.getParameter("state"));
		curAadharData.setPinCode(Integer.parseInt(req.getParameter("pinCode")));

		Long newAadharNumber = curAadharData.generateRandomAadharNumber();
		curAadharData.setAadharNumber(newAadharNumber);

		curAadharData.registerUser(curAadharData);
		
		HttpSession session = req.getSession();
		session.setAttribute("title", "Registration");
		session.setAttribute("message", "Registered Successfully!");
		session.setAttribute("redirectLink", "index.html");
		resp.sendRedirect("Success.jsp");
	}
}

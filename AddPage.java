package com.saquibindia;
	import java.io.IOException;


	import java.io.PrintWriter;
	import java.sql.SQLException;

	import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.saquibindia.dao.StudentDao;
	import com.saquibindia.modle.Student;
	//@WebServlet("/AddPage")
	public class AddPage extends HttpServlet{
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String name = req.getParameter("empName");
			Integer roll = Integer.parseInt(req.getParameter("empId"));
			Double fees = Double.parseDouble(req.getParameter("empSal"));
			
			Student student = new Student();
			student.setStName(name);
			student.setStRoll(roll);
			student.setStFees(fees);
			
			try {
				StudentDao stDao = new StudentDao();
				int x = stDao.addRecord(student);
				out.println("<h1>"+x+"Your Data has been Updated!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}

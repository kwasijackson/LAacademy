package Servlets;

import java.io.IOException;
import java.util.List;

import entities.LAClasses;
import entities.LAClassesDao;
import entities.LAStudents;
import entities.LAStudentsDao;
import entities.LASubjects;
import entities.LASubjectsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int Id = Integer.parseInt(request.getParameter("Cid"));
		LAClasses clazz = LAClassesDao.getOneclass(Id);
		request.setAttribute("clazz", clazz);
		List<LASubjects> sublist =LASubjectsDao.getSubjectsByClass(clazz);
		request.setAttribute("subjectslist", sublist);
		
		List<LAStudents> stulist =LAStudentsDao.getStudentsByClass(clazz);
		request.setAttribute("studentlist", stulist);
		System.out.println("students are " + stulist);
		RequestDispatcher  rd = getServletContext().getRequestDispatcher("/Report.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

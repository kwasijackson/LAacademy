package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.LAClasses;
import entities.LAStudentsDao;
import entities.LASubjects;
import entities.LASubjectsDao;
import entities.LATeachers;

/**
 * Servlet implementation class AddSubject
 */
@WebServlet("/addSubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectname = request.getParameter("subjectname") ;
		int subjectclass = Integer.parseInt(request.getParameter("subjectclass"));
		int teachername = Integer.parseInt(request.getParameter("teachername"));
         LAClasses ls =new LAClasses();
         ls.setClassId(subjectclass);
         LATeachers teacher = new LATeachers();
         teacher.setTeacherId(teachername);
         LASubjectsDao.addsubject(subjectname, teacher,ls);
        RequestDispatcher  rd = getServletContext().getRequestDispatcher("/showAllSubjects.jsp");
	    rd.forward(request, response);
	}

}

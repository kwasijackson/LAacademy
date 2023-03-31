package entities;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LAStudentsDao {
	public static void addstudent(String studentName, LAClasses clst) {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Transaction tx=null;
			try { 
				
				Session session = factory.openSession();
				tx = session.beginTransaction();
				LAStudents student=new LAStudents(studentName, clst);
				session.save(student);
				tx.commit();
				session.close();
				
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}

	       } 
		@SuppressWarnings({ "deprecation", "unchecked" })
		public static ArrayList<LAStudents> showAllstudents() {
			Transaction tx=null;
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    ArrayList<LAStudents> stulist=null;
		    try {
		    	
		    	Session session = factory.openSession();
		    	tx = session.beginTransaction();
		    	stulist = (ArrayList<LAStudents>) session.createCriteria(LAStudents.class).list();
				tx.commit();
				session.close();
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    	if (tx != null) {
		    		tx.rollback();
		    	}
		    }
		    return stulist;
		}
		public static ArrayList<LAStudents> getStudentsByClass(LAClasses Id) {
			Transaction tx=null;
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    ArrayList<LAStudents> studentlist=null;
		    try {
		    	
		    	Session session = factory.openSession();
		    	tx = session.beginTransaction();
		    	Query q = session.createQuery("select s from LAStudents s where s.clst=:Id" );
		    	q.setParameter("Id",Id);
		    	studentlist = (ArrayList<LAStudents>) q.getResultList();
				tx.commit();
				session.close();
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    	if (tx != null) {
		    		tx.rollback();
		    	}
		    }
		    return studentlist;
		}

}

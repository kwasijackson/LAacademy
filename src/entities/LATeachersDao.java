package entities;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LATeachersDao {

	public static void addteacher(String teacherName) {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Transaction tx=null;
			try { 
				
				Session session = factory.openSession();
				tx = session.beginTransaction();
				LATeachers teacher=new LATeachers(teacherName);
				session.save(teacher);
				tx.commit();
				session.close();
				
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}

	       } 
		@SuppressWarnings({ "deprecation", "unchecked" })
		public static ArrayList<LATeachers> showAllteachers() {
			Transaction tx=null;
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    ArrayList<LATeachers> teacherlist=null;
		    try {
		    	
		    	Session session = factory.openSession();
		    	tx = session.beginTransaction();
				teacherlist = (ArrayList<LATeachers>) session.createCriteria(LATeachers.class).list();
				tx.commit();
				session.close();
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    	if (tx != null) {
		    		tx.rollback();
		    	}
		    }
		    return teacherlist;
		}
		

}

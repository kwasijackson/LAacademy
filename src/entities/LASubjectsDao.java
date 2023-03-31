package entities;

import java.util.ArrayList;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


public class LASubjectsDao {
	public static void addsubject(String subjectName, LATeachers teacher, LAClasses clas) {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Transaction tx=null;
			try { 
				
				Session session = factory.openSession();
				tx = session.beginTransaction();
				LASubjects subject=new LASubjects(subjectName,teacher, clas);
				session.save(subject);
				tx.commit();
				session.close();
				
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}

	       } 
		@SuppressWarnings({ "deprecation", "unchecked" })
		public static ArrayList<LASubjects> showAllsubjects() {
			Transaction tx=null;
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    ArrayList<LASubjects> subjectlist=null;
		    try {
		    	
		    	Session session = factory.openSession();
		    	tx = session.beginTransaction();
		    	subjectlist = (ArrayList<LASubjects>) session.createCriteria(LASubjects.class).list();
				tx.commit();
				session.close();
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    	if (tx != null) {
		    		tx.rollback();
		    	}
		    }
		    return subjectlist;
		}

		@SuppressWarnings({ "deprecation", "unchecked" })
		public static ArrayList<LASubjects> getSubjectsByClass(LAClasses Id) {
			Transaction tx=null;
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    ArrayList<LASubjects> subjectlist=null;
		    try {
		    	
		    	Session session = factory.openSession();
		    	tx = session.beginTransaction();
		    	Query q = session.createQuery("select s from LASubjects s where s.clas=:Id" );
		    	q.setParameter("Id",Id);
		    	subjectlist = (ArrayList<LASubjects>) q.getResultList();
				tx.commit();
				session.close();
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    	if (tx != null) {
		    		tx.rollback();
		    	}
		    }
		    return subjectlist;
		}
		
		public static void deleteSubject(int Id) {
			Transaction tx=null;
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			LASubjects sublist=null;
		    try {
		    	
		    	Session session = factory.openSession();
		    	tx = session.beginTransaction();
				sublist = (LASubjects) session.find(LASubjects.class,Id);
				session.delete(sublist);
				tx.commit();
				session.close();
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    	if (tx != null) {
		    		tx.rollback();
		    	}
		    }
		    
		}


}

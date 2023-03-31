package entities;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class LAClassesDao {
	public static void addclass(String cname) {
	 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Transaction tx=null;
		try { 
			
			Session session = factory.openSession();
			tx = session.beginTransaction();
			LAClasses cls1=new LAClasses(cname);
			session.save(cls1);
			tx.commit();
			session.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}

       } 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static ArrayList<LAClasses> showAllclasses() {
		Transaction tx=null;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    ArrayList<LAClasses> clslist=null;
	    try {
	    	
	    	Session session = factory.openSession();
	    	tx = session.beginTransaction();
			clslist = (ArrayList<LAClasses>) session.createCriteria(LAClasses.class).list();
			tx.commit();
			session.close();
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    	if (tx != null) {
	    		tx.rollback();
	    	}
	    }
	    return clslist;
	}
	
	public static LAClasses getOneclass(int Id) {
		Transaction tx=null;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    LAClasses clslist=null;
	    try {
	    	
	    	Session session = factory.openSession();
	    	tx = session.beginTransaction();
			clslist = (LAClasses) session.find(LAClasses.class,Id);
			tx.commit();
			session.close();
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    	if (tx != null) {
	    		tx.rollback();
	    	}
	    }
	    return clslist;
	}

}

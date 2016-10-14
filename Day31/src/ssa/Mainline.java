package ssa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mainline {
	
	public static void main(String[] args) {
		
		int nMajorId;
		
		System.out.println("Print List");
		printMajors();
		
		
		Major major = new Major("African Diaspora", 1787);
		nMajorId = addMajor(major);
		System.out.println("Add Major");
		System.out.println(getMajor(nMajorId));
		
		uMajorReqSatScore(nMajorId, 1300);
		System.out.println("Major update");
		System.out.println(getMajor(nMajorId));
	
		
		deleteMajor(nMajorId);
		System.out.println("Deleted List");
		printMajors();
		
		System.out.println("print");
		

	}
	

	public static int addMajor(Major major) {
		
		SessionFactory factory = buildFactory();
		Session session = factory.getCurrentSession();
		int id = -1;
		try {
			
			session.beginTransaction();		
			id = (int) session.save(major);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
			
		return id;
	}
	
	public static void deleteMajor(int id) {
		
		SessionFactory factory = buildFactory();
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			Major major = session.get(Major.class, id);
			session.delete(major);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	
	public static void uMajorReqSatScore(int id, int req_sat) {
		SessionFactory factory = buildFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Major major = session.get(Major.class, id);
			major.setReq_sat(req_sat);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	public static void upMajorDescr(int id, String newDesc) {
		SessionFactory factory = buildFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Major major = session.get(Major.class, id);
			major.setDescription(newDesc);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	
	public static Major getMajor(int id) {
		SessionFactory factory = buildFactory();
		Session session = factory.getCurrentSession();
		
		Major major = null;
		try {
			session.beginTransaction();
			major = session.get(Major.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			factory.close();
		}
		
		return major;
	}
	

	public static void printMajors() {
		
		SessionFactory factory = buildFactory();
		Session session = factory.getCurrentSession();
		List<Major> majors = null;
		try {
			session.beginTransaction();
			majors = session.createQuery("from Major").list();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		System.out.println("ID | Description | Required SAT Score");
		displayList(majors);
	}
	
	
		public static void print(String wClause) {
			
			SessionFactory factory = buildFactory();
			Session session = factory.getCurrentSession();
			List<Major> majors = null;
			try {
				session.beginTransaction();
				majors = session.createQuery("from Major WHERE " + wClause).list();
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				factory.close();
			}
			
			System.out.println("ID | Description | Required SAT Score");
			displayList(majors);
		}
		
		public static void displayList(List<Major> list) {
			for(Major major : list) {
				System.out.println(major);
			}
		}

	
	public static SessionFactory buildFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Major.class)
				.buildSessionFactory();
		
		return factory;
	}
	

	
}

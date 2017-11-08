package com.revature.dao;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.revature.utils.HibernateUtil;

public class DatabaseDAOImpl {
	public String deleteAll() {
		String message;
		Session session = HibernateUtil.getSession().openSession();

		try {
			StoredProcedureQuery query2 = session.createStoredProcedureQuery("admin.truncateAllDevTeam");
			query2.execute();
			System.out.println("Delete All Executed");
			message = "Database Emptied Successfully";
			return message;
		} catch (Exception e) {
			message = "Database Empty Error";
			return message;
		} finally {
			session.close();
		}
	}

	public String populate() {
		Session session = HibernateUtil.getSession().openSession();
		String message;
		try {
			StoredProcedureQuery query2 = session.createStoredProcedureQuery("admin.populateAllTables_PROC");
			query2.execute();
			System.out.println("Dummy Population Executed");
			message = "Database Population Successfull";
			return message;
		} catch (Exception e) {
			message = "Error: Data Exists";
			return message;
		} finally {
			session.close();
		}
	}
}

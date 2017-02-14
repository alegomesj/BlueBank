package main.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import main.model.Correntista;
import main.util.HibernateUtil;

/**
 * @author - Alexandre Jardim
 * @since - 13/02/2017
 */

public class CorrentistaDAO {
	private static final long serialVersionUID = 1L;
	protected Session session;
	
	public void save(Correntista c) {
		session = HibernateUtil.getSessionfactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(c);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Correntista> listAll() {
		session = HibernateUtil.getSessionfactory().openSession();
		try {
			Criteria cr = session.createCriteria(Correntista.class);
			cr.addOrder(Order.asc("cli_nome"));
			return cr.list();
			//return session.createCriteria(Correntista.class, "c").list();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Correntista buscaCorrentista(String agencia, String conta){
		session = HibernateUtil.getSessionfactory().openSession();
		try {
			Criteria cr = session.createCriteria(Correntista.class);
			cr.add(Restrictions.eq("cli_agencia", agencia));
			cr.add(Restrictions.eq("cli_contacorrente", conta));			
			return (Correntista) cr.uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}
}

package main.util;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import main.model.Correntista;
import main.model.Transferencias;

/**
* @author - Alexandre Jardim
 * @since - 13/02/2017
 */


public class HibernateUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure()
					.addPackage("model")
					.addAnnotatedClass(Correntista.class)
					.addAnnotatedClass(Transferencias.class).buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}

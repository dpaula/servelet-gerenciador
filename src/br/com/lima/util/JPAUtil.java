package br.com.lima.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emFabrica = Persistence.createEntityManagerFactory("gerenciador");

	private static JPAUtil instancia;
	
	private JPAUtil() {
		
	}
	
	public static JPAUtil getInstance() {
		if(instancia == null) {
			instancia = new JPAUtil();
		}
		return instancia;
	}

	public EntityManager getEntityManager() {
		return emFabrica.createEntityManager();
	}

}

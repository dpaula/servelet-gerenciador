package br.com.lima.dao;

import javax.persistence.EntityManager;

import br.com.lima.model.Empresa;
import br.com.lima.util.JPAUtil;

public class EmpresaDao {

	public void insereEmpresa(Empresa empresa) {

		EntityManager em = JPAUtil.getInstance().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(empresa);
		
		em.getTransaction().commit();
		em.close();
		
	}


}

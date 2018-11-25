package br.com.lima.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.lima.model.Empresa;
import br.com.lima.util.JPAUtil;

public class EmpresaDao {

	public boolean insereEmpresa(Empresa empresa) {

		if (empresa == null || "".equals(empresa.getNome())) {
			throw new IllegalArgumentException("Empresa");
		}

		Empresa emp = selecionaEmpresaPeloNome(empresa.getNome());

		if (emp != null) {
			return false;
		}

		//criando um entityManager para as transacoes
		EntityManager em = JPAUtil.getInstance().getEntityManager();

		//iniciando uma transa��o
		em.getTransaction().begin();

		//persistindo a entidade na base
		em.persist(empresa);

		//comitando e fechando a transa��o
		em.getTransaction().commit();
		em.close();

		return true;

	}

	private Empresa selecionaEmpresaPeloNome(String nome) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		Empresa empresa = null;
		em.getTransaction().begin();

		//criando uma consulta para trazer a empresa pelo nome, definindo que vir� um objeto unico do tipo Empresa
		TypedQuery<Empresa> query = em.createQuery("select e from Empresa e where e.nome = :pNome", Empresa.class);
		//setando um parametro
		query.setParameter("pNome", nome);
		//fazendo o tratamento pois, se n�o achar resultado, ser� lan�ada uma exce��o NoResultException
		try {
			empresa = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		em.close();
		return empresa;
	}

}

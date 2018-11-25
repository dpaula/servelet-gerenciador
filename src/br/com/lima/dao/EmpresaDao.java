package br.com.lima.dao;

import java.util.List;

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

		// criando um entityManager para as transacoes
		EntityManager em = JPAUtil.getInstance().getEntityManager();

		// iniciando uma transação
		em.getTransaction().begin();

		// persistindo a entidade na base
		em.persist(empresa);

		// comitando e fechando a transação
		em.getTransaction().commit();
		em.close();

		return true;

	}

	private Empresa selecionaEmpresaPeloNome(String nome) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		Empresa empresa = null;
		em.getTransaction().begin();

		// criando uma consulta para trazer a empresa pelo nome, definindo que virá um
		// objeto unico do tipo Empresa
		TypedQuery<Empresa> query = em.createQuery("select e from Empresa e where e.nome = :pNome", Empresa.class);
		// setando um parametro
		query.setParameter("pNome", nome);
		// fazendo o tratamento pois, se não achar resultado, será lançada uma exceção
		// NoResultException
		try {
			empresa = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		em.close();
		return empresa;
	}

	public void removeEmpresaPorId(Integer id) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		em.getTransaction().begin();

		// primeiro busca a empresa pelo id
		Empresa empresa = em.find(Empresa.class, id);
		// depois basta usar o EntityManager para remover
		em.remove(empresa);

		// comitando e fechando a transação
		em.getTransaction().commit();
		em.close();
	}

	public List<Empresa> retornaEmpresas() {

		// TRAZENDO TODAS AS EMPRESAS DO BANCO
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		String jpql = "select e from Empresa e";

		// usando TypedQuery para trazer a lista já com a tipagem correga
		TypedQuery<Empresa> query = em.createQuery(jpql, Empresa.class);
		return query.getResultList();
	}

	public Empresa retornaEmpresaPorId(Integer id) {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		em.getTransaction().begin();
		
		Empresa empresa = null;
		
		// primeiro busca a empresa pelo id
		empresa = em.find(Empresa.class, id);
		em.close();
		
		return empresa;
		
	}

	public void alteraEmpresa(Empresa empresaNova) {
		
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		em.getTransaction().begin();
		
		// primeiro busca a empresa pelo id
		Empresa empresa = em.find(Empresa.class, empresaNova.getId());
		// ao setar novos valores, os mesmos já serão persistidos
		empresa.setNome(empresaNova.getNome())
		.setData(empresaNova.getData());
		
		// comitando e fechando a transação
		em.getTransaction().commit();
		em.close();
		
		
	}

}

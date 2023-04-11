package br.com.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.crud.model.Tarefa;

/**
 * Classe de acesso à base de dados.
 * Contém as consultas utilizadas pela aplicação.
 * 
 * @author João Manoel Santos Almeida
 * @since Abril 2023
 * */
public class DAO {
	
	private static EntityManager em = null;
	
	public DAO() {
		em = ConnectionFactory.getEntityManager();
	}
	
	/**
	 * Método buscar por ID, responsável por consultar tarefa através do seu ID.
	 * @param id
	 * @return Tarefa
	 * */
	public Tarefa buscarPorId(int id) {
		return em.find(Tarefa.class, id);
	}
	
	
	/**
	 * Método inserir, responsável por inserir registro na base de dados.
	 * @param tarefa
	 * */
	public void inserir(Tarefa tarefa) {
		try {
			em.getTransaction().begin();
			em.persist(tarefa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	/**
	 * Método alterar, responsável por alterar registro na base de dados.
	 * @param tarefa
	 * */
	public void alterar(Tarefa tarefa) {
		try {
			em.getTransaction().begin();
			em.merge(tarefa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	/**
	 * Método deçetar, responsável por exluir registro na base de dados.
	 * @param tarefa
	 * */
	public void deletar(int id) {
		Tarefa tarefa = buscarPorId(id);
		try {
			em.getTransaction().begin();
			em.remove(tarefa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	/**
	 * Método buscar todos, responsável por consultar todas as tarefas na base de dados.
	 * @return {@link List}
	 * */
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTodos() {
		Query query = em.createQuery("Select t from Tarefa t");
		return query.getResultList();
	}
	
	/**
	 * Método filtrar responsável por filtrar as tarefas na base de dados.
	 * @return {@link List}
	 * */
	@SuppressWarnings("unchecked")
	public List<Tarefa> filtrar(Tarefa tarefa) {
		StringBuilder consulta = new StringBuilder("SELECT t FROM Tarefa t");
		boolean hasAnd = false;
		consulta.append(" WHERE ");
		
		if(tarefa.getId() != null) {
			consulta.append(" t.id = " + tarefa.getId());
			hasAnd = true;
		}
		
		if(tarefa.getTitulo() != null && !tarefa.getTitulo().isEmpty()) {
			consulta.append(hasAnd ? " AND " : " ");
			consulta.append(" (t.titulo LIKE '%" + tarefa.getTitulo() + "%' OR ");
			consulta.append(" t.descricao LIKE '%" + tarefa.getTitulo() + "%' )");
			hasAnd = true;
		}
		
		if(tarefa.getResponsavel() != null  && !tarefa.getResponsavel().isEmpty()) {
			consulta.append(hasAnd ? " AND " : " ");
			consulta.append(" t.responsavel  = '" + tarefa.getResponsavel() + "'");
			hasAnd = true;
		}
		
		if(tarefa.getSituacao() != null  && !tarefa.getSituacao().isEmpty()) {
			consulta.append(hasAnd ? " AND " : " ");
			consulta.append(" t.situacao  = '" + tarefa.getSituacao() +"'");
		}
		
		
		Query query = em.createQuery(consulta.toString());
		return query.getResultList();
	}

}

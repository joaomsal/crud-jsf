package br.com.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.crud.model.Tarefa;

public class DAO {
	
	private static EntityManager em = null;
	
	public DAO() {
		em = ConnectionFactory.getEntityManager();
	}
	
	public Tarefa buscarPorId(int id) {
		return em.find(Tarefa.class, id);
	}
	
	
	public void inserir(Tarefa tarefa) {
		try {
			em.getTransaction().begin();
			em.persist(tarefa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public void alterar(Tarefa tarefa) {
		try {
			em.getTransaction().begin();
			em.merge(tarefa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
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
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTodos() {
		Query query = em.createQuery("Select t from Tarefa t");
		return query.getResultList();
	}
	
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
		}
		
		if(tarefa.getResponsavel() != null  && !tarefa.getResponsavel().isEmpty()) {
			consulta.append(hasAnd ? " AND " : " ");
			consulta.append(" t.responsavel  = '" + tarefa.getResponsavel() + "'");
		}
		
		if(tarefa.getSituacao() != null  && !tarefa.getSituacao().isEmpty()) {
			consulta.append(hasAnd ? " AND " : " ");
			consulta.append(" t.situacao  = '" + tarefa.getSituacao() +"'");
		}
		
		
		Query query = em.createQuery(consulta.toString());
		return query.getResultList();
	}

}

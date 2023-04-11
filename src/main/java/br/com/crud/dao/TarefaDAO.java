package br.com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.crud.model.Tarefa;

public class TarefaDAO {
	
	private Session secao;

	public Session getSecao() {
		return secao;
	}

	public void setSecao(Session secao) {
		this.secao = secao;
	}
	
	public void inserir(Tarefa tarefa) {
		this.secao.save(tarefa);
	}
	
	public void atualizar(Tarefa tarefa) {
		this.secao.update(tarefa);
	}
	
	public void deletar(Tarefa tarefa) {
		this.secao.delete(tarefa);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> listar(){
		Query query = this.secao.createQuery("from Tarefa");
		return query.list();
	}

}

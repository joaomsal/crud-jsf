package br.com.crud.rn;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crud.dao.DAO;
import br.com.crud.model.Tarefa;

public class TarefaRN implements Serializable{
	
	private static final long serialVersionUID = -1744008300168294250L;
	
	@Inject
	private DAO dao;
	
	public TarefaRN() {
		dao = new DAO();
	}
	
	
	public void inserir(Tarefa tarefa) {
		this.dao.inserir(tarefa);
	}
	
	public void atualizar(Tarefa tarefa) {
		this.dao.alterar(tarefa);
	}
	
	public void deletar(Tarefa tarefa) {
		this.dao.deletar(tarefa.getId());
	}
	
	public List<Tarefa> listar() {
		return this.dao.buscarTodos();
	}
	
	public List<Tarefa> filtrar(Tarefa tarefa) {
		return this.dao.filtrar(tarefa);
	}
	
	
	

}

package br.com.crud.rn;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crud.dao.DAO;
import br.com.crud.model.Tarefa;

/**
 * Classe com regras de negócio referente à tarefa.
 * 
 * @author João Manoel Santos Almeida
 * @since Abril 2023
 * */
public class TarefaRN implements Serializable{
	
	private static final long serialVersionUID = -1744008300168294250L;
	
	@Inject
	private DAO dao;
	
	public TarefaRN() {
		dao = new DAO();
	}
	
	/**
	 * Método inserir, responsável por salvar tarefa na base de dados.
	 * @param tarefa
	 * */
	public void inserir(Tarefa tarefa) {
		this.dao.inserir(tarefa);
	}
	
	/**
	 * Método atualizar, responsável por alterar tarefa na base de dados.
	 * @param tarefa
	 * */
	public void atualizar(Tarefa tarefa) {
		this.dao.alterar(tarefa);
	}
	
	/**
	 * Método deletar, responsável por excluir tarefa da base de dados.
	 * @param tarefa
	 * */
	public void deletar(Tarefa tarefa) {
		this.dao.deletar(tarefa.getId());
	}
	
	/**
	 * Método listar, responsável por listar todas as tarefas da base de dados.
	 * return {@link List}
	 * */
	public List<Tarefa> listar() {
		return this.dao.buscarTodos();
	}
	
	/**
	 * Método filtrar, responsável por filtrar tarefas da base de dados.
	 * @param tarefa
	 * return {@link List}
	 * */
	public List<Tarefa> filtrar(Tarefa tarefa) {
		return this.dao.filtrar(tarefa);
	}
	

}

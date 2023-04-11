package br.com.crud.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.crud.model.Tarefa;
import br.com.crud.rn.TarefaRN;
import br.com.crud.util.MensagemUtil;

/**
 * Classe do MBean de tarefa.
 * 
 * @author João Manoel Santos Almeida
 * @since Abril 2023
 * */
@ManagedBean (name = "tarefaMBean")
@ViewScoped
public class TarefaMBean implements Serializable{
	
	private static final long serialVersionUID = -4894562140709924859L;

	private Tarefa tarefa;
	
	private Tarefa selecionada;
	
	private List<Tarefa> tarefas;
	
	private TarefaRN tarefaRN;
	
	public TarefaMBean() {
		tarefa = new Tarefa();
		selecionada = new Tarefa();
		tarefas = new ArrayList<Tarefa>();
		tarefaRN = new TarefaRN();
		tarefas = tarefaRN.listar();
	}
	
	/**
	 * Método adicionar, responsável por salvar tarefa na base de dados.
	 * 
	 * */
	public void adicionar() {
		try {
			tarefa.setSituacao("em andamento");
			tarefaRN.inserir(tarefa);
			MensagemUtil.adicionarMensagemConfirmacao("Tarefa adicionada com sucesso.");
		} catch (Exception e) {
			MensagemUtil.adicionarMensagemErro("Erro ao adicionar tarefa.");
			e.printStackTrace();
		} finally {
			tarefa = new Tarefa();
		}
	}
	
	
	/**
	 * Método deletar, responsável por excluir tarefa da base de dados.
	 * 
	 * */
	public void deletar() {
		try {
			tarefaRN.deletar(selecionada);
			buscar();
			MensagemUtil.adicionarMensagemConfirmacao("Tarefa deletada com sucesso.");
		} catch (Exception e) {
			MensagemUtil.adicionarMensagemErro("Erro ao deletar tarefa.");
			e.printStackTrace();
		} finally {
			selecionada = new Tarefa();
		}
	}
	
	/**
	 * Método alterar, responsável por alterar tarefa na base de dados.
	 * 
	 * */
	public void alterar() {
		try {
			tarefaRN.atualizar(selecionada);
			buscar();
			MensagemUtil.adicionarMensagemConfirmacao("Tarefa alterada com sucesso.");
		} catch (Exception e) {
			MensagemUtil.adicionarMensagemErro("Erro ao alterada tarefa.");
			e.printStackTrace();
		} finally {
			selecionada = new Tarefa();
		}
	}
	
	/**
	 * Método concluir, responsável por atualizar a tarefa para 'concluída' na base de dados.
	 * 
	 * */
	public void concluir() {
		try {
			selecionada.setSituacao("concluída");
			tarefaRN.atualizar(selecionada);
			MensagemUtil.adicionarMensagemConfirmacao("Tarefa concluída com sucesso.");
		} catch (Exception e) {
			MensagemUtil.adicionarMensagemErro("Erro ao concluir tarefa.");
			e.printStackTrace();
		} finally {
			selecionada = new Tarefa();
		}
	}
	
	/**
	 * Método buscar, responsável por filtrar tarefas na base de dados.
	 * 
	 * */
	public void buscar() {
		try {
			tarefas = tarefaRN.filtrar(tarefa);
		} catch (Exception e) {
			MensagemUtil.adicionarMensagemErro("Ocorreu um erro durante a consulta.");
			e.printStackTrace();
		}
	}
	
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Tarefa getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Tarefa selecionada) {
		this.selecionada = selecionada;
	}
	

}

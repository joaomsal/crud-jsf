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
 * @author João Manoel Santos Almeida
 * @since Abril 2023
 * */
@ManagedBean (name = "tarefaMBean")
@ViewScoped
public class TarefaMBean implements Serializable{
	
	private static final long serialVersionUID = -4894562140709924859L;

	private Tarefa tarefa;
	
	private List<Tarefa> tarefas;
	
	private TarefaRN tarefaRN;
	
	public TarefaMBean() {
		tarefa = new Tarefa();
		tarefas = new ArrayList<Tarefa>();
		tarefaRN = new TarefaRN();
		tarefas = tarefaRN.listar();
	}
	
	public void adicionar() {
		try {
			tarefaRN.inserir(tarefa);
			MensagemUtil.adicionarMensagemConfirmacao("Tarefa adicionada com sucesso.");
		} catch (Exception e) {
			MensagemUtil.adicionarMensagemErro("Erro ao adicionar tarefa.");
			e.printStackTrace();
		}finally {
			tarefa = new Tarefa();
//			tarefas = tarefaRN.listar();
		}
	}
	
	
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
	
	

}

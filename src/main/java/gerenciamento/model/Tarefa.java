package gerenciamento.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Tarefa {

	@Id
	@GeneratedValue(generator="STORE_SEQ")
	@SequenceGenerator(name="STORE_SEQ",sequenceName="STORE_SEQ", allocationSize=1)
	private Long tarefaId;
	
	private String nomeTarefa;
	private String descricaoTarefa;
	private String categoriaTarefa;
	private String prioridadeTarefa;
	private boolean statusTarefa;
	@OneToMany(cascade = {CascadeType.ALL})
	private List<SubTarefa> listaSubTarefas;
	
	public Tarefa(String nome, String descricao, String categoria, String prioridade){
		this.nomeTarefa = nome;
		this.descricaoTarefa = descricao;
		this.categoriaTarefa = categoria.toLowerCase();
		this.prioridadeTarefa = prioridade.toUpperCase();
		this.statusTarefa = false;	
		this.listaSubTarefas = new ArrayList<SubTarefa>();
	}
	
	public Tarefa(){}
	
	public Long getTarefaId() {
		return tarefaId;
	}
	
	public void setTarefaId(Long tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	
	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}
	
	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}
	
	public String getCategoriaTarefa() {
		return categoriaTarefa;
	}
	
	public void setCategoriaTarefa(String categoriaTarefa) {
		this.categoriaTarefa = categoriaTarefa;
	}
	
	public String getPrioridadeTarefa() {
		return prioridadeTarefa;
	}
	
	public void setPrioridadeTarefa(String prioridadeTarefa) {
		this.prioridadeTarefa = prioridadeTarefa;
	}

	public boolean getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(boolean statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
	
	public List<SubTarefa> getListaSubTarefas() {
		return listaSubTarefas;
	}

	public void setListaSubTarefas(List<SubTarefa> listaSubTarefas) {
		this.listaSubTarefas = listaSubTarefas;
	}
	
	public boolean hasSubTarefa(SubTarefa subTarefa) {
		for (SubTarefa conteudoSubTarefa: getListaSubTarefas()) {
			if (conteudoSubTarefa.getSubTarefaId() == subTarefa.getSubTarefaId()) {
				return true;
			}
		}
		return false;
	}
}

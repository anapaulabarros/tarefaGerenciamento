package gerenciamento.service;

import java.util.List;

import gerenciamento.model.Tarefa;

public interface TarefaGerenciamentoService {

	public void addTarefa(Tarefa tarefa);
	public List getTodasTarefas();
	public void deletaTarefa(Long id);
	public Tarefa getTarefa(Long id);
	public Tarefa updateTarefa(Tarefa tarefa);
	public int getTotalTarefas();
	public int getTotalTarefasAbertas();
	public List findByCategoria(String categoria);
	public List findByPrioridadeTarefa(String prioridadeTarefa);
	public List getByStatusTarefa(boolean statusTarefa);
	public int getTotalByCategoria(String categoria);
	public int getTotalAbertaByCategoria(String categoria);
	public int getTotalByPrioridade(String Prioridade);
	public int getTotalAbertaByPrioridade(String prioridade);
}

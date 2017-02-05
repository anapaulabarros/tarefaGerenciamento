package gerenciamento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciamento.model.Tarefa;
import gerenciamento.repo.TarefaRepositorio;

@Service
public class TarefaGerenciamentoServiceImpl implements TarefaGerenciamentoService {

	@Autowired
	TarefaRepositorio tarefaRepositorio;
	
	@Override
	public void addTarefa(Tarefa tarefa){
		if(tarefa == null){
			throw new IllegalArgumentException("A tarefa nao pode ser nula.");
		}
		String categoriaCorrigida = removeUltimoCatectere(tarefa.getCategoriaTarefa());
		tarefa.setCategoriaTarefa(categoriaCorrigida);
		tarefaRepositorio.save(tarefa);
	}

	@Override
	public List<Tarefa> getTodasTarefas() {
		List listaTarefas = new ArrayList();
		tarefaRepositorio.findAll().forEach(listaTarefas::add);
		return listaTarefas;
	}
	
	@Override
	public int getTotalByCategoria(String categoria){
		List listaTarefas = new ArrayList();
		listaTarefas = findByCategoria(categoria);
		return listaTarefas.size();
	}
	
	@Override
	public int getTotalByPrioridade(String prioridade){
		List listaTarefas = new ArrayList();
		listaTarefas = findByPrioridadeTarefa(prioridade);
		return listaTarefas.size();
	}
	
	@Override
	public int getTotalAbertaByCategoria(String categoria){
		List<Tarefa> listaTarefas = new ArrayList();
		int totalTarefaAberta = 0;
		listaTarefas = findByCategoria(categoria);
		for (Tarefa tarefa : listaTarefas) {
			if(tarefa.getStatusTarefa() == false)
				totalTarefaAberta += 1;
		}
		return totalTarefaAberta;
	}
	
	
	@Override
	public int getTotalAbertaByPrioridade(String prioridade){
		List<Tarefa> listaTarefas = new ArrayList();
		int totalTarefaAberta = 0;
		listaTarefas = findByPrioridadeTarefa(prioridade);
		for (Tarefa tarefa : listaTarefas) {
			if(tarefa.getStatusTarefa() == false)
				totalTarefaAberta += 1;
		}
		return totalTarefaAberta;
	}
	
	@Override
	public List<Tarefa> findByCategoria(String categoria){
		List listaTarefas = new ArrayList();
		tarefaRepositorio.findByCategoriaTarefa(categoria).forEach(listaTarefas::add);
		return listaTarefas;
	}
	
	@Override
	public List<Tarefa> findByPrioridadeTarefa(String prioridadeTarefa){
		List listaTarefas = new ArrayList();
		tarefaRepositorio.findByPrioridadeTarefa(prioridadeTarefa).forEach(listaTarefas::add);
		return listaTarefas;
	}
	
	@Override
	public List<Tarefa> getByStatusTarefa(boolean statusTarefa){
		List listaTarefas = new ArrayList();
		tarefaRepositorio.getByStatusTarefa(statusTarefa).forEach(listaTarefas::add);
		return listaTarefas;
	}
	
	@Override
	public void deletaTarefa(Long id) {
		if(id == null){
			throw new IllegalArgumentException("Id da tarefa nao pode ser nula.");
		}
		if(getTarefa(id) != null){
			tarefaRepositorio.delete(id);
			System.out.println(tarefaRepositorio.count());
		}
	}

	@Override
	public Tarefa getTarefa(Long id) {
		if(id == null){
			 throw new IllegalArgumentException("Erro: Id da tarefa nao pode ser nulo.");
		}
		
		Tarefa tarefa = (Tarefa) tarefaRepositorio.findOne(id);
		if(tarefa == null) {
			throw new IllegalArgumentException("A tarefa solicitada nao existe.");
		}
		return tarefa;
	}

	@Override
	public Tarefa updateTarefa(Tarefa tarefa) {
		if(tarefa == null){
			throw new IllegalArgumentException("A tarefa eh nula");
		}
		
		Tarefa tarefaAtual = getTarefa(tarefa.getTarefaId());
		
		if(tarefaAtual == null){
			throw new IllegalArgumentException("A tarefa solicitada nao existe.");
		}
		
		BeanUtils.copyProperties(tarefa, tarefaAtual);
		return (Tarefa) tarefaRepositorio.save(tarefaAtual);
	}
	
	public int getTotalTarefas(){
		return (int) tarefaRepositorio.count();
	}
	
	public int getTotalTarefasAbertas(){
		List<Tarefa> tarefasAbertas = tarefaRepositorio.getByStatusTarefa(false);
		return tarefasAbertas.size();
	}
	
	private String removeUltimoCatectere(String palavra){
		return palavra.substring(0,palavra.length()-1);
	}

}

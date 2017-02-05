package gerenciamento.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gerenciamento.model.Tarefa;

@Repository
public interface TarefaRepositorio extends CrudRepository<Tarefa, Long>{

	List<Tarefa> findByCategoriaTarefa(String categoriaTarefa);
	List<Tarefa> findByPrioridadeTarefa(String prioridadeTarefa);
	List<Tarefa> getByStatusTarefa(boolean statusTarefa);
}

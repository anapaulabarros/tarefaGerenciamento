package gerenciamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gerenciamento.model.Tarefa;
import gerenciamento.model.Usuario;
import gerenciamento.service.TarefaGerenciamentoService;
import gerenciamento.service.UsuarioService;

@Controller
public class TarefaGerenciamentoController extends BaseController{

	@Autowired
	TarefaGerenciamentoService tarefaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET) //pagina index - carrega a lista de tarefas em aberto
	public String indexApp(Model model){
		model.addAttribute("tarefalista", tarefaService.getByStatusTarefa(false));
		model.addAttribute("totalTarefasAbertas", tarefaService.getTotalTarefasAbertas());
		return "tarefalista";
	}
	
	@RequestMapping(value = "/editacontato/{id}", method = RequestMethod.GET) //prepara pagina de edicao de contato
	public String editaContato(@PathVariable Long id, Model model){
		model.addAttribute("infocontato", usuarioService.getUsuario(id));
		return "editacontato";
	}
	
	@RequestMapping(value = "/updatecontato", method = RequestMethod.POST)//Atualiza as informacoes do contato e retorna para a pagina index
	public String atualizaContato(@ModelAttribute Usuario usuario, Model model){
		usuarioService.updateUsuario(usuario);
		model.addAttribute("tarefalista", tarefaService.getByStatusTarefa(false));
		model.addAttribute("totalTarefasAbertas", tarefaService.getTotalTarefasAbertas());
		return "tarefalista";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST) //pagina index - Filtro de tarefas
	public String filtraTarefaPorCategoria(@RequestParam int opcaoFiltro, @RequestParam String filtroTarefa,Model model){
		model.addAttribute("tarefalista",  tarefaService.getByStatusTarefa(false));
		model.addAttribute("totalTarefasAbertas", tarefaService.getTotalTarefasAbertas());
		if(opcaoFiltro == 0){
			model.addAttribute("tarefalistaFiltro", tarefaService.findByCategoria(filtroTarefa.toLowerCase()));
			model.addAttribute("totalfiltro", tarefaService.getTotalByCategoria(filtroTarefa.toLowerCase()));
			model.addAttribute("totalfiltroaberta", tarefaService.getTotalAbertaByCategoria(filtroTarefa.toLowerCase()));
		}
		if(opcaoFiltro == 1){
			model.addAttribute("tarefalistaFiltro", tarefaService.findByPrioridadeTarefa(filtroTarefa.toUpperCase()));
			model.addAttribute("totalfiltro", tarefaService.getTotalByPrioridade(filtroTarefa.toUpperCase()));
			model.addAttribute("totalfiltroaberta", tarefaService.getTotalAbertaByPrioridade(filtroTarefa.toUpperCase()));
		}
		return "tarefalista";
	}
	
	@RequestMapping(value = "/carregatarefa", method = RequestMethod.GET) //carrega pagina de add tarefa - formulario
	public String preparaAddTareda(Model model){
		model.addAttribute("tarefalista", tarefaService.getTodasTarefas());
		return "tarefa";
	}
	
	@RequestMapping(value = "/addtarefa", method = RequestMethod.POST)
	public String adicionaTarefa(@ModelAttribute Tarefa tarefa,Model model){ //Adiciona uma nova tarefa
		tarefaService.addTarefa(tarefa);
		model.addAttribute("tarefalista", tarefaService.getByStatusTarefa(false));
		model.addAttribute("totalTarefasAbertas", tarefaService.getTotalTarefasAbertas());
		return "tarefalista";
	}
	
	@RequestMapping(value = "/editatarefa/{id}", method = RequestMethod.GET) //carrega a pagina para edicao de uma tarefa especifica (por Id)
	public String editaTarefa(@PathVariable Long id, Model model){
		model.addAttribute("tarefa", tarefaService.getTarefa(id));
		return "editatarefa";
	}
	
	@RequestMapping(value = "/updatetarefa", method = RequestMethod.POST)//Atualiza a tarefa
	public String atualizaTarefa(@ModelAttribute Tarefa tarefa, Model model){
		tarefaService.updateTarefa(tarefa);
		model.addAttribute("tarefalista", tarefaService.getByStatusTarefa(false));
		model.addAttribute("totalTarefasAbertas", tarefaService.getTotalTarefasAbertas());
		return "tarefalista";
	}
	
	@RequestMapping(value = "/finalizatarefa/{id}", method = RequestMethod.GET)//Atualiza o status da tarefa
	public String finalizaTarefa(@PathVariable Long id, Model model){
		Tarefa tarefaAutal = tarefaService.getTarefa(id);
		tarefaAutal.setStatusTarefa(true);
		
		tarefaService.updateTarefa(tarefaAutal);
		model.addAttribute("tarefalista", tarefaService.getByStatusTarefa(false));
		model.addAttribute("totalTarefasAbertas", tarefaService.getTotalTarefasAbertas());
		return "tarefalista";
	}
	
	@RequestMapping(value = "/deletatarefa/{id}") //Remove uma tarefa pelo id e retorna a pagina de lista de tarefas
	public String deletaTarefa(@PathVariable Long id, Model model){
		tarefaService.deletaTarefa(id);
		model.addAttribute("tarefalista", tarefaService.getByStatusTarefa(false));
		model.addAttribute("totalTarefasAbertas", tarefaService.getTotalTarefasAbertas());
		return "tarefalista";
	}
	
	@RequestMapping(value = "/detalhestarefa/{id}") //pagina para visualizar os detalhes de uma tarefa
	public String detalharTarefa(@PathVariable Long id, Model model){
		model.addAttribute("tarefa", tarefaService.getTarefa(id));
		return "detalhatarefa";
	}
}

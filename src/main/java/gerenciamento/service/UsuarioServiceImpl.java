package gerenciamento.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gerenciamento.model.Tarefa;
import gerenciamento.model.Usuario;
import gerenciamento.repo.UsuarioRepositorio;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepositorio usuarioRepostiorio;
	
	@Override
	public Usuario getUsuario(Long id) {
		if(id == null){
			 throw new IllegalArgumentException("Erro: Id do usuario nao pode ser nulo.");
		}
		Usuario usuario = usuarioRepostiorio.findOne(id);
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario nao existe.");
		}
		return usuario;
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		if(usuario == null){
			throw new IllegalArgumentException("O usuario eh nulo");
		}
		
		Usuario usuarioAtual = getUsuario(usuario.getUsuarioId());
		
		if(usuarioAtual == null){
			throw new IllegalArgumentException("O usuario solicitado nao existe.");
		}
		
		BeanUtils.copyProperties(usuario, usuarioAtual);
		usuarioRepostiorio.save(usuarioAtual);
	}

}

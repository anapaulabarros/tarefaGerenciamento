package gerenciamento.service;

import gerenciamento.model.Usuario;

public interface UsuarioService {

	public Usuario getUsuario(Long id);
	public void updateUsuario(Usuario usuario);
}

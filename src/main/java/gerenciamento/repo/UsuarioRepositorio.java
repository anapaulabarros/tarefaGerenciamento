package gerenciamento.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gerenciamento.model.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

}

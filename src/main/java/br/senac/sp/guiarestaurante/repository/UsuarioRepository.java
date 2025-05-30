package br.senac.sp.guiarestaurante.repository;

import br.senac.sp.guiarestaurante.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

}

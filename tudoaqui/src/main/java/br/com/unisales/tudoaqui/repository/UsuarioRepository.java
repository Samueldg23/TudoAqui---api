package br.com.unisales.tudoaqui.repository;

import br.com.unisales.tudoaqui.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    List<Usuario> findByTipoUsuario(Usuario.TipoUsuario tipoUsuario);
}
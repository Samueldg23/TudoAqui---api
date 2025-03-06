package br.com.unisales.tudoaqui.repository;


import br.com.unisales.tudoaqui.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findByUsuarioId(Long usuarioId);
}
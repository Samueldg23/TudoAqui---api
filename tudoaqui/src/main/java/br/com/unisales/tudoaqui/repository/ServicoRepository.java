package br.com.unisales.tudoaqui.repository;

import br.com.unisales.tudoaqui.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    // Buscar serviços por categoria
    List<Servico> findByCategoria(Servico.CategoriaServico categoria);

    // Buscar serviços por nome (busca parcial)
    List<Servico> findByNomeContainingIgnoreCase(String nome);
}
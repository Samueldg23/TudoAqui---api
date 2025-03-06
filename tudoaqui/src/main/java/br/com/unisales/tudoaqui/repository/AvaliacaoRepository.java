package br.com.unisales.tudoaqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.tudoaqui.model.Avaliacao;
import br.com.unisales.tudoaqui.model.Pedido;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByPedido(Pedido pedido);

    // Buscar avaliações por nota 
    List<Avaliacao> findByNota(Integer nota);

    List<Avaliacao> findByPedidoPrestadorId(Long idPrestador);
}
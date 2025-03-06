package br.com.unisales.tudoaqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.tudoaqui.model.Pedido;
import br.com.unisales.tudoaqui.model.Usuario;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByCliente(Usuario cliente);

    List<Pedido> findByPrestador(Usuario prestador);

    List<Pedido> findByStatus(Pedido.StatusPedido status);
}
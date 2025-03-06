package br.com.unisales.tudoaqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.tudoaqui.model.Mensagem;
import br.com.unisales.tudoaqui.model.Usuario;

import java.util.List;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    // Buscar mensagens enviadas por um usuário
    List<Mensagem> findByRemetente(Usuario remetente);

    // Buscar mensagens recebidas por um usuário
    List<Mensagem> findByDestinatario(Usuario destinatario);

    // Buscar mensagens não lidas por destinatário
    List<Mensagem> findByDestinatarioAndLidaFalse(Usuario destinatario);
}
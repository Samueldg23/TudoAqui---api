package br.com.unisales.tudoaqui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.tudoaqui.dto.MensagemCadastroDTO;
import br.com.unisales.tudoaqui.dto.MensagemDTO;
import br.com.unisales.tudoaqui.model.Mensagem;
import br.com.unisales.tudoaqui.model.Usuario;
import br.com.unisales.tudoaqui.repository.MensagemRepository;
import br.com.unisales.tudoaqui.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public MensagemDTO enviarMensagem(MensagemCadastroDTO mensagemCadastroDTO) {
        Mensagem mensagem = new Mensagem();

        // Buscar remetente e destinatário
        Usuario remetente = usuarioRepository.findById(mensagemCadastroDTO.getIdRemetente())
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));
        Usuario destinatario = usuarioRepository.findById(mensagemCadastroDTO.getIdDestinatario())
                .orElseThrow(() -> new RuntimeException("Destinatário não encontrado"));

        // Configurar mensagem
        mensagem.setRemetente(remetente);
        mensagem.setDestinatario(destinatario);
        mensagem.setConteudo(mensagemCadastroDTO.getConteudo());
        mensagem.setDataEnvio(LocalDateTime.now());
        mensagem.setLida(false);

        mensagem = mensagemRepository.save(mensagem);
        return new MensagemDTO(mensagem); 
    }

    public MensagemDTO buscarMensagemPorId(Long id) {
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);
        if (mensagemOptional.isPresent()) {
            return new MensagemDTO(mensagemOptional.get()); 
        } else {
            throw new RuntimeException("Mensagem não encontrada");
        }
    }

    public List<MensagemDTO> listarMensagensEnviadas(Long idRemetente) {
        Usuario remetente = usuarioRepository.findById(idRemetente)
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));

        return mensagemRepository.findByRemetente(remetente).stream()
                .map(MensagemDTO::new) 
                .collect(Collectors.toList());
    }

    public List<MensagemDTO> listarMensagensRecebidas(Long idDestinatario) {
        Usuario destinatario = usuarioRepository.findById(idDestinatario)
                .orElseThrow(() -> new RuntimeException("Destinatário não encontrado"));

        return mensagemRepository.findByDestinatario(destinatario).stream()
                .map(MensagemDTO::new) 
                .collect(Collectors.toList());
    }

    // Marcar mensagem como lida
    public MensagemDTO marcarMensagemComoLida(Long id) {
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);
        if (mensagemOptional.isPresent()) {
            Mensagem mensagem = mensagemOptional.get();
            mensagem.setLida(true);

            mensagem = mensagemRepository.save(mensagem);
            return new MensagemDTO(mensagem); 
        } else {
            throw new RuntimeException("Mensagem não encontrada");
        }
    }
}
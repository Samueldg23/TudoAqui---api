package br.com.unisales.tudoaqui.dto;

import br.com.unisales.tudoaqui.model.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO {
    private Long id;
    private Long idRemetente;
    private Long idDestinatario;
    private String conteudo;
    private LocalDateTime dataEnvio;
    private Boolean lida;

    public MensagemDTO(Mensagem mensagem) {
        this.id = mensagem.getId();
        this.idRemetente = mensagem.getRemetente().getId();
        this.idDestinatario = mensagem.getDestinatario().getId();
        this.conteudo = mensagem.getConteudo();
        this.dataEnvio = mensagem.getDataEnvio();
        this.lida = mensagem.getLida();
    }
}
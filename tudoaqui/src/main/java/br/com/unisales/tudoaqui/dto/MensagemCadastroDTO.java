package br.com.unisales.tudoaqui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemCadastroDTO {
    private Long idRemetente;
    private Long idDestinatario;
    private String conteudo;
}
package br.com.unisales.tudoaqui.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoCadastroDTO {
    private Long idPedido;
    private Integer nota;
    private String comentario;
}
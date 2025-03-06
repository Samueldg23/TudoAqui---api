package br.com.unisales.tudoaqui.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoCadastroDTO {
    private Long idCliente;
    private Long idPrestador;
    private Long idServico;
    private LocalDateTime dataAgendada;
    private String descricao;
}
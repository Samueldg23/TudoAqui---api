package br.com.unisales.tudoaqui.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoCadastroDTO {
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
}
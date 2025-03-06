package br.com.unisales.tudoaqui.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "O nome do serviço é obrigatório")
    @Size(max = 100, message = "O nome do serviço deve ter no máximo 100 caracteres")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "A descrição do serviço é obrigatória")
    @Size(max = 500, message = "A descrição do serviço deve ter no máximo 500 caracteres")
    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false, length = 155)
    private CategoriaServico categoria;

    @NotNull(message = "O preço do serviço é obrigatório")
    @Positive(message = "O preço do serviço deve ser positivo")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @CreationTimestamp
    @Column(name = "dataCriacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "dataAtualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @ManyToMany(mappedBy = "servicos")
    private Set<Usuario> prestadores;

    public enum CategoriaServico {
        ELETRICISTA,
        ENCANADOR,
        PEDREIRO,
        PINTOR,
        MONTADOR_MOVEIS,
        TECNICO_REFRI,
        REPAROS_ELETRONICOS,
        JARDINAGEM,
        DEDETIZACAO,
        MECANICO,
        FUNILARIA_PINTURA,
        LAVAGEM_CARROS,
        CHAVEIRO,
        CABELEIREIRO,
        BARBEIRO,
        MANICURE_PEDICURE,
        TRANCISTA,
        MAQUIADOR,
        DESIGNER_SOBRANCELHAS,
        DEPILACAO,
        DIARISTA,
        PASSADEIRA,
        COZINHEIRO,
        BABA,
        CUIDADOR_IDOSOS,
        SUPORTE_TECNICO,
        INSTALACAO_REDES,
        DESENVOLVIMENTO_SITES
    }
}
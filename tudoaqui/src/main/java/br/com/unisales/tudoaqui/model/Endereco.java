package br.com.unisales.tudoaqui.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "rua", nullable = false, length = 80)
    private String rua;

    @Column(name = "numero", nullable = false, length = 5)
    private String numero;

    @Column(name = "bairro", nullable = false, length = 60)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 60)
    private String cidade;

    @Column(name = "estado", length = 40)
    private String estado;

    @Column(name = "cep", length = 10)
    private String cep;

    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
    private Usuario usuario;
}
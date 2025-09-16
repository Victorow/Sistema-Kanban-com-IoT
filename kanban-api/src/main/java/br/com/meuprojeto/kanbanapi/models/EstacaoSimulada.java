package br.com.meuprojeto.kanbanapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estacoes_simuladas")
@Getter
@Setter
public class EstacaoSimulada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_estacao", nullable = false, unique = true)
    private String nomeEstacao;

    private String descricao;
}
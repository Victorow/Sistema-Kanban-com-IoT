package br.com.meuprojeto.kanbanapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dispositivos")
@Getter
@Setter
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_key", nullable = false, unique = true)
    private String apiKey;

    @ManyToOne
    @JoinColumn(name = "estacao_id")
    private EstacaoSimulada estacao;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemSimulado item;

    @Column(name = "is_active")
    private boolean isActive = true;
}
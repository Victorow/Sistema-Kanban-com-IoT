
package br.com.meuprojeto.kanbanapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "tarefas_kanban")
@Getter
@Setter
public class TarefaKanban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status = "A_FAZER";

    @ManyToOne
    @JoinColumn(name = "dispositivo_id", nullable = false)
    private Dispositivo dispositivo;

    // Relacionamento com usuário será implementado depois
    // @ManyToOne
    // @JoinColumn(name = "usuario_id")
    // private Usuario usuario;

    @CreationTimestamp
    @Column(name = "timestamp_criacao", updatable = false)
    private Instant timestampCriacao;

    @UpdateTimestamp
    @Column(name = "timestamp_ultima_atualizacao")
    private Instant timestampUltimaAtualizacao;
}
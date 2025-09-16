package br.com.meuprojeto.kanbanapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_simulados")
@Getter
@Setter
public class ItemSimulado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_item", nullable = false)
    private String nomeItem;

    @Column(name = "sku_item", unique = true)
    private String skuItem;
}
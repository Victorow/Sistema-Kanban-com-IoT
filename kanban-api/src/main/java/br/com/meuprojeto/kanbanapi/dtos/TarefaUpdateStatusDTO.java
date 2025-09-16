package br.com.meuprojeto.kanbanapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaUpdateStatusDTO {
    private String novoStatus;
}
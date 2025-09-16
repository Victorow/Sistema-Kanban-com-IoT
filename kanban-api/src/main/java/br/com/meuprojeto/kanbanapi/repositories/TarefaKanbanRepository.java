package br.com.meuprojeto.kanbanapi.repositories;

import br.com.meuprojeto.kanbanapi.models.TarefaKanban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaKanbanRepository extends JpaRepository<TarefaKanban, Long> {
}
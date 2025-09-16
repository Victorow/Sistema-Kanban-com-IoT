package br.com.meuprojeto.kanbanapi.repositories;

import br.com.meuprojeto.kanbanapi.models.ItemSimulado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSimuladoRepository extends JpaRepository<ItemSimulado, Long> {
}
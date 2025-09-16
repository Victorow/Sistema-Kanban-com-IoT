package br.com.meuprojeto.kanbanapi.repositories;

import br.com.meuprojeto.kanbanapi.models.EstacaoSimulada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacaoSimuladaRepository extends JpaRepository<EstacaoSimulada, Long> {
}
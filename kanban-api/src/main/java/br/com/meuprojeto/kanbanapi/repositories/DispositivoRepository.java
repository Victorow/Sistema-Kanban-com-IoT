package br.com.meuprojeto.kanbanapi.repositories;

import br.com.meuprojeto.kanbanapi.models.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
}
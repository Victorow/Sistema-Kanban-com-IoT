package br.com.meuprojeto.kanbanapi.services;

import br.com.meuprojeto.kanbanapi.dtos.TarefaCreateDTO;
import br.com.meuprojeto.kanbanapi.models.Dispositivo;
import br.com.meuprojeto.kanbanapi.models.TarefaKanban;
import br.com.meuprojeto.kanbanapi.repositories.DispositivoRepository;
import br.com.meuprojeto.kanbanapi.repositories.TarefaKanbanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaKanbanService {

    @Autowired
    private TarefaKanbanRepository tarefaKanbanRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<TarefaKanban> listarTodas() {
        return tarefaKanbanRepository.findAll();
    }

    public TarefaKanban buscarPorId(Long id) {
        return tarefaKanbanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com o id: " + id));
    }

    public TarefaKanban criarNovaTarefa(TarefaCreateDTO dto) {
        Dispositivo dispositivo = dispositivoRepository.findById(dto.getDispositivoId())
                .orElseThrow(() -> new EntityNotFoundException("Dispositivo não encontrado com o id: " + dto.getDispositivoId()));

        TarefaKanban novaTarefa = new TarefaKanban();
        novaTarefa.setDispositivo(dispositivo);
        novaTarefa.setStatus("A_FAZER"); // Define o status inicial

        return tarefaKanbanRepository.save(novaTarefa);
    }

    public TarefaKanban atualizarStatus(Long id, String novoStatus) {
        TarefaKanban tarefa = buscarPorId(id);
        tarefa.setStatus(novoStatus);
        return tarefaKanbanRepository.save(tarefa);
    }
}
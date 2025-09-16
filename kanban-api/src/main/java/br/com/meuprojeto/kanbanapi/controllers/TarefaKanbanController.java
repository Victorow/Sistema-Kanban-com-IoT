package br.com.meuprojeto.kanbanapi.controllers;

import br.com.meuprojeto.kanbanapi.dtos.TarefaCreateDTO;
import br.com.meuprojeto.kanbanapi.dtos.TarefaUpdateStatusDTO;
import br.com.meuprojeto.kanbanapi.models.TarefaKanban;
import br.com.meuprojeto.kanbanapi.services.TarefaKanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaKanbanController {

    @Autowired
    private TarefaKanbanService tarefaKanbanService;

    @GetMapping
    public ResponseEntity<List<TarefaKanban>> listarTodasAsTarefas() {
        List<TarefaKanban> tarefas = tarefaKanbanService.listarTodas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaKanban> buscarTarefaPorId(@PathVariable Long id) {
        TarefaKanban tarefa = tarefaKanbanService.buscarPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<TarefaKanban> criarNovaTarefa(@RequestBody TarefaCreateDTO dto) {
        TarefaKanban novaTarefa = tarefaKanbanService.criarNovaTarefa(dto);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TarefaKanban> atualizarStatusDaTarefa(@PathVariable Long id, @RequestBody TarefaUpdateStatusDTO dto) {
        TarefaKanban tarefaAtualizada = tarefaKanbanService.atualizarStatus(id, dto.getNovoStatus());
        return ResponseEntity.ok(tarefaAtualizada);
    }
}
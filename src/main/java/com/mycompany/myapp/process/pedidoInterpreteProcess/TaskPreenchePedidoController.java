package com.mycompany.myapp.process.pedidoInterpreteProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-interprete-process/task-preenche-pedido")
public class TaskPreenchePedidoController {

    private final Logger log = LoggerFactory.getLogger(TaskPreenchePedidoController.class);

    private final TaskPreenchePedidoService taskPreenchePedidoService;

    public TaskPreenchePedidoController(TaskPreenchePedidoService taskPreenchePedidoService) {
        this.taskPreenchePedidoService = taskPreenchePedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskPreenchePedidoContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPreenchePedidoContextDTO taskPreenchePedidoContext = taskPreenchePedidoService.loadContext(id);
        return ResponseEntity.ok(taskPreenchePedidoContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskPreenchePedidoContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPreenchePedidoContextDTO taskPreenchePedidoContext = taskPreenchePedidoService.claim(id);
        return ResponseEntity.ok(taskPreenchePedidoContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskPreenchePedidoContextDTO taskPreenchePedidoContext) {
        log.debug(
            "REST request to complete PedidoInterpreteProcess.TaskPreenchePedido {}",
            taskPreenchePedidoContext.getTaskInstance().getId()
        );
        taskPreenchePedidoService.complete(taskPreenchePedidoContext);
        return ResponseEntity.noContent().build();
    }
}

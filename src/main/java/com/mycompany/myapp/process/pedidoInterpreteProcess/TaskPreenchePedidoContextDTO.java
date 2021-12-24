package com.mycompany.myapp.process.pedidoInterpreteProcess;

import com.mycompany.myapp.service.dto.PedidoInterpreteProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskPreenchePedidoContextDTO {

    private PedidoInterpreteProcessDTO pedidoInterpreteProcess;
    private TaskInstanceDTO taskInstance;

    public PedidoInterpreteProcessDTO getPedidoInterpreteProcess() {
        return pedidoInterpreteProcess;
    }

    public void setPedidoInterpreteProcess(PedidoInterpreteProcessDTO pedidoInterpreteProcess) {
        this.pedidoInterpreteProcess = pedidoInterpreteProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}

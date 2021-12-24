package com.mycompany.myapp.process.pedidoInterpreteProcess;

import com.mycompany.myapp.repository.PedidoInterpreteProcessRepository;
import com.mycompany.myapp.service.PedidoInterpreteService;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessDTO;
import com.mycompany.myapp.service.mapper.PedidoInterpreteProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskPreenchePedidoService {

    private final TaskInstanceService taskInstanceService;

    private final PedidoInterpreteService pedidoInterpreteService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedidoInterpreteProcessRepository pedidoInterpreteProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskPreenchePedidoMapper taskPreenchePedidoMapper;

    private final PedidoInterpreteProcessMapper pedidoInterpreteProcessMapper;

    public TaskPreenchePedidoService(
        TaskInstanceService taskInstanceService,
        PedidoInterpreteService pedidoInterpreteService,
        TaskInstanceRepository taskInstanceRepository,
        PedidoInterpreteProcessRepository pedidoInterpreteProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskPreenchePedidoMapper taskPreenchePedidoMapper,
        PedidoInterpreteProcessMapper pedidoInterpreteProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedidoInterpreteProcessRepository = pedidoInterpreteProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskPreenchePedidoMapper = taskPreenchePedidoMapper;
        this.pedidoInterpreteProcessMapper = pedidoInterpreteProcessMapper;
    }

    public TaskPreenchePedidoContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedidoInterpreteProcessDTO pedidoInterpreteProcess = pedidoInterpreteProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskPreenchePedidoMapper::toPedidoInterpreteProcessDTO)
            .orElseThrow();

        TaskPreenchePedidoContextDTO taskPreenchePedidoContext = new TaskPreenchePedidoContextDTO();
        taskPreenchePedidoContext.setTaskInstance(taskInstanceDTO);
        taskPreenchePedidoContext.setPedidoInterpreteProcess(pedidoInterpreteProcess);

        return taskPreenchePedidoContext;
    }

    public TaskPreenchePedidoContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskPreenchePedidoContextDTO taskPreenchePedidoContext) {
        PedidoInterpreteDTO pedidoInterpreteDTO = pedidoInterpreteService
            .findOne(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getId())
            .orElseThrow();
        pedidoInterpreteDTO.setNomeCliente(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getNomeCliente());
        pedidoInterpreteDTO.setTelefone(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getTelefone());
        pedidoInterpreteDTO.setTrajeto(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getTrajeto());
        pedidoInterpreteDTO.setDataInicio(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getDataInicio());
        pedidoInterpreteDTO.setDataFim(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getDataFim());
        pedidoInterpreteDTO.setHorarioInicio(
            taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getHorarioInicio()
        );
        pedidoInterpreteDTO.setTipoAuxilio(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getTipoAuxilio());
        pedidoInterpreteDTO.setValorMaximoEsperado(
            taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getValorMaximoEsperado()
        );
        pedidoInterpreteDTO.setValorCobradoFreelancer(
            taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getValorCobradoFreelancer()
        );
        pedidoInterpreteDTO.setValorCobradoEmpresa(
            taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getValorCobradoEmpresa()
        );
        pedidoInterpreteDTO.setDuracao(taskPreenchePedidoContext.getPedidoInterpreteProcess().getPedidoInterprete().getDuracao());
        pedidoInterpreteService.save(pedidoInterpreteDTO);
    }

    public void complete(TaskPreenchePedidoContextDTO taskPreenchePedidoContext) {
        save(taskPreenchePedidoContext);
        PedidoInterpreteProcessDTO pedidoInterpreteProcess = pedidoInterpreteProcessRepository
            .findByProcessInstanceId(taskPreenchePedidoContext.getPedidoInterpreteProcess().getProcessInstance().getId())
            .map(pedidoInterpreteProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskPreenchePedidoContext.getTaskInstance(), pedidoInterpreteProcess);
    }
}

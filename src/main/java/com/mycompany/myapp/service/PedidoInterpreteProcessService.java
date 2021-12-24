package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.PedidoInterpreteProcess;
import com.mycompany.myapp.repository.PedidoInterpreteProcessRepository;
import com.mycompany.myapp.repository.PedidoInterpreteRepository;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessDTO;
import com.mycompany.myapp.service.mapper.PedidoInterpreteProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PedidoInterpreteProcess}.
 */
@Service
@Transactional
public class PedidoInterpreteProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "PedidoInterpreteProcess";

    private final Logger log = LoggerFactory.getLogger(PedidoInterpreteProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final PedidoInterpreteRepository pedidoInterpreteRepository;

    private final PedidoInterpreteProcessRepository pedidoInterpreteProcessRepository;

    private final PedidoInterpreteProcessMapper pedidoInterpreteProcessMapper;

    public PedidoInterpreteProcessService(
        ProcessInstanceService processInstanceService,
        PedidoInterpreteRepository pedidoInterpreteRepository,
        PedidoInterpreteProcessRepository pedidoInterpreteProcessRepository,
        PedidoInterpreteProcessMapper pedidoInterpreteProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.pedidoInterpreteRepository = pedidoInterpreteRepository;
        this.pedidoInterpreteProcessRepository = pedidoInterpreteProcessRepository;
        this.pedidoInterpreteProcessMapper = pedidoInterpreteProcessMapper;
    }

    /**
     * Save a pedidoInterpreteProcess.
     *
     * @param pedidoInterpreteProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public PedidoInterpreteProcessDTO create(PedidoInterpreteProcessDTO pedidoInterpreteProcessDTO) {
        log.debug("Request to save PedidoInterpreteProcess : {}", pedidoInterpreteProcessDTO);

        PedidoInterpreteProcess pedidoInterpreteProcess = pedidoInterpreteProcessMapper.toEntity(pedidoInterpreteProcessDTO);

        //Saving the domainEntity
        pedidoInterpreteRepository.save(pedidoInterpreteProcess.getPedidoInterprete());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "PedidoInterprete#" + pedidoInterpreteProcess.getPedidoInterprete().getId(),
            pedidoInterpreteProcess
        );
        pedidoInterpreteProcess.setProcessInstance(processInstance);

        //Saving the process entity
        pedidoInterpreteProcess = pedidoInterpreteProcessRepository.save(pedidoInterpreteProcess);
        return pedidoInterpreteProcessMapper.toDto(pedidoInterpreteProcess);
    }

    /**
     * Get all the pedidoInterpreteProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PedidoInterpreteProcessDTO> findAll() {
        log.debug("Request to get all PedidoInterpreteProcesss");
        return pedidoInterpreteProcessRepository
            .findAll()
            .stream()
            .map(pedidoInterpreteProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one pedidoInterpreteProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedidoInterpreteProcessDTO> findOne(Long id) {
        log.debug("Request to get PedidoInterpreteProcess : {}", id);
        return pedidoInterpreteProcessRepository.findById(id).map(pedidoInterpreteProcessMapper::toDto);
    }

    /**
     * Get one pedidoInterpreteProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedidoInterpreteProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get PedidoInterpreteProcess by  processInstanceId: {}", processInstanceId);
        return pedidoInterpreteProcessRepository.findByProcessInstanceId(processInstanceId).map(pedidoInterpreteProcessMapper::toDto);
    }
}

package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.PedidoInterpreteProcess} entity.
 */
public class PedidoInterpreteProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private PedidoInterpreteDTO pedidoInterprete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public PedidoInterpreteDTO getPedidoInterprete() {
        return pedidoInterprete;
    }

    public void setPedidoInterprete(PedidoInterpreteDTO pedidoInterprete) {
        this.pedidoInterprete = pedidoInterprete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoInterpreteProcessDTO)) {
            return false;
        }

        PedidoInterpreteProcessDTO pedidoInterpreteProcessDTO = (PedidoInterpreteProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pedidoInterpreteProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoInterpreteProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", pedidoInterprete=" + getPedidoInterprete() +
            "}";
    }
}

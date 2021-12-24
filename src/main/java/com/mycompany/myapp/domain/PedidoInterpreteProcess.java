package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.akip.domain.ProcessInstance;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A PedidoInterpreteProcess.
 */
@Entity
@Table(name = "pedido_interprete_process")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PedidoInterpreteProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = { "processDefinition" }, allowSetters = true)
    private ProcessInstance processInstance;

    @ManyToOne
    private PedidoInterprete pedidoInterprete;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoInterpreteProcess id(Long id) {
        this.id = id;
        return this;
    }

    public ProcessInstance getProcessInstance() {
        return this.processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public PedidoInterpreteProcess processInstance(ProcessInstance processInstance) {
        this.setProcessInstance(processInstance);
        return this;
    }

    public PedidoInterprete getPedidoInterprete() {
        return this.pedidoInterprete;
    }

    public void setPedidoInterprete(PedidoInterprete pedidoInterprete) {
        this.pedidoInterprete = pedidoInterprete;
    }

    public PedidoInterpreteProcess PedidoInterprete(PedidoInterprete pedidoInterprete) {
        this.setPedidoInterprete(pedidoInterprete);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoInterpreteProcess)) {
            return false;
        }
        return id != null && id.equals(((PedidoInterpreteProcess) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoInterpreteProcess{" +
            "id=" + getId() +
            "}";
    }
}

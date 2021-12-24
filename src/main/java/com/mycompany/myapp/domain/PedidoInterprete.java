package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A PedidoInterprete.
 */
@Entity
@Table(name = "pedido_interprete")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PedidoInterprete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "trajeto")
    private String trajeto;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "horario_inicio")
    private String horarioInicio;

    @Column(name = "tipo_auxilio")
    private String tipoAuxilio;

    @Column(name = "valor_maximo_esperado")
    private String valorMaximoEsperado;

    @Column(name = "valor_cobrado_freelancer")
    private String valorCobradoFreelancer;

    @Column(name = "valor_cobrado_empresa")
    private String valorCobradoEmpresa;

    @Column(name = "duracao")
    private String duracao;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoInterprete id(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public PedidoInterprete nomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        return this;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public PedidoInterprete telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTrajeto() {
        return this.trajeto;
    }

    public PedidoInterprete trajeto(String trajeto) {
        this.trajeto = trajeto;
        return this;
    }

    public void setTrajeto(String trajeto) {
        this.trajeto = trajeto;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public PedidoInterprete dataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public PedidoInterprete dataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getHorarioInicio() {
        return this.horarioInicio;
    }

    public PedidoInterprete horarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
        return this;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getTipoAuxilio() {
        return this.tipoAuxilio;
    }

    public PedidoInterprete tipoAuxilio(String tipoAuxilio) {
        this.tipoAuxilio = tipoAuxilio;
        return this;
    }

    public void setTipoAuxilio(String tipoAuxilio) {
        this.tipoAuxilio = tipoAuxilio;
    }

    public String getValorMaximoEsperado() {
        return this.valorMaximoEsperado;
    }

    public PedidoInterprete valorMaximoEsperado(String valorMaximoEsperado) {
        this.valorMaximoEsperado = valorMaximoEsperado;
        return this;
    }

    public void setValorMaximoEsperado(String valorMaximoEsperado) {
        this.valorMaximoEsperado = valorMaximoEsperado;
    }

    public String getValorCobradoFreelancer() {
        return this.valorCobradoFreelancer;
    }

    public PedidoInterprete valorCobradoFreelancer(String valorCobradoFreelancer) {
        this.valorCobradoFreelancer = valorCobradoFreelancer;
        return this;
    }

    public void setValorCobradoFreelancer(String valorCobradoFreelancer) {
        this.valorCobradoFreelancer = valorCobradoFreelancer;
    }

    public String getValorCobradoEmpresa() {
        return this.valorCobradoEmpresa;
    }

    public PedidoInterprete valorCobradoEmpresa(String valorCobradoEmpresa) {
        this.valorCobradoEmpresa = valorCobradoEmpresa;
        return this;
    }

    public void setValorCobradoEmpresa(String valorCobradoEmpresa) {
        this.valorCobradoEmpresa = valorCobradoEmpresa;
    }

    public String getDuracao() {
        return this.duracao;
    }

    public PedidoInterprete duracao(String duracao) {
        this.duracao = duracao;
        return this;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoInterprete)) {
            return false;
        }
        return id != null && id.equals(((PedidoInterprete) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoInterprete{" +
            "id=" + getId() +
            ", nomeCliente='" + getNomeCliente() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", trajeto='" + getTrajeto() + "'" +
            ", dataInicio='" + getDataInicio() + "'" +
            ", dataFim='" + getDataFim() + "'" +
            ", horarioInicio='" + getHorarioInicio() + "'" +
            ", tipoAuxilio='" + getTipoAuxilio() + "'" +
            ", valorMaximoEsperado='" + getValorMaximoEsperado() + "'" +
            ", valorCobradoFreelancer='" + getValorCobradoFreelancer() + "'" +
            ", valorCobradoEmpresa='" + getValorCobradoEmpresa() + "'" +
            ", duracao='" + getDuracao() + "'" +
            "}";
    }
}

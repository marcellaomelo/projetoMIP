package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.PedidoInterprete} entity.
 */
public class PedidoInterpreteDTO implements Serializable {

    private Long id;

    private String nomeCliente;

    private String telefone;

    private String trajeto;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private String horarioInicio;

    private String tipoAuxilio;

    private String valorMaximoEsperado;

    private String valorCobradoFreelancer;

    private String valorCobradoEmpresa;

    private String duracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(String trajeto) {
        this.trajeto = trajeto;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getTipoAuxilio() {
        return tipoAuxilio;
    }

    public void setTipoAuxilio(String tipoAuxilio) {
        this.tipoAuxilio = tipoAuxilio;
    }

    public String getValorMaximoEsperado() {
        return valorMaximoEsperado;
    }

    public void setValorMaximoEsperado(String valorMaximoEsperado) {
        this.valorMaximoEsperado = valorMaximoEsperado;
    }

    public String getValorCobradoFreelancer() {
        return valorCobradoFreelancer;
    }

    public void setValorCobradoFreelancer(String valorCobradoFreelancer) {
        this.valorCobradoFreelancer = valorCobradoFreelancer;
    }

    public String getValorCobradoEmpresa() {
        return valorCobradoEmpresa;
    }

    public void setValorCobradoEmpresa(String valorCobradoEmpresa) {
        this.valorCobradoEmpresa = valorCobradoEmpresa;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoInterpreteDTO)) {
            return false;
        }

        PedidoInterpreteDTO pedidoInterpreteDTO = (PedidoInterpreteDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pedidoInterpreteDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoInterpreteDTO{" +
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

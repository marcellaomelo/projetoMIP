package com.mycompany.myapp.process.pedidoInterpreteProcess;

import com.mycompany.myapp.domain.PedidoInterprete;
import com.mycompany.myapp.domain.PedidoInterpreteProcess;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskPreenchePedidoMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    PedidoInterpreteProcessDTO toPedidoInterpreteProcessDTO(PedidoInterpreteProcess pedidoInterpreteProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeCliente", source = "nomeCliente")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "trajeto", source = "trajeto")
    @Mapping(target = "dataInicio", source = "dataInicio")
    @Mapping(target = "dataFim", source = "dataFim")
    @Mapping(target = "horarioInicio", source = "horarioInicio")
    @Mapping(target = "tipoAuxilio", source = "tipoAuxilio")
    @Mapping(target = "valorMaximoEsperado", source = "valorMaximoEsperado")
    @Mapping(target = "valorCobradoFreelancer", source = "valorCobradoFreelancer")
    @Mapping(target = "valorCobradoEmpresa", source = "valorCobradoEmpresa")
    @Mapping(target = "duracao", source = "duracao")
    PedidoInterpreteDTO toPedidoInterpreteDTO(PedidoInterprete pedidoInterprete);
}

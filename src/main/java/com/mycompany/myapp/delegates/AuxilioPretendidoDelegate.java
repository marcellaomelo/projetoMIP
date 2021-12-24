package com.mycompany.myapp.delegates;

import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AuxilioPretendidoDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PedidoInterpreteDTO tipoAuxilio = (PedidoInterpreteDTO) delegateExecution.getVariable("tipoAuxilio");
        String name = tipoAuxilio.getTipoAuxilio().toString();

        System.out.println("=================================================");
        System.out.println("=============== TIPO AUXÍLIO!!!======================");
        System.out.println("Tipo auxílio:" + name);
        System.out.println("=================================================");
    }
}

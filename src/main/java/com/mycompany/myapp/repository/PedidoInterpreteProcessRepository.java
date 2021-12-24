package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.PedidoInterpreteProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PedidoInterpreteProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PedidoInterpreteProcessRepository extends JpaRepository<PedidoInterpreteProcess, Long> {
    Optional<PedidoInterpreteProcess> findByProcessInstanceId(Long processInstanceId);
}

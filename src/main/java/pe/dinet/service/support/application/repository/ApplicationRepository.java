package pe.dinet.service.support.application.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import pe.dinet.service.support.application.model.Application;
import reactor.core.publisher.Mono;

public interface ApplicationRepository extends R2dbcRepository<Application, Long> {

    Mono<Application> findByCode(String code);

}

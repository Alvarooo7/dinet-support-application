package pe.dinet.service.support.application.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import pe.dinet.service.support.application.model.Contact;
import reactor.core.publisher.Flux;

public interface ContactRepository extends R2dbcRepository<Contact, Long> {
    Flux<Contact> findByApplicationCode(String code);
}

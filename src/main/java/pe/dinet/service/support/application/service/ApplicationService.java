package pe.dinet.service.support.application.service;

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.r2dbc.core.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import pe.dinet.service.support.application.dto.ApplicationRequest;
import pe.dinet.service.support.application.dto.ApplicationResponse;
import pe.dinet.service.support.application.dto.ContactResponse;
import pe.dinet.service.support.application.model.Application;
import pe.dinet.service.support.application.model.Contact;
import pe.dinet.service.support.application.repository.ApplicationRepository;
import pe.dinet.service.support.application.repository.ContactRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ContactRepository contactRepository;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final TransactionalOperator transactionalOperator;

    @Transactional
    public Mono<Application> saveApplication(ApplicationRequest request) {
        String uniqueCode = generateUniqueCode();

        Application application = Application.builder()
                .code(uniqueCode)
                .brand(request.getBrand())
                .requestType(request.getRequestType())
                .submissionDate(request.getSubmissionDate())
                .build();

        return applicationRepository.save(application)
                .flatMap(savedApp ->
                     Flux.fromIterable(request.getContacts())
                            .map(contactReq -> Contact.builder()
                                    .contactName(contactReq.getContactName())
                                    .contactNumber(contactReq.getContactNumber())
                                    .applicationCode(savedApp.getCode())
                                    .build()
                            )
                            .collectList()
                            .flatMapMany(contactRepository::saveAll)
                            .then(Mono.just(savedApp))
                )
                .as(transactionalOperator::transactional);
    }

    private String generateUniqueCode() {
        return "APP-DINET" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }

    public Flux<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Mono<ApplicationResponse> getApplicationByCode(String code) {
        return applicationRepository.findByCode(code)
                .flatMap(application -> contactRepository.findByApplicationCode(code) // 🔹 Obtener los contactos
                        .map(contact -> ContactResponse.builder()
                                .contactName(contact.getContactName())
                                .contactNumber(contact.getContactNumber())
                                .build())
                        .collectList()
                        .map(contacts -> ApplicationResponse.builder()
                                .code(application.getCode())
                                .brand(application.getBrand())
                                .requestType(application.getRequestType())
                                .submissionDate(application.getSubmissionDate())
                                .contacts(contacts)
                                .build()));
    }

    public Flux<Contact> getContactsByApplicationCode(String code) {
        return contactRepository.findByApplicationCode(code);
    }

}

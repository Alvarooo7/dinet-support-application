package pe.dinet.service.support.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.dinet.service.support.application.dto.ApplicationRequest;
import pe.dinet.service.support.application.dto.ApplicationResponse;
import pe.dinet.service.support.application.model.Application;
import pe.dinet.service.support.application.model.Contact;
import pe.dinet.service.support.application.service.ApplicationService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/applications")
@Tag(name = "Application API", description = "Endpoints for managing applications and their contacts")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @Operation(summary = "Create a new application", description = "Saves a new application along with its contacts")
    @PostMapping
    public Mono<Application> createApplication(@Valid @RequestBody ApplicationRequest request) {
        return applicationService.saveApplication(request);
    }

    @Operation(summary = "Get all applications", description = "Retrieves a list of all stored applications")
    @GetMapping
    public Flux<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @Operation(summary = "Get application by code", description = "Fetches an application using its unique code")
    @GetMapping("/{code}")
    public Mono<ApplicationResponse> getAllApplicationByCode(@PathVariable String code) {
        return applicationService.getApplicationByCode(code);
    }

    @Operation(summary = "Get contacts by application code", description = "Retrieves contacts associated with a specific application")
    @GetMapping("/{code}/contacts")
    public Flux<Contact> getContactsByApplicationCode(@PathVariable String code) {
        return applicationService.getContactsByApplicationCode(code);
    }
}
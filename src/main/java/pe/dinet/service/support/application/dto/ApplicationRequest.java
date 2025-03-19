package pe.dinet.service.support.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request body for creating an application")
public class ApplicationRequest {


    @Schema(description = "Brand name associated with the application", example = "Nike")
    @NotBlank(message = "Brand is required")
    private String brand;

    @Schema(description = "Type of request", example = "New Subscription")
    @NotBlank(message = "Request type is required")
    private String requestType;

    @Schema(description = "Submission date of the application", example = "2025-03-18")
    @NotNull(message = "Submission date is required")
    private LocalDate submissionDate;

    @Schema(description = "List of additional contacts")
    @Size(min = 1, message = "At least one contact is required")
    private List<@Valid ContactRequest> contacts;
}

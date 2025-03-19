package pe.dinet.service.support.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Details of a contact associated with an application")
public class ContactRequest {


    @Schema(description = "Name of the contact person", example = "Jane Doe")
    @NotBlank(message = "Contact name is required")
    private String contactName;

    @Schema(description = "Contact phone number", example = "+19876543210")
    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]+$", message = "Contact number must contain only digits")
    private String contactNumber;
}


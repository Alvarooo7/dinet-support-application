package pe.dinet.service.support.application.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ApplicationResponse {
    private String code;
    private String brand;
    private String requestType;
    private LocalDate submissionDate;
    private String contactNumber;
    private String contactName;
    private List<ContactResponse> contacts;
}

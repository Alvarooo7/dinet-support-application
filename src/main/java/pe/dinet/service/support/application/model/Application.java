package pe.dinet.service.support.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "application")
@ToString
public class Application {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String brand;

    @Column(name = "request_type")
    private String requestType;

    @Column(name = "submission_date")
    private LocalDate submissionDate;


}


package com.patika.dto.requests.publisher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePublisherRequest {
    private int publisherId;
    private String publisherName;
    private int publisherEstablishmentYear;
    private String publisherAddress;
}

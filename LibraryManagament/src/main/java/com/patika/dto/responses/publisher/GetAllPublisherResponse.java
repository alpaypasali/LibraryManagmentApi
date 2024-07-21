package com.patika.dto.responses.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPublisherResponse {
    private  int publisherId;
    private String publisherName;
    private int publisherEstablishmentYear;
    private String publisherAddress;
}

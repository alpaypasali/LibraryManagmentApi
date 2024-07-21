package com.patika.dto.requests.publisher;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePublisherRequest {


    private String publisherName;

    private int publisherEstablishmentYear;

    private String publisherAddress;
}

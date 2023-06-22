package org.wildfly.myzkapp.shared.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String index;

    private String city;

    private String street;

    private int houseNumber;

    private String apartmentNumber;
}

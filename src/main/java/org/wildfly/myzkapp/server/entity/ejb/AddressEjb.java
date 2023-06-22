package org.wildfly.myzkapp.server.entity.ejb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEjb {
    private Integer index;

    private String city;

    private String street;

    private int houseNumber;

    private Integer apartmentNumber;
}

package org.wildfly.myzkapp.shared.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wildfly.myzkapp.shared.dto.address.AddressResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchCompanyResponse {
    private String name;

    private AddressResponse address;

    private String companyHeadName;
}
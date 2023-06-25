package org.wildfly.myzkapp.server.entity.ejb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wildfly.myzkapp.server.entity.pojo.Company;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchCompanyEjb {
    private String name;

    private AddressEjb address;

    private Company companyHead;
}
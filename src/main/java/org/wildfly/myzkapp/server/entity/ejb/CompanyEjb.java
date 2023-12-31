package org.wildfly.myzkapp.server.entity.ejb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wildfly.myzkapp.server.entity.pojo.BranchCompany;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEjb {
    private String name;

    private String legalForm;

    private AddressEjb address;

    private Set<BranchCompany> branchCompanies = new HashSet<>(0);
}

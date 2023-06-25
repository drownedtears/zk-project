package org.wildfly.myzkapp.server.entity.helper;

import org.wildfly.myzkapp.server.dao.CompanyDao;
import org.wildfly.myzkapp.server.entity.ejb.AddressEjb;
import org.wildfly.myzkapp.server.entity.ejb.CompanyEjb;
import org.wildfly.myzkapp.server.entity.pojo.Address;
import org.wildfly.myzkapp.server.entity.pojo.Company;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CompanyHelper {
    @Inject
    private CompanyDao companyDao;

    public List<CompanyEjb> getAllCompanies() {
        return companyDao.getAllEntities().stream()
                .map(this::toCompanyEjb)
                .collect(Collectors.toList());
    }

    private CompanyEjb toCompanyEjb(Company company) {
        CompanyEjb companyEjb = new CompanyEjb();
        companyEjb.setName(company.getName());
        companyEjb.setAddress(toAddressEjb(company.getAddress()));
        companyEjb.setLegalForm(company.getLegalForm());
        companyEjb.getBranchCompanies().addAll(company.getBranchCompanies());
        return companyEjb;
    }

    private AddressEjb toAddressEjb(Address address) {
        AddressEjb addressEjb = new AddressEjb();
        addressEjb.setIndex(address.getIndex());
        addressEjb.setCity(address.getCity());
        addressEjb.setStreet(address.getStreet());
        addressEjb.setHouseNumber(address.getHouseNumber());
        addressEjb.setApartmentNumber(address.getApartmentNumber());
        return addressEjb;
    }
}

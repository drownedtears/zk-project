package org.wildfly.myzkapp.server.entity.helper;

import org.wildfly.myzkapp.server.dao.CompanyHeadDao;
import org.wildfly.myzkapp.server.entity.ejb.AddressEjb;
import org.wildfly.myzkapp.server.entity.ejb.CompanyHeadEjb;
import org.wildfly.myzkapp.server.entity.pojo.Address;
import org.wildfly.myzkapp.server.entity.pojo.CompanyHead;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CompanyHeadHelper {
    @Inject
    private CompanyHeadDao companyHeadDao;

    public List<CompanyHeadEjb> getAllCompanyHeads() {
        return companyHeadDao.getAllEntities().stream()
                .map(this::toCompanyHeadEjb)
                .collect(Collectors.toList());
    }

    private CompanyHeadEjb toCompanyHeadEjb(CompanyHead companyHead) {
        CompanyHeadEjb companyHeadEjb = new CompanyHeadEjb();
        companyHeadEjb.setName(companyHead.getName());
        companyHeadEjb.setAddress(toAddressEjb(companyHead.getAddress()));
        companyHeadEjb.setLegalForm(companyHead.getLegalForm());
        companyHeadEjb.getCompanyBranches().addAll(companyHead.getCompanyBranches());
        return companyHeadEjb;
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

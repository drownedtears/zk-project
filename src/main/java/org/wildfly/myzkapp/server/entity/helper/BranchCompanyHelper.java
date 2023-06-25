package org.wildfly.myzkapp.server.entity.helper;

import org.wildfly.myzkapp.server.dao.BranchCompanyDao;
import org.wildfly.myzkapp.server.entity.ejb.AddressEjb;
import org.wildfly.myzkapp.server.entity.ejb.BranchCompanyEjb;
import org.wildfly.myzkapp.server.entity.pojo.Address;
import org.wildfly.myzkapp.server.entity.pojo.BranchCompany;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class BranchCompanyHelper {
    @Inject
    private BranchCompanyDao branchCompanyDao;

    public List<BranchCompanyEjb> getAllBranchCompanies() {
        return branchCompanyDao.getAllEntities().stream()
                .map(this::toBranchCompanyEjb)
                .collect(Collectors.toList());
    }

    private BranchCompanyEjb toBranchCompanyEjb(BranchCompany branchCompany) {
        BranchCompanyEjb branchCompanyEjb = new BranchCompanyEjb();
        branchCompanyEjb.setName(branchCompany.getName());
        branchCompanyEjb.setAddress(toAddressEjb(branchCompany.getAddress()));
        branchCompanyEjb.setCompanyHead(branchCompany.getCompanyHead());
        return branchCompanyEjb;
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

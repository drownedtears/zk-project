package org.wildfly.myzkapp.shared.impl;

import lombok.val;
import org.wildfly.myzkapp.server.entity.ejb.AddressEjb;
import org.wildfly.myzkapp.server.entity.ejb.BranchCompanyEjb;
import org.wildfly.myzkapp.server.entity.helper.BranchCompanyHelper;
import org.wildfly.myzkapp.shared.dto.address.AddressResponse;
import org.wildfly.myzkapp.shared.dto.company.BranchCompanyResponse;
import org.wildfly.myzkapp.shared.service.IBranchCompanyService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class BranchCompanyServiceImpl implements IBranchCompanyService {
    @Inject
    private BranchCompanyHelper branchCompanyHelper;

    @Override
    public List<BranchCompanyResponse> getAllBranchCompanies() {
        return branchCompanyHelper.getAllBranchCompanies().stream()
                .map(this::toBranchCompanyResponse)
                .collect(Collectors.toList());
    }

    private BranchCompanyResponse toBranchCompanyResponse(BranchCompanyEjb branchCompanyEjb) {
        BranchCompanyResponse branchCompanyResponse = new BranchCompanyResponse();
        branchCompanyResponse.setName(branchCompanyEjb.getName());
        branchCompanyResponse.setAddress(toAddressResponse(branchCompanyEjb.getAddress()));
        branchCompanyResponse.setCompanyHeadName(branchCompanyEjb.getCompanyHead().getName());
        return branchCompanyResponse;
    }

    private AddressResponse toAddressResponse(AddressEjb addressEjb) {
        AddressResponse addressResponse = new AddressResponse();
        val index = addressEjb.getIndex();
        addressResponse.setIndex(index == null ? "" : index.toString());
        addressResponse.setCity(addressEjb.getCity());
        addressResponse.setStreet(addressEjb.getStreet());
        addressResponse.setHouseNumber(addressEjb.getHouseNumber());
        val apartmentNumber = addressEjb.getApartmentNumber();
        addressResponse.setApartmentNumber(apartmentNumber == null ? "" : apartmentNumber.toString());
        return addressResponse;
    }
}

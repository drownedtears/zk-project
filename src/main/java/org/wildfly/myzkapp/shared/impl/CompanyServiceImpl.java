package org.wildfly.myzkapp.shared.impl;

import lombok.val;
import org.wildfly.myzkapp.server.entity.ejb.AddressEjb;
import org.wildfly.myzkapp.server.entity.ejb.CompanyEjb;
import org.wildfly.myzkapp.server.entity.helper.CompanyHelper;
import org.wildfly.myzkapp.shared.dto.address.AddressResponse;
import org.wildfly.myzkapp.shared.dto.company.CompanyResponse;
import org.wildfly.myzkapp.shared.service.ICompanyService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class CompanyServiceImpl implements ICompanyService {

    @Inject
    private CompanyHelper companyHelper;

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyHelper.getAllCompanies().stream()
                .map(this::toCompanyResponse)
                .collect(Collectors.toList());
    }

    private CompanyResponse toCompanyResponse(CompanyEjb companyEjb) {
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setName(companyEjb.getName());
        companyResponse.setAddress(toAddressResponse(companyEjb.getAddress()));
        val legalForm = companyResponse.getLegalForm();
        companyResponse.setLegalForm(legalForm == null ? "" : legalForm);
        return companyResponse;
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

package org.wildfly.myzkapp.shared.impl;

import lombok.val;
import org.wildfly.myzkapp.server.entity.ejb.AddressEjb;
import org.wildfly.myzkapp.server.entity.ejb.CompanyHeadEjb;
import org.wildfly.myzkapp.server.entity.helper.CompanyHeadHelper;
import org.wildfly.myzkapp.shared.dto.address.AddressResponse;
import org.wildfly.myzkapp.shared.dto.companyhead.CompanyHeadResponse;
import org.wildfly.myzkapp.shared.service.ICompanyHeadService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class CompanyHeadServiceImpl implements ICompanyHeadService {

    @Inject
    private CompanyHeadHelper companyHeadHelper;

    @Override
    public List<CompanyHeadResponse> getAllCompanyHeads() {
        return companyHeadHelper.getAllCompanyHeads().stream()
                .map(this::toCompanyHeadResponse)
                .collect(Collectors.toList());
    }

    private CompanyHeadResponse toCompanyHeadResponse(CompanyHeadEjb companyHeadEjb) {
        CompanyHeadResponse companyHeadResponse = new CompanyHeadResponse();
        companyHeadResponse.setName(companyHeadEjb.getName());
        companyHeadResponse.setAddress(toAddressResponse(companyHeadEjb.getAddress()));
        val legalForm = companyHeadResponse.getLegalForm();
        companyHeadResponse.setLegalForm(legalForm == null ? "" : legalForm);
        return companyHeadResponse;
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

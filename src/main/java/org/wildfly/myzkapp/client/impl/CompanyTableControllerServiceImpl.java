package org.wildfly.myzkapp.client.impl;

import org.wildfly.myzkapp.client.service.ICompanyTableControllerService;
import org.wildfly.myzkapp.shared.dto.company.CompanyResponse;
import org.wildfly.myzkapp.shared.service.ICompanyService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class CompanyTableControllerServiceImpl implements ICompanyTableControllerService {

    @Inject
    private ICompanyService companyService;

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}

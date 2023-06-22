package org.wildfly.myzkapp.client.impl;

import org.wildfly.myzkapp.client.service.ICompanyTableControllerService;
import org.wildfly.myzkapp.shared.dto.companyhead.CompanyHeadResponse;
import org.wildfly.myzkapp.shared.impl.CompanyHeadServiceImpl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class CompanyTableControllerServiceImpl implements ICompanyTableControllerService {

    @Inject
    private CompanyHeadServiceImpl companyHeadService;

    @Override
    public List<CompanyHeadResponse> getAllCompanyHeads() {
        return companyHeadService.getAllCompanyHeads();
    }
}

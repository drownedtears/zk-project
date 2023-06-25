package org.wildfly.myzkapp.client.impl;

import org.wildfly.myzkapp.client.service.IBranchCompanyTableControllerService;
import org.wildfly.myzkapp.shared.dto.company.BranchCompanyResponse;
import org.wildfly.myzkapp.shared.service.IBranchCompanyService;

import javax.inject.Inject;
import java.util.List;

public class BranchCompanyTableControllerServiceImpl implements IBranchCompanyTableControllerService {
    @Inject
    private IBranchCompanyService branchCompanyService;

    @Override
    public List<BranchCompanyResponse> getAllBranchCompanies() {
        return branchCompanyService.getAllBranchCompanies();
    }
}

package org.wildfly.myzkapp.client.service;

import org.wildfly.myzkapp.shared.dto.company.BranchCompanyResponse;

import java.util.List;

public interface IBranchCompanyTableControllerService {
    List<BranchCompanyResponse> getAllBranchCompanies();
}

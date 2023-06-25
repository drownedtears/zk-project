package org.wildfly.myzkapp.shared.service;

import org.wildfly.myzkapp.shared.dto.company.BranchCompanyResponse;

import java.util.List;

public interface IBranchCompanyService {
    List<BranchCompanyResponse> getAllBranchCompanies();
}

package org.wildfly.myzkapp.client.service;

import org.wildfly.myzkapp.shared.dto.company.CompanyResponse;

import java.util.List;

public interface ICompanyTableControllerService {
    List<CompanyResponse> getAllCompanies();
}

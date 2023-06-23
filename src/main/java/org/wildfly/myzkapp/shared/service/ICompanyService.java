package org.wildfly.myzkapp.shared.service;

import org.wildfly.myzkapp.shared.dto.company.CompanyResponse;

import java.util.List;

public interface ICompanyService {
    List<CompanyResponse> getAllCompanies();
}


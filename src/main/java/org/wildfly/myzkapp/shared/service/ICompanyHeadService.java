package org.wildfly.myzkapp.shared.service;

import org.wildfly.myzkapp.shared.dto.companyhead.CompanyHeadResponse;

import java.util.List;

public interface ICompanyHeadService {
    List<CompanyHeadResponse> getAllCompanyHeads();
}

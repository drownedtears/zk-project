package org.wildfly.myzkapp.client.service;

import org.wildfly.myzkapp.shared.dto.companyhead.CompanyHeadResponse;

import java.util.List;

public interface ICompanyTableControllerService {
    List<CompanyHeadResponse> getAllCompanyHeads();
}

package org.wildfly.myzkapp.client.viewmodel.company;

import org.wildfly.myzkapp.client.service.ICompanyTableControllerService;
import org.wildfly.myzkapp.shared.dto.company.CompanyResponse;
import org.zkoss.zul.ListModelList;

import javax.inject.Inject;
import java.util.List;

public class CompanyViewModel {
    @Inject
    private ICompanyTableControllerService companyTableControllerService;

    private final ListModelList<CompanyResponse> companies = createCompanyHeadsModelList();

    public ListModelList<CompanyResponse> getListModel() {
        return companies;
    }

    private ListModelList<CompanyResponse> createCompanyHeadsModelList() {
        ListModelList<CompanyResponse> companies = new ListModelList<>();
        companies.addAll(loadAllCompanies());
        return companies;
    }

    private List<CompanyResponse> loadAllCompanies() {
        return companyTableControllerService.getAllCompanies();
    }
}

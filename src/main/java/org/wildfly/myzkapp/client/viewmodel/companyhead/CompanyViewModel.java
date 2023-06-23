package org.wildfly.myzkapp.client.viewmodel.companyhead;

import org.wildfly.myzkapp.client.service.ICompanyTableControllerService;
import org.wildfly.myzkapp.shared.dto.company.CompanyResponse;
import org.zkoss.zul.ListModelList;

import javax.inject.Inject;
import java.util.List;

public class CompanyViewModel {
    @Inject
    private ICompanyTableControllerService companyTableControllerService;

    private final ListModelList<CompanyResponse> companies;
    public CompanyViewModel() {
        companies = createCompanyHeadsModelList();
    }

    public ListModelList<CompanyResponse> getListModel() {
        return companies;
    }

    private ListModelList<CompanyResponse> createCompanyHeadsModelList() {
        ListModelList<CompanyResponse> companyHeads = new ListModelList<>();
        companyHeads.addAll(loadAllCompanyHeads());
        return companyHeads;
    }

    private List<CompanyResponse> loadAllCompanyHeads() {
        return companyTableControllerService.getAllCompanies();
    }
}

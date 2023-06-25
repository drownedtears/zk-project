package org.wildfly.myzkapp.client.viewmodel.company;

import org.wildfly.myzkapp.client.service.IBranchCompanyTableControllerService;
import org.wildfly.myzkapp.shared.dto.company.BranchCompanyResponse;
import org.zkoss.zul.ListModelList;

import javax.inject.Inject;
import java.util.List;

public class BranchCompanyViewModel {
    @Inject
    private IBranchCompanyTableControllerService branchCompanyTableControllerService;

    private final ListModelList<BranchCompanyResponse> branchCompanies = createBranchCompaniesModelList();

    public ListModelList<BranchCompanyResponse> getListModel() { return branchCompanies; }

    private ListModelList<BranchCompanyResponse> createBranchCompaniesModelList() {
        ListModelList<BranchCompanyResponse> companies = new ListModelList<>();
        companies.addAll(loadAllBranchCompanies());
        return companies;
    }

    private List<BranchCompanyResponse> loadAllBranchCompanies() {
        return branchCompanyTableControllerService.getAllBranchCompanies();
    }
}

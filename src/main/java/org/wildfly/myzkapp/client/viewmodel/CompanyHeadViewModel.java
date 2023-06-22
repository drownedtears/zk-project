package org.wildfly.myzkapp.client.viewmodel;

import org.wildfly.myzkapp.shared.dto.address.AddressResponse;
import org.wildfly.myzkapp.shared.dto.companyhead.CompanyHeadResponse;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class CompanyHeadViewModel {
    //@Inject
    //private ICompanyTableControllerService companyTableControllerService;

    private final ListModelList<CompanyHeadResponse> companyHeads;

    public CompanyHeadViewModel() {
        companyHeads = createCompanyHeadsModelList();
    }

    public ListModelList<CompanyHeadResponse> getListModel() {
        return companyHeads;
    }

    private ListModelList<CompanyHeadResponse> createCompanyHeadsModelList() {
        ListModelList<CompanyHeadResponse> companyHeads = new ListModelList<>();
        //companyHeads.addAll(loadAllCompanyHeads());
        CompanyHeadResponse companyHeadResponse = new CompanyHeadResponse("test", new AddressResponse(), "OOO");
        companyHeads.add(companyHeadResponse);
        return companyHeads;
    }

    private List<CompanyHeadResponse> loadAllCompanyHeads() {
        return null; //companyTableControllerService.getAllCompanyHeads();
    }
}

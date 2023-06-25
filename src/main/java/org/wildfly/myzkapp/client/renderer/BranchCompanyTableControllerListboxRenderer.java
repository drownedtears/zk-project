package org.wildfly.myzkapp.client.renderer;

import org.wildfly.myzkapp.shared.dto.company.BranchCompanyResponse;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class BranchCompanyTableControllerListboxRenderer implements ListitemRenderer<BranchCompanyResponse> {
    @Override
    public void render(Listitem item, BranchCompanyResponse branchCompanyResponse, int index) {
        Listcell nameCell = new Listcell(branchCompanyResponse.getName());
        Listcell companyHeadNameCell = new Listcell(branchCompanyResponse.getCompanyHeadName());
        item.appendChild(nameCell);
        item.appendChild(companyHeadNameCell);
    }
}

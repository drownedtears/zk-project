package org.wildfly.myzkapp.client.controller.table;

import lombok.val;
import org.wildfly.myzkapp.client.renderer.BranchCompanyTableControllerListboxRenderer;
import org.wildfly.myzkapp.client.viewmodel.company.BranchCompanyViewModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class BranchCompanyTableController extends SelectorComposer<Component> {

    @Wire
    private Label branchCompanyTableLabel;

    @Wire
    private Button toHomeButton;

    @Wire
    private Listbox branchCompanyTableListbox;

    private final BranchCompanyViewModel branchCompanyViewModel = new BranchCompanyViewModel();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        createBranchCompanyListboxContent();

        setBranchCompanyTableLabelValue();
        setToHomeButtonLabel();
    }

    @Listen("onClick = #toHomeButton")
    public void onToHomeButtonClick() {
        Executions.sendRedirect("/home.zul");
    }

    private void setToHomeButtonLabel() {
        toHomeButton.setLabel("назад");
    }

    private void setBranchCompanyTableLabelValue() {
        val branchCompanies = branchCompanyViewModel.getListModel();
        if (branchCompanies.isEmpty()) {
            branchCompanyTableLabel.setValue("К сожалению не найдено ни одной компании :(");
        } else {
            branchCompanyTableLabel.setValue("Вот таблица со всем компаниям :)");
        }
    }

    private void createBranchCompanyListboxContent() {
        branchCompanyTableListbox.setModel(branchCompanyViewModel.getListModel());

        Listhead listhead = new Listhead();
        branchCompanyTableListbox.appendChild(listhead);

        Listheader nameHeader = new Listheader("Название");
        Listheader companyHeadNameHeader = new Listheader("Основная компания");
        listhead.appendChild(nameHeader);
        listhead.appendChild(companyHeadNameHeader);

        branchCompanyTableListbox.setItemRenderer(new BranchCompanyTableControllerListboxRenderer());
    }
}

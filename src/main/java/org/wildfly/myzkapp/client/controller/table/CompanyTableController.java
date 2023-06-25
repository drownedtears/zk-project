package org.wildfly.myzkapp.client.controller.table;

import lombok.val;
import org.wildfly.myzkapp.client.viewmodel.company.CompanyViewModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;


public class CompanyTableController extends SelectorComposer<Component> {

    @Wire
    private Label companyTableLabel;

    @Wire
    private Button toHomeButton;

    private final CompanyViewModel companyViewModel = new CompanyViewModel();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        setCompanyTableLabelValue();
        setToHomeButtonLabel();
    }

    @Listen("onClick = #toHomeButton")
    public void onToHomeButtonClick() {
        Executions.sendRedirect("/home.zul");
    }

    private void setToHomeButtonLabel() {
        toHomeButton.setLabel("назад");
    }

    private void setCompanyTableLabelValue() {
        val companies = companyViewModel.getListModel();
        if (companies.isEmpty()) {
            companyTableLabel.setValue("К сожалению не найдено ни одной компании :(");
        } else {
            companyTableLabel.setValue("Вот таблица со всем компаниям :)");
        }
    }
}

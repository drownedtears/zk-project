package org.wildfly.myzkapp.client.controller.table;

import lombok.val;
import org.wildfly.myzkapp.client.viewmodel.companyhead.CompanyViewModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;


public class CompanyTableController extends SelectorComposer<Component> {

    @Wire
    private Label companyTableLabel;

    @Wire
    private Listbox companyTableListbox;

    private final CompanyViewModel companyViewModel = new CompanyViewModel();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        val companyHeads = companyViewModel.getListModel();
        if (companyHeads.isEmpty()) {
            companyTableLabel.setValue("К сожалению не найдено ни одной компании :(");
        } else {
            companyTableLabel.setValue("Вот таблица со всем компаниям :)");
            companyTableListbox.setModel(companyHeads);
        }
    }
}

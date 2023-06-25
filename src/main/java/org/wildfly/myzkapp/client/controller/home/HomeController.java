package org.wildfly.myzkapp.client.controller.home;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;

public class HomeController extends SelectorComposer<Component> {

    @Wire
    private Label welcomeLabel;

    @Wire
    private Button toCompanyTableButton;

    @Wire
    private Button toBranchCompanyTableButton;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        setWelcomeLabelValue();
        setToCompanyTableButtonLabel();
        setToBranchCompanyTableButtonLabel();
    }

    @Listen("onClick = #toCompanyTableButton")
    public void onToCompanyTableButtonClick() {
        Executions.sendRedirect("/company-table.zul");
    }

    @Listen("onClick = #toBranchCompanyTableButton")
    public void onToBranchCompanyTableButtonClick() {
        Executions.sendRedirect("/branch-company-table.zul");
    }

    private void setWelcomeLabelValue() {
        welcomeLabel.setValue("привет");
    }

    private void setToCompanyTableButtonLabel() {
        toCompanyTableButton.setLabel("тыкай тут связываение через .zul файл");
    }

    private void setToBranchCompanyTableButtonLabel() {
        toBranchCompanyTableButton.setLabel("а тут через джава класс");
    }
}

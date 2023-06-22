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
    private Button toTableButton;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        welcomeLabel.setValue("привет");
        toTableButton.setLabel("тыкай");
    }

    @Listen("onClick = #toTableButton")
    public void onClick() {
        Executions.sendRedirect("/company-table.zul");
    }
}

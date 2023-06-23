package org.wildfly.myzkapp.client.viewmodel;

import org.wildfly.myzkapp.client.viewmodel.companyhead.CompanyViewModel;
import org.zkoss.xel.VariableResolver;
import org.zkoss.xel.XelException;

public class ViewModelResolver implements VariableResolver {

    @Override
    public Object resolveVariable(String name) throws XelException {
        if ("companyvm".equals(name)) {
            return new CompanyViewModel();
        } else {
            return null;
        }
    }
}
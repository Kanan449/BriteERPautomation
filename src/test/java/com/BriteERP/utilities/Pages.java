package com.BriteERP.utilities;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private CRMPage crmpage;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CRMPage crmpage() {
        if (crmpage == null) {
            crmpage = new CRMPage();
        }
        return crmpage;
    }
}


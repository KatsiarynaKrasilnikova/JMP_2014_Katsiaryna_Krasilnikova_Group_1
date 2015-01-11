package com.epam.cdp.ejb.bean;

import com.epam.cdp.ejb.service.IAccountService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Ilya_Kukushkin on 12/9/2014
 */
@ManagedBean(name = "accountBean")
@SessionScoped
public class AccountBean {

    @EJB
    private IAccountService accountService;
}

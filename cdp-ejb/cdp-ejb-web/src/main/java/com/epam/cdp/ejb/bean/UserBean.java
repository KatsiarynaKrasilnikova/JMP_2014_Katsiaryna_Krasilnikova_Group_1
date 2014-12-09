package com.epam.cdp.ejb.bean;

import com.epam.cdp.ejb.bean.util.MessageUtil;
import com.epam.cdp.ejb.model.User;
import com.epam.cdp.ejb.service.IUserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/8/2014
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    @EJB
    private IUserService userService;

    private List<User> users = new ArrayList<User>();
    private User user = new User();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void findAll() {
        this.users = userService.findAll();
    }

    public void find() {
        this.user = userService.find(this.user.getId());
    }

    public void clear() {
        this.user = new User();
    }

    public String delete(User user) {
        userService.delete(user);
        MessageUtil.addSuccessMessage("User was successfully deleted.");
        return "index";
    }

    public String create() {
        userService.save(this.user);
        MessageUtil.addSuccessMessage("User was successfully created.");

        return "index";
    }

    public String update() {
        userService.update(this.user);
        MessageUtil.addSuccessMessage("User with id " + this.user.getId() + " was successfully updated.");

        return "view";
    }
}

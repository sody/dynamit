package com.example.dynamit.pages;

import com.example.dynamit.components.Modal;
import com.example.dynamit.components.ModalForm;
import com.example.dynamit.services.User;
import com.example.dynamit.services.UserService;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

/**
 * @author Ivan Khalopik
 */
public class Index {

    @InjectComponent
    private ModalForm formModal;

    @Inject
    private UserService userService;

    @Property
    private List<User> users;

    @Property
    private User user;

    @OnEvent(EventConstants.ACTIVATE)
    void activate() {
        users = userService.all();
    }

    @OnEvent(EventConstants.PREPARE)
    void prepareUser(final int id) {
        user = userService.get(id);
    }

    @OnEvent(EventConstants.PREPARE)
    void prepareUser() {
        if (user == null) {
            user = new User();
        }
    }

    @OnEvent(EventConstants.SUCCESS)
    Object saveUser() {
        userService.save(user);

        return this;
    }

    @OnEvent(value = "addUser")
    Object addUser() {
        return formModal.show();
    }

    @OnEvent(value = "editUser")
    Object editUser(final int id) {
        return formModal.show(id);
    }
}

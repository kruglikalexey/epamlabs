package com.epam.labs.lab9.src.mvc;

import com.epam.labs.lab9.src.domain.User;
import com.epam.labs.lab9.src.mvc.form.bean.UserFormBean;
import com.epam.labs.lab9.src.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/adduser.form")
public class UserFormController {

    private UserService userService;

    @ModelAttribute("userFormBean")
    public com.epam.labs.lab9.src.mvc.form.bean.UserFormBean getUserFormBean() {

        return new com.epam.labs.lab9.src.mvc.form.bean.UserFormBean();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {

        return "adduserform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processSubmit(UserFormBean userFormBean, Errors errors) {

        if (errors.hasErrors()) {
            return  new ModelAndView("adduserform");
        } else {

            List<User> userList;
            User user = new User();
            user.setFirstName(userFormBean.getFirstName());
            user.setLastName(userFormBean.getLastName());

            userService.saveUser(user);
            userList = userService.loadAllUsers();

            ModelAndView mav = new ModelAndView("userlistview");
            mav.addObject("userList", userList);

            return mav;
        }
    }

    @Autowired
    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
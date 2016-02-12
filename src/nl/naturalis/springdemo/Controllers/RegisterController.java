package nl.naturalis.springdemo.Controllers;

import nl.naturalis.springdemo.DatabaseControllers.UserDao;
import nl.naturalis.springdemo.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sjoerd.thijsse on 11/02/2016.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    protected static final String VIEW_REGISTER = "register";
    private static final String VIEW_REGISTER_SUCCESS = "register_success";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.info(VIEW_REGISTER);
        return VIEW_REGISTER;
    }


    @RequestMapping(value = "/success/", method = RequestMethod.POST)
    public String success(@RequestParam String username, @RequestParam String password,
                          @RequestParam String passwordAgain, @RequestParam String email, ModelMap model) {
        if(username.isEmpty() || password.isEmpty() || passwordAgain.isEmpty() || email.isEmpty()) {
            model.addAttribute("error", "Not all fields are filled!");
        } else if(!password.equals(passwordAgain)) {
            model.addAttribute("error", "Passwords do not match!");
        } else {
            User user = new User(username, password, email);
            if(UserDao.getInstance().insert(user) > 0) {
                return VIEW_REGISTER_SUCCESS;
            } else {
                model.addAttribute("error", "Username already exists!");
            }
        }
        return VIEW_REGISTER;
    }



}
